package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.PaperStuRightStuScoGrade;

/**
 * 学生的Dao
 * @author 李少石
 * @version 2018-04-09
 */
@Repository
public class ScoresDao implements IScoresDao {
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 日志声明
	 */
	Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * 按条件查询学生试卷答案及成绩
	 */
	public List<PaperStuRightStuScoGrade> selectStudentScoresByCondition(Map<String, Object> map) {
		log.debug("***********ScoresDao   selectStudentScoresByCondition方法  in     **************");
		
		SqlSession session = sqlSessionFactory.openSession();
		IScoresDao iScoresDao = session.getMapper(IScoresDao.class);
		List<PaperStuRightStuScoGrade> list = iScoresDao.selectStudentScoresByCondition(map);

		log.debug("***********ScoresDao   selectStudentScoresByCondition方法  out     **************");
		return list;
	}
	
	/**
	 * 查询学生条数
	 */
	@Override
	public int selectCount(Map<String, Object> map) {
		int count = 0;		//获得的条数
		log.debug("***********ScoresDao   selectCount   in**************");
		SqlSession session = sqlSessionFactory.openSession();
		IScoresDao iScoresDao = session.getMapper(IScoresDao.class);
		count = iScoresDao.selectCount(map);
		log.debug("***********ScoresDao   selectCount   out**************");
		return count;
	}

	

}
