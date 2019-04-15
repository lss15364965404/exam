package com.ychs.controller;

import java.io.IOException;
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
import com.ychs.bean.StudentAndUser;
import com.ychs.bean.Class;
import com.ychs.service.IClassService;
import com.ychs.service.IStudentService;
import com.ychs.service.IUpLoadStService;
import com.ychs.service.IUpLoadTeService;
import com.ychs.service.IUserService;

/**
 * 学生controller
 * @author 李少石
 * @version 2018-04-16
 */
@Controller
public class StudentController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IStudentService iStudentService ;
	@Resource
	private IUserService iUserService ;
	@Resource
	private IClassService iClassService ;
	@Resource
	private IUpLoadStService iUpLoadStService ;
	
	/**
	 * 学生管理页面
	 * @return
	 */
	@RequestMapping("/studentsManage")
	public String studentsManage(){
		log.debug("**********studentsManage  controller in**********");
		log.debug("**********studentsManage  controller out**********");
		return "studentsManage";
	}
	
	/**
	 * 添加学生的页面
	 * @return
	 */
	@RequestMapping("/addStudent")
	public String addStudent(){
		log.debug("**********Student  addStudent in**********");
		log.debug("**********Student  addStudent out**********");
		return "addStudent";
	}
	
	/**
	 * 添加学生及用户
	 * @return
	 */
	@RequestMapping(value="/addSU",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addStudentAndUser(String data){
		String result = "success";
		log.debug("**********Student  addStudentAndUser in**********");
		log.debug("**********Student  addStudentAndUser data:"+data+"**********");
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
		map.put("role", "学生");
		map.put("role_id", "3");
		map.put("user_name", map.get("student_name"));
		
		//通过class_name查询class_id
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("class_name", (String) map.get("class_name"));
		List<Class> class_stu = iClassService.selectClassByCondition(map1);
		String class_id = class_stu.get(0).getClass_id(); 
		//Integer.parseInt(class_id);
		map.put("class_id", Integer.parseInt(class_id));
		//循环显示map中的键值
		for(String s:map.keySet()){
		   System.out.println("**********Student  addStudentAndUser   key : "+s+" value : "+map.get(s));
        }
		
		boolean addT = iStudentService.addStudent(map);
		boolean addU = iUserService.addUser(map);
		if(addT==true && addU==true){
			log.debug("*************提交成功了   ajax返回结果 success");
			result = "success";
		}
		
		log.debug("**********Student  addStudentAndUser out**********");
		return result;
	}
	
	/**
	 * 通过上传文件添加教师及用户
	 * @return
	 */
	@RequestMapping(value="/uploadSt",method=RequestMethod.POST)
	@ResponseBody
	public String uploadSt(@RequestParam(value="file",required = false)MultipartFile file,
			HttpServletRequest request, HttpServletResponse response){
		String result = "faules";
		log.debug("**********Student  uploadSt in**********");
		try {
			result = iUpLoadStService.javaPoi(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = JSON.toJSONString(result);
		res= "{\"code\":0,\"msg\":\"  \",\"data\":"+res+"}";
		log.debug("**********Student  uploadSt res:"+res+"**********");
		log.debug("**********Student  uploadSt out**********");
		return res;
	}
	
	/**
	 * 按条件查询学生
	 * @return
	 */
	@RequestMapping(value="/selectStudent",produces= {"text/html;charset=UTF-8"})
	@ResponseBody
	public String selectStudent(String username,String page,String limit,HttpSession session){
		log.debug("********************************Student  selectStudent in********************************");
		List<StudentAndUser> list = null;
		log.debug("********************************Student  selectStudent username:"+username+"********************************");

		session.setAttribute("student_id", 1);
		
		log.debug("********************************username" + username );
		list = iStudentService.selectStudentByCondition(username,page,limit);
		int length = iStudentService.selectCounts();
		String str = JSON.toJSONString(list);
		str= "{\"code\":0,\"msg\":\"  \",\"count\":\""+length+"\",\"data\":"+str+"}";
		log.debug("********************************jihe:" + str);
		log.debug("********************************Student  selectStudent  out********************************");
		return str;
	}
	
}
