package com.ychs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ychs.bean.User;
import com.ychs.service.IUserService;

/**
 * 登录controller
 * @author 李少石
 * @version 2018-04-09
 */
@Controller
public class LoginController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IUserService iUserService ;
	
	/**
	 * 修改密码页面
	 * @return
	 */
	@RequestMapping("/changePassword")
	public String changePassword(){
		log.debug("*************changePassword  controller in*************");
		log.debug("*************changePassword  controller out*************");
		return "changePassword";
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		log.debug("*************login  controller in*************");
		log.debug("*************login  controller out*************");
		return "login";
	}
	
	/**
	 * 登录查询
	 * @param userName
	 * @param pass
	 * @return
	 */
	@RequestMapping(value="/selectUser",method=RequestMethod.POST)
	@ResponseBody //作用：是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
	public String selectUser(String data,HttpSession session){
		String result = "false";
		log.debug("**************login  controller selectUser in**********");
		
		//data = "{'username':'李少石','password':'1420333'}";
		
		log.debug("*********" + data);
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
		
		User user = iUserService.selectUserByNamePass(map);
		
		log.debug("*********用户user：" + user.toString());
		if(user.getUsername().equals("查无此人")) {
			result = "noUser";
		}
		if(!(user.getUsername().equals("查无此人"))){
			log.debug("**************login  controller selectUser 跳转判断**************");
			log.debug("**************login  controller selectUser "+user.getRole_id()+"**************");

			if(Integer.parseInt(user.getRole_id()) == 1) {
				log.debug("**************login  controller selectUser 1----**************");
				session.setAttribute("role_id", 1);
				session.setAttribute("username", user.getUsername());
				result = "index_1";
				log.debug("**************login  controller selectUser 1++++**************");
			}else if(Integer.parseInt(user.getRole_id()) == 2) {
				log.debug("**************login  controller selectUser 2----**************");
				session.setAttribute("role_id", 2);
				session.setAttribute("username", user.getUsername());
				result = "index_2";
				log.debug("**************login  controller selectUser 2++++**************");
			}else if(Integer.parseInt(user.getRole_id()) == 3) {
				log.debug("**************login  controller selectUser 3----**************");
				session.setAttribute("role_id", 3);
				session.setAttribute("username", user.getUsername());
				result = "doExam";
				log.debug("**************login  controller selectUser 3++++**************");
			}
		}
		log.debug("**************login  controller selectUser result:"+result+"**************");
		log.debug("**************login  controller selectUser out**************");
		return result;
	}
	
	/**
	 * 修改密码
	 * @param data
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	@ResponseBody //作用：是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
	public String changePassword(String data,HttpSession session){
		String result = "false";
		log.debug("**************login  controller changePassword in**********");
		log.debug("*********login  controller changePassword data：" + data);
		//将data转化为json数据
		JSONObject J =JSON.parseObject(data);//parse:从一个字符串中解析出json对象
		log.debug("*********login  controller changePassword json：" + J);
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

		//调用service层方法
		String upPass = iUserService.updatePassword(map);
		
		log.debug("*********修改密码结果：" + upPass);
		result = upPass;
		log.debug("**************login  controller changePassword out**************");
		return result;
	}
	
	
	
}
