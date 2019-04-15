package com.ychs.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ychs.bean.MultipleChoices;


/**
 * 多选题选项的dao
 * @author FENG
 *
 */
@Repository
public class MultipleChoicesDao implements IMultipleChoicesDao {

	
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	 
	/**
	 * 插入一条多选题选项
	 * @param check
	 * @return int
	 */
	@Override
	public int insert(MultipleChoices multipleChoices) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		IMultipleChoicesDao imcd = session.getMapper(IMultipleChoicesDao.class);
		result = imcd.insert(multipleChoices);
		
		return result;
	}
	/**
	 * 查询多选题选项
	 * @param multipleChoices
	 * @return
	 */
	@Override
	public MultipleChoices select(MultipleChoices multipleChoices) {
		SqlSession session = sqlSessionFactory.openSession();
		IMultipleChoicesDao imcd = session.getMapper(IMultipleChoicesDao.class);
		return imcd.select(multipleChoices);
	}
	
	

}
