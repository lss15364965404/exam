package com.ychs.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ychs.bean.Check;
import com.ychs.bean.FillBlank;
import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoiceAndTeacher;
import com.ychs.bean.MultipleChoices;
import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoiceAndTeacher;
import com.ychs.bean.SingleChoices;
import com.ychs.service.ICheckService;
import com.ychs.service.IFillBlankService;
import com.ychs.service.IMultipleChoiceService;
import com.ychs.service.IMultipleChoicesService;
import com.ychs.service.ISingleChoiceService;
import com.ychs.service.ISingleChoicesService;
import com.ychs.service.IUpLoadSinService;
import com.ychs.service.IUpLoadStService;
import com.ychs.service.IUpLoadWoService;

/**
 * 出题的controller
 * @author 薛康帅
 *
 */
@Controller
public class QuestionController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ISingleChoiceService iscs;		//单选题接口
	@Resource
	private ISingleChoicesService isscs;		//单选题选项接口
	@Resource
	private IMultipleChoiceService mc ;   //多选题接口
	@Resource
	private IMultipleChoicesService mcs ;  //单选题选项接口
	@Resource
	private ICheckService ck ;   //判断题接口
	@Resource
	private IFillBlankService fbs ;    //填空题接口
	@Resource
	private IUpLoadWoService iUpLoadWoService ;
	@Resource
	private IUpLoadSinService iUpLoadSinService ;
	
	/**
	 * 访问出题页面
	 * @return
	 */
	@RequestMapping("/addQuestion")
	public String addQuestion(){
		return "addQuestion";
	}
	
	
	/**
	 * 通过上传word文件添加试卷
	 * @return
	 */
	//@RequestMapping(value="/uploadWo",method=RequestMethod.POST)
	@RequestMapping(value="/uploadWo")
	@ResponseBody
	/*public String uploadWo(@RequestParam(value="file",required = false)MultipartFile file,
			HttpServletRequest request, HttpServletResponse response){*/
	public String uploadWo(HttpServletRequest request){
		String result = "faules";
		log.debug("**********QuestionController  uploadWo in**********");
		try {
			//result = iUpLoadWoService.javaPoi(file);
			result = iUpLoadSinService.javaPoi();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = JSON.toJSONString(result);
		res= "{\"code\":0,\"msg\":\"  \",\"data\":"+res+"}";
		log.debug("**********QuestionController  uploadWo res:"+res+"**********");
		log.debug("**********QuestionController  uploadWo out**********");
		return res;
	}
	
	
	/**
	 * 单选题的出题
	 * @param data
	 * @return
	 */
	@RequestMapping("/addSing")
	@ResponseBody
	public String addSing(String data){
		String result = null;
		log.debug("**********出题的  in**********");
		/*
		 * 将获得json数据转换为map
		 */
		JSONObject J =JSON.parseObject(data);
		//获取key值，将其转化为数组
		Object[] keys = J.keySet().toArray();
		//获取value值，将其转化为数组
		Object[] values = J.values().toArray();
		Map<String, String> map1 = new HashMap<String, String>();
		for(int i=0;i<keys.length;i++){
			map1.put((String)keys[i], (String)values[i]);
		}
		//添加到单选题表
		SingleChoice singleChoice = new SingleChoice();
		//教师id  如果有登录的时候在进行修改
		singleChoice.setTeacher_id("1");
		singleChoice.setSingleChoice_question(map1.get("question_body"));  //题干
		singleChoice.setSingleChoiceAnswer_id("0");  //题目答案id先设为0 后面进行修改
		singleChoice.setSingleChoice_stage(map1.get("question_stage"));  //题目阶段
		/*
		 * 使用次数  正确次数 正确率 先设为0
		 */
		singleChoice.setSingleChoice_useNum("0");
		singleChoice.setSingleChoice_rightNum("0");
		singleChoice.setSingleChoice_accuracy("0");
		iscs.addSingleChoice(singleChoice);
		//查询到单选题的id
		String singId = null;
		String stage = null;
		String page1 = null;
		String limit1 = null;
		List<SingleChoiceAndTeacher> list = iscs.selectByConditionAdd(stage, map1.get("question_body"),page1,limit1);
		for(SingleChoiceAndTeacher s:list){
			singId = s.getSingleChoice_id();
			log.debug("**********单选题的id"+singId);
		}
		boolean flag1 = false;
		boolean flag2 = false;
		/*
		 * 将错误选项添加进选项表
		 */
		String sws = map1.get("singleChoice_wrongAnswer");
		String[] sw=sws.split(",");
		SingleChoices singleChoices3 = new SingleChoices();
		String sws_id = "";
		for(int i = 0;i<sw.length;i++){
			log.debug("**********错误选项"+sw[i]);
			//上面查询到单选题的id 
			singleChoices3.setSingleChoice_id(singId);
		 	singleChoices3.setSingleChoice_choice(sw[i]);
		 	flag1 = isscs.addSingleChoices(singleChoices3);
		 	if(sws_id == "") {
			 	sws_id = sws_id + isscs.selectSingleChoices(singleChoices3).getSingleChoices_id();
		 	}else {
			 	sws_id = sws_id +","+ isscs.selectSingleChoices(singleChoices3).getSingleChoices_id();
		 	}
		}
		/*
		 * 将正确选项添加进选项表
		 */
		//添加到单选题选项表
		SingleChoices singleChoices = new SingleChoices();
		//上面查询到单选题的id 
		singleChoices.setSingleChoice_id(singId);
	 	singleChoices.setSingleChoice_choice(map1.get("singleChoice_rightAnswer"));
	 	flag2 = isscs.addSingleChoices(singleChoices);
	 	//获取到所有的答案id
	 	String right_id =  isscs.selectSingleChoices(singleChoices).getSingleChoices_id();
	 	sws_id = sws_id +","+ right_id;
	 	Map<String, String> map4 = new HashMap<String, String>();
	 	map4.put("singleChoice_id", singId);
	 	map4.put("singleChoiceRightAnswer_id", right_id);
		/**
		 * 更改单选题表
		 */
		SingleChoice singleChoice1 = new SingleChoice();
	
		/*for(int i = 0;i<sw.length;i++){
			singleChoiceAnswer_id = singleChoiceAnswer_id + ","+sw[i] ;
		}*/
		//查询出正确选项的id
		SingleChoices singleChoices2 = new SingleChoices();
		singleChoices2.setSingleChoice_choice(map1.get("singleChoice_rightAnswer"));
		
		singleChoice1.setSingleChoiceAnswer_id(sws_id);
		singleChoice1.setSingleChoice_id(singId);
		boolean flag3 = iscs.updateSingleChoice(singleChoice1);
		boolean flag4 = iscs.updateSingleChoiceRight(map4);
		
		
		log.debug("**********flag1:"+flag1);
		log.debug("**********flag2:"+flag2);
		log.debug("**********flag3:"+flag3);
	 	if(flag1==true&&flag2==true&&flag3==true){
	 		log.debug("**********成功**********");
	 		result = "success";
	 	}
	 	log.debug("**********result"+result);
	 	log.debug("**********出题的  out**********");
		return result;
	}
	/**
	 * 多选题的出题
	 * @param data
	 * @return
	 */
	@RequestMapping("/addMul")
	@ResponseBody
	public String addMul(String data){
		String result = null;
		log.debug("**********出题的  in**********");
		/*
		 * 将获得json数据转换为map
		 */
		JSONObject J =JSON.parseObject(data);
		//获取key值，将其转化为数组
		Object[] keys = J.keySet().toArray();
		//获取value值，将其转化为数组
		Object[] values = J.values().toArray();
		Map<String, String> map1 = new HashMap<String, String>();
		for(int i=0;i<keys.length;i++){
			map1.put((String)keys[i], (String)values[i]);
		}
		//添加到多选题表
		MultipleChoice multipleChoice = new MultipleChoice();
		//教师id  如果有登录的时候在进行修改
		multipleChoice.setTeacher_id("1");
		multipleChoice.setMultipleChoice_question(map1.get("question_body"));  //题干
		multipleChoice.setMultipleChoiceAnswer_ids("0");  //题目答案id先设为0 后面进行修改
		multipleChoice.setMultipleChoice_stage(map1.get("question_stage"));  //题目阶段
		/*
		 * 使用次数  正确次数 正确率 先设为0
		 */
		multipleChoice.setMultipleChoice_useNum("0");
		multipleChoice.setMultipleChoice_rightNum("0");
		multipleChoice.setMultipleChoice_accuracy("0");
		mc.addMultipleChoice(multipleChoice);
		//查询到多选题的id
		String singId = null;
		String stage = null;
		String page1 = null;
		String limit1 = null;
		List<MultipleChoiceAndTeacher>  list = mc.selectMuByCondition(stage,  map1.get("question_body"),page1,limit1);
		for(MultipleChoiceAndTeacher s:list){
			singId = s.getMultipleChoice_id();
			log.debug("**********多选题的id:"+singId);
		}
		boolean flag1 = false;
		
		/*
		 * 将错误选项和正确选项添加进选项表
		 */
		String sws1 = map1.get("multipleChoice_wrongAnswer");
		String sws = sws1 +","+ map1.get("multipleChoice_rightAnswer");
		String[] sw=sws.split(",");
		MultipleChoices multipleChoices = new MultipleChoices();
		for(int i = 0;i<sw.length;i++){
			log.debug("**********选项"+sw[i]);
			//上面查询到单选题的id 
			multipleChoices.setMultipleChoice_id(singId);
			multipleChoices.setMultipleChoice_choice(sw[i]);
		 	flag1 = mcs.addMultipleChoices(multipleChoices);
		}
		
		
		/*
		 * 查询出正确选项的id
		 */
		String ids = "";
		String mrs = map1.get("multipleChoice_rightAnswer");
		String mr[] = mrs.split(",");
		for(int i = 0;i<mr.length;i++){
			MultipleChoices multipleChoices1 = new MultipleChoices();
			multipleChoices1.setMultipleChoice_choice(mr[i]);
			ids =  ids + mcs.select(multipleChoices1).getMultipleChoices_id()+ ",";
		}
		
		//更改多选题表
		MultipleChoice multipleChoice2 = new MultipleChoice();
		multipleChoice2.setMultipleChoiceAnswer_ids(ids);
		multipleChoice2.setMultipleChoice_id(singId);
		boolean flag3 = mc.updateMultipleChoice(multipleChoice2);
		log.debug("**********flag1"+flag1);
		
		log.debug("**********flag3"+flag3);
	 	if(flag1==true&&flag3==true){
	 		log.debug("**********成功**********");
	 		result = "success";
	 	}
	 	log.debug("result"+result);
	 	log.debug("**********出题的  out**********");
		return result;
	}
		
	/**
	 * 判断题
	 * @param data
	 * @return
	 */
	@RequestMapping("/addCheck")
	@ResponseBody
	public String addCheck(String data){
		String result = null;
		log.debug("出题的  in");
		/*
		 * 将获得json数据转换为map
		 */
		JSONObject J =JSON.parseObject(data);
		//获取key值，将其转化为数组
		Object[] keys = J.keySet().toArray();
		//获取value值，将其转化为数组
		Object[] values = J.values().toArray();
		Map<String, String> map1 = new HashMap<String, String>();
		for(int i=0;i<keys.length;i++){
			map1.put((String)keys[i], (String)values[i]);
		}
		//添加到多选题表
		Check check = new Check();
		//教师id  如果有登录的时候在进行修改
		check.setTeacher_id("1");
		check.setCheck_question(map1.get("question_body"));  //题干
		check.setCheck_answer(map1.get("check_answer"));  //题目答案id先设为0 后面进行修改
		check.setCheck_stage(map1.get("question_stage"));  //题目阶段
		/*
		 * 使用次数  正确次数 正确率 先设为0
		 */
		check.setCheck_useNum("0");
		check.setCheck_rightNum("0");
		check.setCheck_accuracy("0");
		boolean flag = ck.addCheck(check);
		log.debug("flag"+flag);
		if(flag == true){
			result = "success";
		}
		log.debug("result"+result);
	 	log.debug("出题的  out");
		return result;
	}
	/**
	 * 填空题
	 * @param data
	 * @return
	 */
	@RequestMapping("/addFill")
	@ResponseBody
	public String addFill(String data){
		String result = null;
		log.debug("出题的  in");
		/*
		 * 将获得json数据转换为map
		 */
		JSONObject J =JSON.parseObject(data);
		//获取key值，将其转化为数组
		Object[] keys = J.keySet().toArray();
		//获取value值，将其转化为数组
		Object[] values = J.values().toArray();
		Map<String, String> map1 = new HashMap<String, String>();
		for(int i=0;i<keys.length;i++){
			map1.put((String)keys[i], (String)values[i]);
		}
		//添加到多选题表
		FillBlank fb = new FillBlank();
		//教师id  如果有登录的时候在进行修改
		fb.setTeacher_id("1");
		fb.setFillBlank_question(map1.get("question_body")); //题干
		fb.setFillBlank_answer(map1.get("fillBlank_answer"));  //题目答案id先设为0 后面进行修改
		fb.setFillBlank_stage(map1.get("question_stage"));  //题目阶段
		
		/*
		 * 使用次数  正确次数 正确率 先设为0
		 */
		fb.setFillBlank_useNum("0");
		fb.setFillBlank_rightNum("0");
		fb.setFillBlank_accuracy("0");
		boolean flag = fbs.addFillBlank(fb);
		log.debug("flag"+flag);
		if(flag == true){
			result = "success";
		}
	 	log.debug("出题的  out");
		return result;
	}
		
}
