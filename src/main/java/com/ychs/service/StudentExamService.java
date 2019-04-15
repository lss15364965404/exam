package com.ychs.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 学生考试Service层，实现层
 * @author 李少石
 * @version 2018-04-11
 */

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.Check;
import com.ychs.bean.FillBlank;
import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoices;
import com.ychs.bean.Paper;
import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoices;
import com.ychs.bean.TestResult;
import com.ychs.dao.IStudentExamDao;

/**
 * 学生考试Service层
 * @author 李少石
 * @version 2018-03-26
 */
@Service
public class StudentExamService implements IStudentExamService {

	/**
	 * SqlSession工厂
	 */
	@Resource
	private IStudentExamDao studentExamDao;
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 查询全部试卷
	 * @param map 查询条件
	 * @return 试卷
	 */
	public List<Paper> getpapers(Map<String, Object> map) {
		log.debug("*************StudentExamService.getpapers.in*************");
		List<Paper> list = null;
		list = studentExamDao.selectPapers(map);
		log.debug("*************"+list);
		log.debug("*************StudentExamService.getpapers.out*************");
		return list;
	}

	/**
	 * 查询指定试卷的试卷内容
	 * @param map 查询条件
	 * @return 试卷的试题
	 *   1、先查询到Paper对象
	 *   2、Paper对象分别查出单选题id、判断题id、多选题id、填空题id
	 *   3、将id分割成数组，通过分割好的数组id查询出题目的内容 答案 选项
	 *   4、将 查询出的题目内容 答案 选项 放进list1中
	 *   5、再将list1放进list中
	 *   6、把list放入map.
	 *   	
	 */
	public Map<String, Object> getpaper(Map<String, Object> map) {
		log.debug("*************StudentExamService.getpaper.in*************");
		Paper paper = studentExamDao.selectPaper(map);
		
		/**
		 * 获取试卷名称
		 */
		String paperName = paper.getPaper_name();
		
		/**
		 * 获取单选题数据
		 */
		//设置所有的单选题的集合list_single
		List list_single = new ArrayList<SingleChoices>();
		//获得单选题的所有id
		String SingleChoice_ids = paper.getSingleChoice_ids();
		//将所有的单选题id分割成数组
		String[] SingleChoice_id=SingleChoice_ids.split(",");
		//循环查出单选题的所有题目
		for(int i=0;i<SingleChoice_id.length;i++){
			//将单选题的题目和答案 选项放在list_singleChoice中
			List<Object> list_singleChoice = new ArrayList<Object>();
			
			Map<String,Object> map1 = new HashMap<String, Object>();
			map1.put("singleChoice_id", SingleChoice_id[i]);
			//获得单选表对象
			SingleChoice singleChoice = studentExamDao.selectSingleChoice(map1);
			//将单选题目和答案放进list_singleChoice中
			list_singleChoice.add(singleChoice);
			
			
			List<SingleChoices> list_singleChoices = new ArrayList<SingleChoices>();
			//查询出单选题选项
			list_singleChoices = studentExamDao.selectSingleChoices(map1);
			//将查出的 单选选项 集合放在list_singleChoice中
			list_singleChoice.add(list_singleChoices);
			
			//将所有的单选题放在list_single中
			list_single.add(list_singleChoice);
		}
		
		/**
		 * 获取多选题数据
		 */
		//设置所有的多选题的集合list_multiple
		List<Object> list_multiple = new ArrayList<Object>();
		//获得多选题的所有id
		String multiplechoice_ids = paper.getMultipleChoice_ids();
		//将所有的多选题id分割成数组
		String[] multiplechoice_id=multiplechoice_ids.split(",");
		//循环查出多选题的所有题目
		for(int i=0;i<multiplechoice_id.length;i++){
			//将多选题的题目和答案 选项放在list_multiplechoice中
			List list_multiplechoice = new ArrayList<SingleChoice>();
			log.debug("*************多选id:"+multiplechoice_id[i]);
			Map<String,Object> map1 = new HashMap<String, Object>();
			map1.put("multipleChoice_id", multiplechoice_id[i]);
			//获得多选表对象
			MultipleChoice multipleChoice = studentExamDao.selectMultipleChoice(map1);
			//将多选题目和答案放进list_singleChoice中
			list_multiplechoice.add(multipleChoice);
			
			
			List<MultipleChoices> list_multipleChoices = new ArrayList<MultipleChoices>();
			//查询出多选题选项
			list_multipleChoices = studentExamDao.selectMultipleChoices(map1);
			//将查出的多选题的选项放在list_multiplechoice中
			list_multiplechoice.add(list_multipleChoices);
			/*for(MultipleChoices multipleChoices :list_multipleChoices){
				//将多选选项内容放进list_singleChoice中
				list_multiplechoice.add(multipleChoices);
			}*/
			//将所有的多选题放在list_single中
			list_multiple.add(list_multiplechoice);
		}
		
		/**
		 * 获取判断题数据
		 */
		//设置所有的判断题的集合list_multiple
		List<Object> list_check = new ArrayList<Object>();
		//获得判断题的所有id
		String check_ids = paper.getCheck_ids();
		//将所有的判断题id分割成数组
		String[] check_id=multiplechoice_ids.split(",");
		//循环查出判断题的所有题目
		for(int i=0;i<check_id.length;i++){
			//将判断题的题目和答案 放在list_check1中
			List<Check> list_check1 = new ArrayList<Check>();
			log.debug("*************判断id:"+check_id[i]);
			Map<String,Object> map1 = new HashMap<String, Object>();
			map1.put("check_id", check_id[i]);
			//获得判断表对象
			Check check = studentExamDao.selectCheck(map1);
			//将判断题目和放进list_check1中
			list_check1.add(check);
			
			//将所有的判断题放在list_check中
			list_check.add(list_check1);
		}
		
		/**
		 * 获取填空题数据
		 */
		//设置所有的填空题的集合list_fillBlank
		List<Object> list_fillBlank = new ArrayList<Object>();
		//获得填空题的所有id
		String fillBlank_ids = paper.getFillBlank_ids();
		//将所有的填空题id分割成数组
		String[] fillBlank_id=fillBlank_ids.split(",");
		//循环查出填空题的所有题目
		for(int i=0;i<fillBlank_id.length;i++){
			//将填空题的题目和答案 放在list_fillBlank1中
			List<FillBlank> list_fillBlank1 = new ArrayList<FillBlank>();
			log.debug("*************填空id:"+fillBlank_id[i]);
			Map<String,Object> map1 = new HashMap<String, Object>();
			map1.put("fillBlank_id", fillBlank_id[i]);
			//获得填空表对象
			FillBlank FillBlank = studentExamDao.selectFillBlank(map1);
			//将填空题目和放进list_fillBlank1中
			list_fillBlank1.add(FillBlank);
			
			//将所有的填空题放在list_fillBlank中
			list_fillBlank.add(list_fillBlank1);
		}
		/**
		 * 将获取到的题目 答案 选项 放进map中
		 */
		Map<String,Object> maps = new HashMap<String, Object>(); 
		//将试卷名称放进map中
		maps.put("list_paperName", paperName);
		//将所有的单选题放进map中
		maps.put("list_single", list_single);
		//将所有的多选题放进map中
		maps.put("list_multiple", list_multiple);
		//将所有的判断题放进map中
		maps.put("list_check", list_check);
		//将所有的填空题放进map中
		maps.put("list_fillBlank", list_fillBlank);
		log.debug("*************"+maps);
		log.debug("*************StudentExamService.getpaper.out*************");
		return maps;
	}

	/**
	 * 提交试卷
	 * @param map 提交带的参数
	 * 参数介绍：	paper_id 所做试卷的id
	 *     		student_id   学生id
	 *     		studentSingleChoice_answers  学生所做的单选题
	 *     		studentCheck_answers   学生做的判断题答案
	 *     		studentFillBlank_answers   学生做的填空题答案
	 *     		studentMultipleChoice_answers  学生做的多选题答案
	 * @return 提交结果true/false
	 * 完成功能：	1、通过所做的试卷id查询得到试卷对象
	 * 			2、把学生做题的结果放入结果表中
	 *   	  	3、改变每道题的使用次数、正确次数、正确率
	 *   			1、通过提交的试卷id查询出没到题的id，放入数组
	 *   			2、再对每一道题的使用次数、正确次数、正确率存入对应的表中（修改）
	 */
	public boolean commit(Map<String, Object> map) {
		log.debug("*************StudentExamService.commit.in*************");
		boolean res = false;
		
		//通过试卷id获得试卷对象  paper_id
		Paper paper = studentExamDao.selectPaper(map);
		log.debug("*************试卷信息："+paper);

		//获取试卷中各个题型的正确答案
		String right_singleChoice_answers = paper.getSingleChoice_answers();	//得到试卷中单选题的答案
		log.debug("*************单选题正确答案："+right_singleChoice_answers);
		String right_check_answers = paper.getCheck_answers();	//得到判断题的答案
		log.debug("*************判断题正确答案："+right_check_answers);
		String right_fillBlank_answers = paper.getFillBlank_answers();	//填空题答案
		log.debug("*************填空题正确答案："+right_fillBlank_answers);
		String right_multipleChoice_answers = paper.getMultipleChoice_answers();	//多选题答案
		log.debug("*************多选题正确答案："+right_multipleChoice_answers);
		
		//试卷正确答案拆分成数组
		String[] right_singleChoice_answers_s = right_singleChoice_answers.split(",");
		String[] right_check_answers_s = right_check_answers.split(",");
		String[] right_fillBlank_answers_s = right_fillBlank_answers.split(",");
		String[] right_multipleChoice_answers_s = right_multipleChoice_answers.split("\\*");
		
		//通过参数传入获得学生答案
		String studentSingleChoice_answers = map.get("studentSingleChoice_answers").toString();
		log.debug("*************单选题学生答案："+studentSingleChoice_answers);
		String studentCheck_answers = map.get("studentCheck_answers").toString();
		log.debug("*************判断题学生答案："+studentCheck_answers);
		String studentFillBlank_answers = map.get("studentFillBlank_answers").toString();
		log.debug("*************填空题学生答案："+studentFillBlank_answers);
		String studentMultipleChoice_answers = map.get("studentMultipleChoice_answers").toString();
		log.debug("*************多选题学生答案："+studentMultipleChoice_answers);

		//通过把学生做题的答案拆分成数组
		String[] student_singleChoice_answers_s = studentSingleChoice_answers.split(",");
		String[] student_check_answers_s = studentCheck_answers.split(",");
		String[] student_fillBlank_answers_s = studentFillBlank_answers.split(",");
		String[] student_multipleChoice_answers_s = studentMultipleChoice_answers.split("\\@");
		
		
		
		//学生答题结果与试卷正确答案对比，判断对于错
		int[] result_singleChoice = new int[right_singleChoice_answers_s.length];
		int[] result_check = new int[right_check_answers_s.length];
		int[] result_fillBlank = new int[right_fillBlank_answers_s.length];
		int[] result_multipleChoice = new int[right_multipleChoice_answers_s.length];
			//记录每种题的正确次数
		int right_singleChoice = 0;
		int right_check = 0;
		int right_fillBlank = 0;
		int right_multipleChoice = 0;
			//判断提交结果是否有误
		log.debug("****************单选题正确答案长度:"+right_singleChoice_answers_s.length);
		log.debug("****************单选题学生答案长度:"+student_singleChoice_answers_s.length);
		log.debug("****************判断题正确答案长度:"+right_check_answers_s.length);
		log.debug("****************判断题学生答案长度:"+student_check_answers_s.length);
		log.debug("****************填空题正确答案长度:"+right_fillBlank_answers_s.length);
		log.debug("****************填空题学生答案长度:"+student_fillBlank_answers_s.length);
		log.debug("****************多选题正确答案长度:"+right_multipleChoice_answers_s.length);
		log.debug("****************多选题学生答案长度:"+student_multipleChoice_answers_s.length);
		/**
		 * 以下比对只是比对答案个数，
		 * 修改：答案个数有误时也应记录
		 */
		if(right_singleChoice_answers_s.length != student_singleChoice_answers_s.length || right_check_answers_s.length != student_check_answers_s.length || right_fillBlank_answers_s.length != student_fillBlank_answers_s.length || right_multipleChoice_answers_s.length != student_multipleChoice_answers_s.length){
			//提交结果有误
			log.debug("******************提交所做题目数结果有误！*****************");
		}else{
			log.debug("******************提交所做题目数结果正确！*****************");

			//提交结果正确，进行判断正确性，并记录各种题的正确个数
				//单选题判断
			for(int i=0;i<right_singleChoice_answers_s.length;i++){
				if(right_singleChoice_answers_s[i].equals(student_singleChoice_answers_s[i])){
					result_singleChoice[i] = 1;
					right_singleChoice++;
				}else{
					result_singleChoice[i] = 0;
				}
			}
				//判断题判断
			for(int i=0;i<right_check_answers_s.length;i++){
				if(right_check_answers_s[i].equals(student_check_answers_s[i])){
					result_check[i] = 1;
					right_check++;
				}else{
					result_check[i] = 0;
				}
			}
				//填空题判断
			for(int i=0;i<right_fillBlank_answers_s.length;i++){
				if(right_fillBlank_answers_s[i].equals(student_fillBlank_answers_s[i])){
					result_fillBlank[i] = 1;
					right_fillBlank++;
				}else{
					result_fillBlank[i] = 0;
				}
			}
				//多选题判断
			for(int i=0;i<right_multipleChoice_answers_s.length;i++){
				if(right_multipleChoice_answers_s[i].equals(student_multipleChoice_answers_s[i])){
					result_multipleChoice[i] = 1;
					right_multipleChoice++;
				}else{
					result_multipleChoice[i] = 0;
				}
			}
			
			//获得试卷中各种题型的单个题的分值，根据分值来计算学生的总分值
				//每种题的单个题的分值
			float singleChoice_score = Float.parseFloat(paper.getSingleChoice_score());
			float check_score = Float.parseFloat(paper.getCheck_score());
			float fillBlank_score = Float.parseFloat(paper.getFillBlank_score());
			float multipleChoice_score = Float.parseFloat(paper.getMultipleChoice_score());
				//计算学生的总分值
			float testResult_grade = singleChoice_score*right_singleChoice+check_score*right_check+fillBlank_score*right_fillBlank+multipleChoice_score*right_multipleChoice;
			
			//学生答题结果提交（包括分值）
			int result_flag = 0;    //是否全部正确执行的记录变量
			map.put("testResult_grade", testResult_grade);
			int resinsertResult = 0;
			resinsertResult = studentExamDao.insertTestResult(map);
			if(resinsertResult == 1){
				result_flag++;   //result_flag==1；；学生答题结果提交成功
				log.debug("*************答案提交成功！！！！！*************");
			}
			
		/**
		 * 每种题的使用次数、正确次数、正确率计算//并且跟新数据库
		 */
			//当全部跟新完毕时，跟新成功！
				//获得每种题的题型的id，拆分成数组
			String[] singChoice_ids = paper.getSingleChoice_ids().split(",");
			String[] check_ids = paper.getCheck_ids().split(",");
			String[] fillBlank_ids = paper.getFillBlank_ids().split(",");
			String[] multipleChoice_ids = paper.getMultipleChoice_ids().split(",");
			
			/**
			 * 单选题使用次数、正确次数、正确率的更新
			 */
			for(int i=0;i<singChoice_ids.length;i++){
					//得到该单选题对象
				map.put("singleChoice_id", singChoice_ids[i]);
				SingleChoice singChoice = studentExamDao.selectSingleChoice(map);
					//得到该题的使用次数、正确次数、正确率
				int old_useNum = Integer.parseInt(singChoice.getSingleChoice_useNum());
				int old_rightNum = Integer.parseInt(singChoice.getSingleChoice_rightNum());
				float old_accuracy = Float.parseFloat(singChoice.getSingleChoice_accuracy());
				int new_useNum = old_useNum+1;
				int new_rightNum = old_rightNum;
				float new_accuracy = old_accuracy;
				
				if(result_singleChoice[i] == 1){
					new_rightNum++;
				}else{
					
				}
					//计算新的正确率
				new_accuracy = ((float)new_rightNum)/new_useNum;
				
				map.put("new_useNum",new_useNum);
				map.put("new_rightNum", new_rightNum);
				map.put("new_accuracy", new_accuracy);
				int resupdateSingle = 0;
				resupdateSingle = studentExamDao.updateSingleChoice(map);
				if(resupdateSingle == 1){
					result_flag=2;   //result_flag==2；；单选题提交成功
					log.debug("*************单选题第"+i+"数据更新成功！！");
				}
			}
			/**
			 * 判断题使用次数、正确次数、正确率的更新
			 */
			for(int i=0;i<check_ids.length;i++){
					//得到判断题对象
				map.put("check_id", check_ids[i]);
				Check check = studentExamDao.selectCheck(map);
					//得到判断题的使用使用次数，正确次数，正确率
				int old_useNum = Integer.parseInt(check.getCheck_useNum());
				int old_rightNum = Integer.parseInt(check.getCheck_rightNum());
				float old_accuracy = Float.parseFloat(check.getCheck_accuracy());
				int new_useNum = old_useNum+1;
				int new_rightNum = old_rightNum;
				float new_accuracy = old_accuracy;
				
				if(result_check[i] == 1){
					new_rightNum++;
				}else{
					
				}
					//计算新的正确率
				new_accuracy = ((float)new_rightNum)/new_useNum;
				
				map.put("new_useNum",new_useNum);
				map.put("new_rightNum", new_rightNum);
				map.put("new_accuracy", new_accuracy);
				int resupdateCheck = 0;
				resupdateCheck = studentExamDao.updateCheck(map);
				if(resupdateCheck == 1){
					result_flag=2;   //result_flag==2；；判断题提交成功
					log.debug("*************判断题第"+i+"数据更新成功！！*************");
				}
			}
			/**
			 * 填空题使用次数、正确次数、正确率的更新
			 */
			for(int i = 0;i<right_fillBlank_answers_s.length;i++){
					//得到填空题对象
				map.put("fillBlank_id",fillBlank_ids[i]);
				FillBlank fillBlank = studentExamDao.selectFillBlank(map);
					//得到填空题的使用次数，正确次数、正确率
				int old_useNum = Integer.parseInt(fillBlank.getFillBlank_useNum());
				int old_rightNum = Integer.parseInt(fillBlank.getFillBlank_rightNum());
				float old_accuracy = Float.parseFloat(fillBlank.getFillBlank_accuracy());
				int new_useNum = old_useNum+1;
				int new_rightNum = old_rightNum;
				float new_accuracy = old_accuracy;
				
				if(result_fillBlank[i] == 1){
					new_rightNum++;
				}else{
					
				}
					//计算新的正确率
				new_accuracy = ((float)new_rightNum)/new_useNum;
				
				map.put("fillBlank_useNum",new_useNum);
				map.put("fillBlank_rightNum", new_rightNum);
				map.put("fillBlank_accuracy", new_accuracy);
				int resupdateFillBlank = 0;
				resupdateFillBlank = studentExamDao.updateFillBlank(map);
				if(resupdateFillBlank == 1){
					result_flag=2;   //result_flag==2；；填空题提交成功
					log.debug("*************填空题第"+i+"数据更新成功！！*************");
				}
			}
			/**
			 * 多选题使用次数、正确次数、正确率的更新
			 */
			for(int i=0;i<multipleChoice_ids.length;i++){
					//得到多选题对象
				map.put("multipleChoice_id", multipleChoice_ids[i]);
				MultipleChoice multipleChoice = studentExamDao.selectMultipleChoice(map);
					//得到多选题的使用次数、正确次数、正确率
				int old_useNum = Integer.parseInt(multipleChoice.getMultipleChoice_useNum());
				int old_rightNum = Integer.parseInt(multipleChoice.getMultipleChoice_rightNum());
				float old_accuracy = Float.parseFloat(multipleChoice.getMultipleChoice_accuracy());
				int new_useNum = old_useNum+1;
				int new_rightNum = old_rightNum;
				float new_accuracy = old_accuracy;
				
				if(result_multipleChoice[i] == 1){
					new_rightNum++;
				}else{
					
				}
					//计算新的正确率
				new_accuracy = ((float)new_rightNum)/new_useNum;
				
				map.put("multipleChoice_useNum",new_useNum);
				map.put("multipleChoice_rightNum", new_rightNum);
				map.put("multipleChoice_accuracy", new_accuracy);
				int resupdateMultipleChoice = 0;
				resupdateMultipleChoice = studentExamDao.updateMultipleChoice(map);
				if(resupdateMultipleChoice == 1){
					result_flag=2;   //result_flag==2；；多选题提交成功
					log.debug("*************填空题第"+i+"数据更新成功！！*************");
				}
			}
			//学生答题结果提交成功并且各个题的使用次数、正确率也更新完，返回true
			if(result_flag == 2){
				res = true;
				log.debug("*************单选题数据全部更新！！！*************");
			}else{
				res = false;
			}
		}
		log.debug("**************StudentExamService.commit.out**************");
		return res;
	}
	/**
	 * 得到学生做过的试题
	 * @param map
	 * @return 查询结果
	 */
	public List<TestResult> getTestResults(Map<String, Object> map) {
		log.debug("*************StudentExamService.getTestResult.in*************");
		List<TestResult> list = null;
		list = studentExamDao.selectTestResults(map);
		log.debug("*************"+list);
		log.debug("*************StudentExamService.getTestResult.out*************");
		return list;
	}

	/**
	 * 得到指定试卷的试卷内容
	 * @param map 查询条件
	 * @return 试卷的试题
	 */
	public TestResult getTestResult(Map<String, Object> map) {
		log.debug("*************StudentExamService.getPaper.in*************");
		TestResult testResult = null;
		testResult = studentExamDao.selectTestResult(map);
		log.debug("*************"+testResult);
		log.debug("*************StudentExamService.getPaper.out*************");
		return null;
	}

}
