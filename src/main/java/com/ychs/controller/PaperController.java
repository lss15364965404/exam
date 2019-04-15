package com.ychs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ychs.bean.Paper;
import com.ychs.service.IPaperService;

/**
 * 试卷controller
 * @author 李少石
 * @version 2018-03-19
 */
@Controller
public class PaperController {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IPaperService iPaperService ;
	
	/**
	 * 插入一条paper
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addPaperZH",method= RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody //作用：是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
	public String addPaper2(String data){
		
		log.debug("**********paper  controller in**********");
		
		//Paper paper =  JSON.parseObject(data,Paper.class);
		/*
		 * 将获得json数据转换为map
		 */
		JSONObject J =JSON.parseObject(data);
		//获取key值，将其转化为数组
		Object[] keys = J.keySet().toArray();
		//获取value值，将其转化为数组
		Object[] values = J.values().toArray();
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0;i<keys.length;i++){
			map.put((String)keys[i], (String)values[i]);
		}
		log.debug("**********paper  controller map:" + map);

		
		boolean b = iPaperService.addPaper(map);
		String str = "";
		if(b){
			str = "true";
		}else{
			str ="false";
		}
		log.debug("**********paper  controller out///" + str);
		return str;
	}
	/**
	 * 组卷
	 * @return
	 */
	@RequestMapping("/addPaper")
	public String add1(){
		
		log.debug("**********paper  controller in**********");
		
		log.debug("**********paper  controller out**********");
		return "addPaper";
	}
	
	/**
	 * 我出的题
	 * @return
	 */
	@RequestMapping("/myQuestions")
	public String myQuestions(){
		
		log.debug("**********myQuestions  controller in**********");
		
		log.debug("**********myQuestions  controller out**********");
		return "myQuestions";
	}
	
	/**
	 * 查看题库
	 * @return
	 */
	@RequestMapping("/viewQuestions")
	public String viewQuestions(){
		
		log.debug("**********viewQuestions  controller in**********");
		
		log.debug("**********viewQuestions  controller out**********");
		return "viewQuestions";
	}
	
	/**
	 * 欢迎界面
	 * @return
	 */
	@RequestMapping("/welcome")
	public String welcome(){
		
		log.debug("**********viewQuestions  controller in**********");
		
		log.debug("**********viewQuestions  controller out**********");
		return "welcome";
	}
	
	/**
	 * 我组的卷子
	 * @return
	 */
	@RequestMapping("/myPapers")
	public String add2(){
		
		log.debug("**********paper  controller in**********");
		
		log.debug("**********paper  controller out**********");
		return "myPapers";
	}
	
	/**
	 * 考试系统后台页面
	 * @return
	 */
	@RequestMapping("/index")
	public String indexF(){
		log.debug("**********index  controller in**********");
		log.debug("**********index controller out**********");
		return "index";
	}
	
	/**
	 * 查询试卷
	 * @param paperName
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/selectPaper", produces="text/html;charset=UTF-8")
	@ResponseBody //作用：是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
	public String selectPaper(String paperName,String page,String limit){
		
		log.debug("**********paper  controller selectPaper in**********");
		log.debug("*********paper  controller selectPape paperName：" + paperName);
		
		List<Paper> list = null;
		list = iPaperService.selectPaperService(paperName,page,limit);
		log.debug("*********paper  controller selectPape list:" + list);
		
		log.debug("*********paper  controller selectPape paperName：" + paperName);
		int length = 0;
		length = iPaperService.selectCountS();
		String json = JSON.toJSONString(list);
		log.debug("*********json:" + json);

		json= "{\"code\":0,\"msg\":\"\",\"count\":\""+length+"\",\"data\":"+json+"}";
		log.debug("**********paper  controller selectPaper out**********");
		return json;
	}
	
	
	
}
