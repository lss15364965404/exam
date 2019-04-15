package com.ychs.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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
import com.ychs.bean.TeacherAndUser;
import com.ychs.service.ITeacherService;
import com.ychs.service.IUpLoadClService;
import com.ychs.service.IUpLoadTeService;
import com.ychs.service.IUserService;

/**
 * 老师controller
 * @author 李少石
 * @version 2018-04-16
 */
@Controller
public class TeacherController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ITeacherService iTeacherService ;
	@Resource
	private IUserService iUserService ;
	@Resource
	private IUpLoadTeService iUpLoadTeService ;
	
	/**
	 * 老师管理页面
	 * @return
	 */
	@RequestMapping("/teachersManage")
	public String teachersManage(){
		log.debug("**********teachersManage  controller in**********");
		log.debug("**********teachersManage  controller out**********");
		return "teachersManage";
	}
	
	/**
	 * 添加老师的页面
	 * @return
	 */
	@RequestMapping("/addTeacher")
	public String addTeacher(){
		log.debug("**********Teacher  addTeacher in**********");
		log.debug("**********Teacher  addTeacher out**********");
		return "addTeacher";
	}
	
	/**
	 * 添加教师及用户
	 * @return
	 */
	@RequestMapping(value="/addTU",method=RequestMethod.POST)
	@ResponseBody
	public String addTeacherAndUser(String data){
		String result = "success";
		log.debug("**********Teacher  addTeacherAndUser in**********");
		log.debug("**********Teacher  addTeacherAndUser data:"+data+"**********");
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
		map.put("role", "教师");
		map.put("role_id", "2");
		map.put("user_name", map.get("teacher_name"));
		
		for(String s:map.keySet()){
		   System.out.println("**********Teacher  addTeacherAndUser   key : "+s+" value : "+map.get(s));
        }
		
		boolean addT = iTeacherService.addTeacher(map);
		boolean addU = iUserService.addUser(map);
		if(addT==true && addU==true){
			log.debug("*************提交成功了   ajax返回结果 success");
			result = "success";
		}
		
		log.debug("**********Teacher  addTeacherAndUser out**********");
		return result;
	}
	
	/**
	 * 通过上传文件添加教师及用户
	 * @return
	 */
	@RequestMapping(value="/uploadTe",method=RequestMethod.POST)
	@ResponseBody
	public String uploadTe(@RequestParam(value="file",required = false)MultipartFile file,
			HttpServletRequest request, HttpServletResponse response){
		String result = "faules";
		log.debug("**********Teacher  uploadTe in**********");
		try {
			result = iUpLoadTeService.javaPoi(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = JSON.toJSONString(result);
		res= "{\"code\":0,\"msg\":\"  \",\"data\":"+res+"}";
		log.debug("**********Teacher  uploadTe res:"+res+"**********");
		log.debug("**********Teacher  uploadTe out**********");
		return res;
	}
	
	/**
	 * 按条件查询教师
	 * @return
	 */
	@RequestMapping(value="/selectTeacher",produces = {"text/html;charset=UTF-8;"})
	//@RequestMapping(value="/selectTeacher")
	@ResponseBody
	public String selectTeacher(String username,String page,String limit,HttpSession session){
		log.debug("********************************Teacher  selectTeacher in********************************");
		List<TeacherAndUser> list = null;
		log.debug("********************************Teacher  selectTeacher username:"+username+"********************************");

		session.setAttribute("teacher_id", 1);
		
		log.debug("********************************username：" + username );
		list = iTeacherService.selectTeacherByCondition(username,page,limit);
		int length = iTeacherService.selectCounts();
		String str = JSON.toJSONString(list);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("********************************jihe:" + str);
		log.debug("********************************Teacher  selectTeacher  out********************************");
		return str;
	}
	
}
