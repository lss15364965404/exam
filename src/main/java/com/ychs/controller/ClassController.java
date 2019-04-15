package com.ychs.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ychs.bean.Class;
import com.ychs.bean.ClassAndNum;
import com.ychs.service.IClassService;
import com.ychs.service.IUpLoadClService;
import com.ychs.service.IUserService;

import jxl.Sheet;
import jxl.Workbook;

/**
 * 班级controller
 * @author 李少石
 * @version 2018-04-19
 */
@Controller
public class ClassController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IClassService iClassService ;
	@Resource
	private IUserService iUserService ;
	@Resource
	private IUpLoadClService iUpLoadClService ;
	
	/**
	 * 班级管理页面
	 * @return
	 */
	@RequestMapping("/classesManage")
	public String classesManage(){
		log.debug("**********classesManage  controller in**********");
		log.debug("**********classesManage  controller out**********");
		return "classesManage";
	}
	
	/**
	 * 添加班级的页面
	 * @return
	 */
	@RequestMapping("/addClass")
	public String addClass(){
		log.debug("**********Class  addClass in**********");
		log.debug("**********Class  addClass out**********");
		return "addClass";
	}
	
	/**
	 * 添加班级及用户
	 * @return
	 */
	@RequestMapping(value="/addCl",method=RequestMethod.POST)
	@ResponseBody
	public String addClass(String data){
		String result = "success";
		log.debug("**********Class  addClass in**********");
		log.debug("**********Class  addClass data:"+data+"**********");
		//将data转化为json数据
		JSONObject J =JSON.parseObject(data);//parse:从一个字符串中解析出json对象
		log.debug("*********" + J);
		//获取key值，将其转化为数组
		Object[] keys = J.keySet().toArray();
		for(int i = 0;i<keys.length;i++) {
			log.debug("*********keys["+i+"]" + keys[i]);
		}
		//获取value值，将其转化为数组
		Object[] values = J.values().toArray();
		for(int i = 0;i<values.length;i++) {
			log.debug("*********values["+i+"]" + values[i]);
		}
		//将获得json数据转换为map
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i=0;i<keys.length;i++){
			map.put((String)keys[i], (String)values[i]);
		}
		
		/*//通过class_name查询class_id
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("class_name", (String) map.get("class_name"));
		List<Class> class_stu = iClassService.selectClassByCondition(map1);
		String class_id = class_stu.get(0).getClass_id(); 
		//Integer.parseInt(class_id);
		map.put("class_id", Integer.parseInt(class_id));*/
		//循环显示map中的键值
		for(String s:map.keySet()){
			log.debug("**********Class  addClass   key : "+s+" value : "+map.get(s));
        }
		
		boolean addT = iClassService.addClass(map);
		if(addT==true){
			log.debug("*************提交成功了   ajax返回结果 success");
			result = "success";
		}
		
		log.debug("**********Class  addClass out**********");
		return result;
	}
	
	/**
	 * 通过上传文件添加班级
	 * @return
	 */
	@RequestMapping(value="/uploadCl",method=RequestMethod.POST)
	@ResponseBody
	public String uploadCl(@RequestParam(value="file",required = false)MultipartFile file,
			HttpServletRequest request, HttpServletResponse response){
		String result = "faules";
		log.debug("**********Class  uploadCl in**********");
		try {
			result = iUpLoadClService.javaPoi(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = JSON.toJSONString(result);
		res= "{\"code\":0,\"msg\":\"  \",\"data\":"+res+"}";
		log.debug("**********Class  uploadCl res:"+res+"**********");
		log.debug("**********Class  uploadCl out**********");
		return res;
	}
	
	/**
	 * 按条件查询班级
	 * @return
	 */
	@RequestMapping(value="/selectClass",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectClass(String class_name,String page,String limit,HttpSession session){
		log.debug("********************************Class  selectClass in********************************");
		List<Class> list = null;
		log.debug("********************************Class  selectClass class_name:"+class_name+"********************************");

		session.setAttribute("class_id", 1);
		
		log.debug("********************************class_name" + class_name );
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("class_name", class_name);
		map.put("page1", page);
		map.put("limit1", limit);
		
		list = iClassService.selectClassByCondition(map);
		
		int length = iClassService.selectCounts();
		//查询学生数的map集合
		Map<String, Object> map1 = new HashMap<String, Object>();
		//Map<String, Object> map2 = new HashMap<String, Object>();
				List<ClassAndNum> list_classAndNum = new  ArrayList<ClassAndNum>();
				Class class_list = new Class();
				
				for( int i = 0 ; i < list.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
					class_list = list.get(i);
					ClassAndNum class_stu_num = new ClassAndNum();
					class_stu_num.setClass_id(class_list.getClass_id());
					class_stu_num.setClass_name(class_list.getClass_name());
					map1.put("class_name", (class_list.getClass_name()));
					class_stu_num.setClass_student_num(iClassService.selectClassStudentNum(map1));
					list_classAndNum.add(class_stu_num);
					//map2.put(""+i+"", class_stu_num);
					log.debug("********************************class_stu_num:" + class_stu_num);
					log.debug("********************************list_classAndNum  for:" + list_classAndNum);
				}
		log.debug("********************************list_classAndNum:" + list_classAndNum);
		
		
		String str = JSON.toJSONString(list_classAndNum);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("********************************jihe:" + str);
		log.debug("********************************Class  selectClass  out********************************");
		return str;
	}
	
}
