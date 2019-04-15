package com.ychs.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.Teacher;
import com.ychs.bean.TeacherAndUser;

/**
 * 用户的Dao
 * @author 李少石
 * @version 2018-04-09
 */
@Repository
public class TeacherDao implements ITeacherDao {
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 日志声明
	 */
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 插入一条用户数据
	 */
	public int insert(Map<String, Object> map) {
		log.debug("***********TeacherDao   insert方法  in     **************");
		int result = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		ITeacherDao iTeacherDao = session.getMapper(ITeacherDao.class);
		result = iTeacherDao.insert(map);
		
		log.debug("***********TeacherDao   insert方法  out     **************");
		return result;
	}

	/**
	 * 按条件查询教师信息
	 */
	public List<TeacherAndUser> selectTeacherByCondition(Map<String, Object> map) {
		log.debug("***********TeacherDao   selectTeacherByCondition方法  in     **************");
		
		SqlSession session = sqlSessionFactory.openSession();
		ITeacherDao iTeacherDao = session.getMapper(ITeacherDao.class);
		List<TeacherAndUser> list = iTeacherDao.selectTeacherByCondition(map);
		
		log.debug("***********TeacherDao   selectTeacherByCondition方法  out     **************");
		return list;
	}
	
	/**
	 * 查询教师条数
	 */
	@Override
	public int selectCount() {
		int count = 0;		//获得的条数
		log.debug("***********TeacherDao   selectCount   in**************");
		SqlSession session = sqlSessionFactory.openSession();
		ITeacherDao iTeacherDao = session.getMapper(ITeacherDao.class);
		count = iTeacherDao.selectCount();
		log.debug("***********TeacherDao   selectCount   out**************");
		return count;
	}

}
