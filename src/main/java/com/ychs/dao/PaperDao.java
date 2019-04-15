package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.Paper;

/**
 * 试卷dao
 * @author FENG
 * 
 */
@Repository
public class PaperDao implements IPaperDao {
	
	/**
	 * 创建Session要用到的session工厂对象
	 */
	@Resource	
	private SqlSessionFactory sqlSessionFactory;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 增加试卷
	 * @param paper	待增加的试卷
	 * @return	返回影响的行数
	 */
	@Override
	public int insert_paper(Map<String, String> map) {
		
		log.debug("**********PaperDao insert_paper in**********");
		
		int result = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		IPaperDao paperDao = session.getMapper(IPaperDao.class);
		result = paperDao.insert_paper(map);
	
		log.debug("**********PaperDao insert_paper out**********");
		return result;
	}

	/**
	 * 修改试卷内的单选题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	@Override
	public int update_paper_singleChoice(Paper paper) {
		log.debug("**********PaperDao update_paper_singleChoice in**********");

		int result = 0;
		
		//此处不需显示写明事务处理，事务由Spring容器处理
		//这是整合的一个特点
		log.debug("**********PaperDao update_paper_singleChoice out**********");

		return result;
	}

	/**
	 * 修改试卷内的判断题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	@Override
	public int update_paper_check(Paper paper) {
		log.debug("**********PaperDao update_paper_check in**********");

		int result = 0;
		
		//result = paperDao.update_paper_check(paper);
		//此处不需显示写明事务处理，事务由Spring容器处理
		//这是整合的一个特点
		log.debug("**********PaperDao update_paper_check out**********");

		return result;
	}

	/**
	 * 修改试卷内的填空题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	@Override
	public int update_paper_fillBlank(Paper paper) {
		log.debug("**********PaperDao update_paper_fillBlank in**********");

		int result = 0;
		
		//result = paperDao.update_paper_fillBlank(paper);
		//此处不需显示写明事务处理，事务由Spring容器处理
		//这是整合的一个特点
		log.debug("**********PaperDao update_paper_fillBlank out**********");

		return result;
	}

	/**
	 * 修改试卷内的多选题信息
	 * @param paper	待修改的试卷
	 * @return	返回影响的行数
	 */
	@Override
	public int update_paper_multipleChoice(Paper paper) {
		log.debug("**********PaperDao update_paper_multipleChoice in**********");

		int result = 0;
		
		//result = paperDao.update_paper_multipleChoice(paper);
		//此处不需显示写明事务处理，事务由Spring容器处理
		//这是整合的一个特点
		log.debug("**********PaperDao update_paper_multipleChoice out**********");

		return result;
	}

	

	/**
	 * 查询试卷信息,通过老师的id
	 * @param teacherId	老师id
	 * @return	返回所有试卷组成的List集合
	 */
	@Override
	public List<Paper> select_paperByTeacherId(String teacherId) {
		log.debug("**********PaperDao select_paperByTeacherId in**********");

		List<Paper> result = null;
		//result = paperDao.select_paperByTeacherId(teacherId);
		log.debug("**********PaperDao select_paperByTeacherId out**********");

		return result;
	}

	/**
	 * 查询试卷信息,通过试卷名
	 * @param paperName	试卷名
	 * @return	返回所有试卷组成的List集合
	 */
	@Override
	public List<Paper> select_paperByPaperName(String paperName) {
		log.debug("**********PaperDao select_paperByPaperName in**********");

		List<Paper> result = null;
		//result = paperDao.select_paperByPaperName(paperName);
		log.debug("**********PaperDao select_paperByPaperName out**********");

		return result;
	}

	/**
	 * 查询试卷中的选择题信息
	 * @return	返回所有试卷中的选择题信息组成的List集合
	 */
	@Override
	public List<Paper> select_paper_singleChoice() {
		log.debug("**********PaperDao select_paper_singleChoice in**********");

		List<Paper> result = null;
		//result = paperDao.select_paper_singleChoice();
		log.debug("**********PaperDao select_paper_singleChoice out**********");

		return result;
	}

	/**
	 * 条件查询试卷
	 */
	@Override
	public List<Paper> selectPaper(Map<String,Object> map) {
		log.debug("**********PaperDao selectPaper in**********");

		List<Paper> list = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		IPaperDao paperDao = session.getMapper(IPaperDao.class);
		 
		list = paperDao.selectPaper(map);
		log.debug("**********PaperDao selectPaper out**********");

		return list;
	}

	/**
	 * 查询试卷条数
	 */
	@Override
	public int selectCount() {
		log.debug("**********PaperDao selectCount in**********");

		SqlSession session = sqlSessionFactory.openSession();
		IPaperDao paperDao = session.getMapper(IPaperDao.class);
		int num = paperDao.selectCount();
		log.debug("**********PaperDao selectCount out**********");

		return num;
	}

}
