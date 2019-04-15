package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.Check;


/**
 * 判断题的Dao
 * @author 李少石
 * 
 */
@Repository
public class CheckDao implements ICheckDao {

	@Resource
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 日志声明
	 */
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 插入一条判断题
	 * @param check
	 * @return int
	 */
	@Override
	public int insert(Check check) {
		log.debug("**********check   insert   in**********");
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		ICheckDao icd = session.getMapper(ICheckDao.class);
		result = icd.insert(check);
		log.debug("**********check   insert   out**********");
		return result;
	}
	
	/**
	 * 根据条件查询判断题
	 */
	@Override
	public List<Check> selectCkByCondition(Map<String, Object> map) {
		log.debug("**********check   selectCkByCondition   in**********");
		List<Check> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		ICheckDao icd = session.getMapper(ICheckDao.class);
		list = icd.selectCkByCondition(map);
		log.debug("**********check   selectCkByCondition   out**********");
		return list;
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int selectCount() {
		int count = 0;		//获得的条数
		log.debug("**********check   selectCount   in**********");
		SqlSession session = sqlSessionFactory.openSession();
		ICheckDao icd = session.getMapper(ICheckDao.class);
		count = icd.selectCount();
		log.debug("**********check   selectCount   out**********");
		return count;
	}

}
