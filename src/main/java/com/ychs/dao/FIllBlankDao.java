package com.ychs.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ychs.bean.FillBlank;

/**
 * 填空题的Dao
 * @author 李少石
 *
 */
@Repository
public class FIllBlankDao implements IFillBlankDao {

	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 添加一条填空题
	 * @param fillBlank
	 * @return
	 */
	@Override
	public int insert(FillBlank fillBlank) {
		log.debug("finllBlan getAll dao  ----");
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		IFillBlankDao ifb = session.getMapper(IFillBlankDao.class);
		result = ifb.insert(fillBlank);
		
		log.debug("finllBlan getAll dao  ++++");
		return result;
	}


	

	/**
	 * 根据条件查询填空题
	 */
	@Override
	public List<FillBlank> selectFkByCondition(Map<String, Object> map) {
		log.debug("selectFkByCondition dao  ----");
		List<FillBlank> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		IFillBlankDao ifb = session.getMapper(IFillBlankDao.class);
		list = ifb.selectFkByCondition(map);
		
		log.debug("selectFkByCondition dao  ++++");
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
		IFillBlankDao ifb = session.getMapper(IFillBlankDao.class);
		count = ifb.selectCount();
		log.debug("check   selectCount   ----");
		return count;
	}
}
