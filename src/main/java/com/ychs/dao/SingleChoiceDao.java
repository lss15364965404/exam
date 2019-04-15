package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoiceAndTeacher;
/**
 * 单选题的dao层
 * 
 * @author 冯永强
 *
 */

@Repository
public class SingleChoiceDao implements ISingleChoiceDao {

	@Resource
	private SqlSessionFactory sqlSessionFactory;
	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * 添加一条填空题
	 * @param fillBlank
	 * @return
	 */
	@Override
	public int insert(SingleChoice singleChoice) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoiceDao ic = session.getMapper(ISingleChoiceDao.class);
		result = ic.insert(singleChoice);
		return result;
	}
	
	
	/**
	 * 根据条件查出单选题集合
	 * @param singleChoice_id
	 * @return
	 */
	@Override
	public List<SingleChoiceAndTeacher> selectSingleChoice(Map<String,Object> map) {
		log.debug("SingleChoiceDao. selectByStage  -----  in");
		
		List<SingleChoiceAndTeacher> list = null;		//单选题的集合
		
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoiceDao iSingleChoiceDao = session.getMapper(ISingleChoiceDao.class);
		list = iSingleChoiceDao.selectSingleChoice(map);
		
		log.debug("list==" + list);
		log.debug("SingleChoiceDao selectByStage ++++++++ out");
		
		return list;
	}
	
	/**
	 * 根据条件查出单选题集合
	 * @param singleChoice_id
	 * @return
	 */
	@Override
	public List<SingleChoiceAndTeacher> selectSingleChoiceAdd(Map<String,Object> map) {
		log.debug("*****************SingleChoiceDao. selectSingleChoiceAdd  -----  in");
		log.debug("*****************SingleChoiceDao. selectSingleChoiceAdd  -----  map:"+map);
		
		List<SingleChoiceAndTeacher> list = null;		//单选题的集合
		
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoiceDao iSingleChoiceDao = session.getMapper(ISingleChoiceDao.class);
		list = iSingleChoiceDao.selectSingleChoiceAdd(map);
		
		log.debug("*****************list==" + list);
		log.debug("****************SingleChoiceDao selectSingleChoiceAdd ++++++++ out");
		
		return list;
	}

	/**
	 * 单选题的修改
	 */
	@Override
	public int update(SingleChoice singleChoice) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoiceDao ic = session.getMapper(ISingleChoiceDao.class);
		result = ic.update(singleChoice);
		return result;
	}
	/**
	 * 单选题的修改
	 */
	@Override
	public int updateRight(Map<String,String> map) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoiceDao ic = session.getMapper(ISingleChoiceDao.class);
		result = ic.updateRight(map);
		return result;
	}
	
	/**
	 * 查询总条数
	 */
	@Override
	public int selectCount() {
		int count = 0;		//获得的条数
		log.debug("check   selectCount   ----");
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoiceDao iSingleChoiceDao = session.getMapper(ISingleChoiceDao.class);
		count = iSingleChoiceDao.selectCount();
		log.debug("check   selectCount   ----");
		return count;
	}
}
