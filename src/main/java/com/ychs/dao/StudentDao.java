package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.StudentAndUser;

/**
 * 学生的Dao
 * @author 李少石
 * @version 2018-04-09
 */
@Repository
public class StudentDao implements IStudentDao {
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 日志声明
	 */
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 插入一条学生数据
	 */
	public int insert(Map<String, Object> map) {
		log.debug("***********StudentDao   insert方法  in     **************");
		int result = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		IStudentDao iStudentDao = session.getMapper(IStudentDao.class);
		result = iStudentDao.insert(map);
		
		log.debug("***********StudentDao   insert方法  out     **************");
		return result;
	}

	/**
	 * 按条件查询学生息
	 */
	public List<StudentAndUser> selectStudentByCondition(Map<String, Object> map) {
		log.debug("***********StudentDao   selectStudentByCondition方法  in     **************");
		
		SqlSession session = sqlSessionFactory.openSession();
		IStudentDao iStudentDao = session.getMapper(IStudentDao.class);
		List<StudentAndUser> list = iStudentDao.selectStudentByCondition(map);

		log.debug("***********StudentDao   selectStudentByCondition方法  out     **************");
		return list;
	}
	
	/**
	 * 查询学生条数
	 */
	@Override
	public int selectCount() {
		int count = 0;		//获得的条数
		log.debug("***********StudentDao   selectCount   in**************");
		SqlSession session = sqlSessionFactory.openSession();
		IStudentDao iStudentDao = session.getMapper(IStudentDao.class);
		count = iStudentDao.selectCount();
		log.debug("***********StudentDao   selectCount   out**************");
		return count;
	}

}
