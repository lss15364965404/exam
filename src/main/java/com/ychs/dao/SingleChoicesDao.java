package com.ychs.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ychs.bean.SingleChoices;
/**
 * 单选题的dao层
 * 
 * @author 冯永强
 *
 */

@Repository
public class SingleChoicesDao implements ISingleChoicesDao {

	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 添加一条填空题
	 * @param fillBlank
	 * @return
	 */
	@Override
	public int insert(SingleChoices singleChoices) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoicesDao ic = session.getMapper(ISingleChoicesDao.class);
		result = ic.insert(singleChoices);
		return result;
	}

	@Override
	public SingleChoices select(SingleChoices singleChoices) {
		SqlSession session = sqlSessionFactory.openSession();
		ISingleChoicesDao ic = session.getMapper(ISingleChoicesDao.class);
		
		return ic.select(singleChoices);
	}

}
