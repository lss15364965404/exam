package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoiceAndTeacher;


/**
 * 多选题的接口
 * @author FENG
 *
 */
@Repository
public class MultipleChoiceDao implements IMultipleChoiceDao {

	
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * 插入一条多选题
	 * @param check
	 * @return int
	 */
	@Override
	public int insert(MultipleChoice multipleChoiceDao) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		IMultipleChoiceDao imcd = session.getMapper(IMultipleChoiceDao.class);
		result = imcd.insert(multipleChoiceDao);
		
		return result;
	}

	
	/**
	 * 根据条件查询多选题
	 */
	@Override
	public List<MultipleChoiceAndTeacher> selectMuByContion(Map<String, Object> map) {
		
		log.debug("selectMuByContion    ----");
		List<MultipleChoiceAndTeacher>  list = null;
		SqlSession session = sqlSessionFactory.openSession();
		IMultipleChoiceDao imcd = session.getMapper(IMultipleChoiceDao.class);
		list = imcd.selectMuByContion(map);
		
		log.debug("selectMuByContion    ++++");
		
		return list;
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int selectCount() {
		int count = 0;		//获得的条数
		log.debug("check   selectCount   ----");
		SqlSession session = sqlSessionFactory.openSession();
		IMultipleChoiceDao imcd = session.getMapper(IMultipleChoiceDao.class);
		count = imcd.selectCount();
		log.debug("check   selectCount   ----");
		return count;
	}


	@Override
	public int update(MultipleChoice multipleChoice) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		IMultipleChoiceDao imcd = session.getMapper(IMultipleChoiceDao.class);
		result = imcd.update(multipleChoice);
		
		return result;
	}

}
