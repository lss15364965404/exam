package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.Class;

/**
 * 班级的Dao
 * @author 李少石
 * @version 2018-04-09
 */
@Repository
public class ClassDao implements IClassDao {
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 日志声明
	 */
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 插入一条班级数据
	 */
	public int insert(Map<String, Object> map) {
		log.debug("***********ClassDao   insert方法  in     **************");
		int result = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		IClassDao iClassDao = session.getMapper(IClassDao.class);
		result = iClassDao.insert(map);
		
		log.debug("***********ClassDao   insert方法  out     **************");
		return result;
	}

	/**
	 * 按条件查询教师信息
	 */
	public List<Class> selectClassByCondition(Map<String, Object> map) {
		log.debug("***********ClassDao   selectClassByCondition方法  in     **************");
		
		SqlSession session = sqlSessionFactory.openSession();
		IClassDao iClassDao = session.getMapper(IClassDao.class);
		List<Class> list = iClassDao.selectClassByCondition(map);

		log.debug("***********ClassDao   selectClassByCondition方法  list："+list+"     **************");
		log.debug("***********ClassDao   selectClassByCondition方法  out     **************");
		return list;
	}
	
	/**
	 * 查询班级条数
	 */
	@Override
	public int selectCount() {
		int count = 0;		//获得的条数
		log.debug("***********ClassDao   selectCount   in**************");
		SqlSession session = sqlSessionFactory.openSession();
		IClassDao iClassDao = session.getMapper(IClassDao.class);
		count = iClassDao.selectCount();
		log.debug("***********ClassDao   selectCount   out**************");
		return count;
	}

	/**
	 * 查询本班学生数目
	 */
	@Override
	public int selectStudentNum(Map<String, Object> map) {
		int num = 0;		//获得的条数
		log.debug("***********ClassDao   selectCount   in**************");
		SqlSession session = sqlSessionFactory.openSession();
		IClassDao iClassDao = session.getMapper(IClassDao.class);
		num = iClassDao.selectStudentNum(map);
		log.debug("***********ClassDao   selectCount   out**************");
		return num;
	}

}
