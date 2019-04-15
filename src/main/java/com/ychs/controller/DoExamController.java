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
import com.ychs.service.IStudentExamService;

/**
 * 学生考试功能的Controller
 * @author 李少石
 * @version 2018-04-10
 */
@Controller
public class DoExamController {
	@Resource 
	private IStudentExamService studentExamService;
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * 访问考试页面
	 * @return
	 */
	@RequestMapping("/doExam")
	public String doExam(Map<String, Object> map,HttpSession session){
		map.put("paper_id", 1);
		//查找到指定试卷
		Map<String, Object> map1 = studentExamService.getpaper(map);
		//将题目传到前台页面
		session.setAttribute("list_paperName",map1.get("list_paperName"));
		session.setAttribute("list_single",map1.get("list_single"));
		session.setAttribute("list_multiple",map1.get("list_multiple"));
		session.setAttribute("list_check",map1.get("list_check"));
		session.setAttribute("list_fillBlank",map1.get("list_fillBlank"));
		return "doExam";
	}
	
	/**
	 * 提交答案
	 */
	@RequestMapping(value="/map", method=RequestMethod.POST)
	@ResponseBody
	public String requestList(String data) {
		String result = "false";
		/*
		 * 将获得json数据转换为map
		 */
		log.debug("***************从页面传回的结果****************");
		log.debug("*************学生答案："+data);

		JSONObject J =JSON.parseObject(data);//parse:从一个字符串中解析出json对象
		//获取key值，将其转化为数组
		Object[] keys = J.keySet().toArray();
		//获取value值，将其转化为数组
		Object[] values = J.values().toArray();
		Map<String, String> map1 = new HashMap<String, String>();
		for(int i=0;i<keys.length;i++){
			map1.put((String)keys[i], (String)values[i]);
		}
		/*
		 * 将选项答案拼接到map的一个key值中
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		//单选题答案的字符串
		StringBuffer s1 = new StringBuffer();
		//多选题答案的字符串
		StringBuffer s2 = new StringBuffer();
		//判断题答案的字符串
		StringBuffer s3 = new StringBuffer();
		//填空题答案的字符串
		StringBuffer s4 = new StringBuffer();
		//遍历所有的key值
		for(String s : map1.keySet()){
			//单选答案的拼接
			boolean flag = s.startsWith("singleChoice_choice");
			if(flag){
				s1.append(map1.get(s)+",");
			}

			//填空答案的拼接
			boolean flag3 = s.startsWith("fillBlank_choice");
			if(flag3){
				s3.append(map1.get(s)+",");
			}

			//判断答案的拼接
			boolean flag4 = s.startsWith("check_choice");
			if(flag4){
				s4.append(map1.get(s)+",");
			}

		}
		//多选答案的拼接
		for(int i = 1;i< 20;i++){
			for(String s_s : map1.keySet()){
				boolean flag2 = s_s.startsWith("multipleChoice_choice["+i+"]");
				if(flag2){
					s2.append(map1.get(s_s)+",");
				}
			}
			s2.append("@");
		}
		//拼接好的单选题答案
		map.put("studentSingleChoice_answers",s1.toString() );
		log.debug("*************单选答案拼接结果："+s1);

		//拼接好的多选题答案
		map.put("studentMultipleChoice_answers",s2.toString() );
		log.debug("*************多选答案拼接结果："+s2);

		//拼接好的填空题答案
		map.put("studentFillBlank_answers",s3.toString() );
		log.debug("*************填空答案拼接结果："+s3);

		//拼接好的判断题答案
		map.put("studentCheck_answers",s4.toString() );
		log.debug("*************判断答案拼接结果："+s4);

		map.put("student_id",map1.get("student_id") );
		map.put("paper_id",map1.get("paper_id") );
		
		boolean flag = studentExamService.commit(map);
		if(flag==true){
			log.debug("*************提交成功了   ajax返回结果 success");
			result = "success";
		}
	    return result;
	}
}
