package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.Check;
import com.ychs.bean.FillBlank;
import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoices;
import com.ychs.bean.Paper;
import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoices;
import com.ychs.bean.TestResult;
/**
* 学生考试功能，Dao层实现层
* @author 李少石
* @version 2018-04-11
*/
@Repository
public class StudentExamDao implements IStudentExamDao {

	/**
	 * SqlSession工厂
	 */
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 查询全部试卷
	 * @param map 查询条件(空：查询全部)
	 * @return 试卷
	 */
	public List<Paper> selectPapers(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectpapers.in*************");
		List<Paper> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		list = studentExamDao.selectPapers(map);
		log.debug("*************"+list);
		log.debug("*************StudentExamDao.selectpapers.out*************");
		return list;
	}

	/**
	 * 查询指定试卷的试卷内容
	 * 
	 * @param map 查询条件（paper_id:按id查询）
	 * @return 试卷的试题
	 */
	public Paper selectPaper(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectpaper.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		Paper paper = studentExamDao.selectPaper(map);
		log.debug("*************"+paper);
		log.debug("*************StudentExamDao.selectpaper.out*************");
		return paper;
	}

	/**
	 * 查询单选题
	 * @param map(singChoice_id:单选题的id)
	 * @return 单选题
	 */
	public SingleChoice selectSingleChoice(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectSingleChoice.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		SingleChoice singleChoice=studentExamDao.selectSingleChoice(map);
		log.debug("*************"+singleChoice);
		log.debug("*************StudentExamDao.selectSingleChoice.out*************");
		return singleChoice;
	}

	/**
	 * 修改单选题，此处主要用于修改该题的使用次数、正确次数、正确率
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int updateSingleChoice(Map<String, Object> map) {
		log.debug("*************StudentExamDao.updateSingleChoice.in*************");
		int res = 0;
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		res = studentExamDao.updateSingleChoice(map);
		log.debug(res+"行已修改！*************");
		log.debug("*************StudentExamDao.updateSingleChoice.out*************");
		return res;
	}

	/**
	 * 查询判断题
	 * 
	 * @param map
	 * @return 判断题
	 */
	public Check selectCheck(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectCheck.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		Check check = studentExamDao.selectCheck(map);
		log.debug("*************"+check);
		log.debug("*************StudentExamDao.selectCheck.out*************");
		return check;
	}

	/**
	 * 修改判断题
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int updateCheck(Map<String, Object> map) {
		log.debug("*************StudentExamDao.updateCheck.in*************");
		int res = 0;
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		res = studentExamDao.updateCheck(map);
		log.debug(res+"行已修改！*************");
		log.debug("*************StudentExamDao.updateCheck.out*************");
		return res;
	}

	/**
	 * 查询多选题题目
	 * 
	 * @return 多选题
	 */
	public MultipleChoice selectMultipleChoice(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectMultipleChoice.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		MultipleChoice multipleChoice=studentExamDao.selectMultipleChoice(map);
		log.debug(multipleChoice);
		log.debug("*************StudentExamDao.selectMultipleChoice.out*************");
		return multipleChoice;
	}
	/**
	 * 查询多选题的选项
	 */
	public List<MultipleChoices> selectMultipleChoices(Map<String, Object> map){
		log.debug("*************StudentExamDao.selectMultipleChoices.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		List<MultipleChoices> multipleChoices=studentExamDao.selectMultipleChoices(map);
		log.debug("*************"+multipleChoices);
		log.debug("*************StudentExamDao.selectMultipleChoices.out*************");
		return multipleChoices;
	}
	/**
	 * 修改多选题
	 * @param map
	 * @return 影响行数
	 */
	public int updateMultipleChoice(Map<String, Object> map) {
		int result = 0;
		log.debug("*************StudentExamDao.updateMultipleChoice.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		result = studentExamDao.updateMultipleChoice(map);
		log.debug("*************StudentExamDao.updateMultipleChoice.out*************");
		return result;
	}

	/**
	 * 查询填空题题目
	 * @param map
	 * @return 填空题
	 */
	public FillBlank selectFillBlank(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectFillBlank.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		FillBlank fillBlank = studentExamDao.selectFillBlank(map);
		log.debug("*************"+fillBlank);
		log.debug("*************StudentExamDao.selectFillBlank.out*************");
		return fillBlank;
	}

	/**
	 * 修改填空题
	 * 
	 * @param map
	 * @return 影响行数
	 */
	public int updateFillBlank(Map<String, Object> map) {
		int result = 0;
		log.debug("*************StudentExamDao.updateFillBlank.in*************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		result = studentExamDao.updateFillBlank(map);
		log.debug("*************StudentExamDao.updateFillBlank.out*************");
		return result;
	}

	/**
	 * 学生向答题表中提交答题结果
	 * @param map 
	 * @return 影响行数
	 */
	public int insertTestResult(Map<String, Object> map) {
		log.debug("*************StudentExamDao.insertTestResult.in*************");
		int res = 0;
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		res = studentExamDao.insertTestResult(map);
		log.debug(res+"行已插入*************");
		log.debug("*************StudentExamDao.insertTestResult.out*************");
		return res;
	}

	/**
	 * 查询学生答过的试题
	 * @param map
	 * @return 学生答过的试题
	 */
	public List<TestResult> selectTestResults(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectTestResult.in*************");
		List<TestResult> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		list = studentExamDao.selectTestResults(map);
		log.debug("*************"+list);
		log.debug("*************StudentExamDao.selectTestResult.out*************");
		return list;
	}

	/**
	 * 查询单选题选项
	 */
	public List<SingleChoices> selectSingleChoices(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectSingleChoices.in*************");
		List<SingleChoices> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		list = studentExamDao.selectSingleChoices(map);
		log.debug("*************"+list);
		log.debug("*************tudentExamDao.selectSingleChoices.out*************");
		return list;
	}

	

	/**
	 * 查询学生已经做过的指定试卷的结果
	 */
	public TestResult selectTestResult(Map<String, Object> map) {
		log.debug("*************StudentExamDao.selectTestResult.in*************");
		TestResult testResult = null;
		SqlSession session = sqlSessionFactory.openSession();
		IStudentExamDao studentExamDao = session.getMapper(IStudentExamDao.class);
		testResult = studentExamDao.selectTestResult(map);
		log.debug("*************"+testResult);
		log.debug("*************StudentExamDao.selectTestResult.out*************");
		return testResult;
	}

}
