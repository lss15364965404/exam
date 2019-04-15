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

import com.ychs.bean.User;

/**
 * 用户的Dao
 * @author 李少石
 * @version 2018-04-09
 */
@Repository
public class UserDao implements IUserDao {
	
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
		log.debug("***********UserDao   insert方法  in     **************");
		int result = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		IUserDao iUserDao = session.getMapper(IUserDao.class);
		result = iUserDao.insert(map);
		
		log.debug("***********UserDao   insert方法  out     **************");
		return result;
	}
	
	/**
	 * 修改一条用户数据
	 */
	public int updatePassword(Map<String, Object> map) {
		log.debug("***********UserDao   update方法  in     **************");
		int result = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		IUserDao iUserDao = session.getMapper(IUserDao.class);
		log.debug("***********UserDao   update方法  map:"+map+"     **************");

		result = iUserDao.updatePassword(map);
		
		log.debug("***********UserDao   update方法  out     **************");
		return result;
	}

	/**
	 * 按条件查询用户信息
	 */
	public List<User> selectUserByCondition(Map<String, Object> map) {
		log.debug("***********UserDao   selectUserByCondition方法  in     **************");
		//显示map中的值
		Set set = map.keySet();
		Iterator it = set.iterator();
	    while(it.hasNext()){
	        String key = String.valueOf( it.next() );
	        String value = String.valueOf( map.get(key) );
	        log.debug("*******************UserDao map:"+key + "=" + value);
	    }
		
		SqlSession session = sqlSessionFactory.openSession();
		IUserDao iUserDao = session.getMapper(IUserDao.class);
		List<User> list = iUserDao.selectUserByCondition(map);
		
		log.debug("***********UserDao   selectUserByCondition方法  out     **************");
		return list;
	}

	/**
	 * 查询用户信息条数
	 */
	public int selectCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
