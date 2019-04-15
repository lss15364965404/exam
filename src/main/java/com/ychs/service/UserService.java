package com.ychs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.User;
import com.ychs.dao.IUserDao;
import com.ychs.util.Constants;

/**
 * 用户数据的Service层
 * @author 李少石
 * @version 2018-04-09
 */
@Service
public class UserService implements IUserService{

	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IUserDao userDao;
	
	/**
	 * 增加一条用户数据
	 */
	@Override
	public boolean addUser(Map<String, Object> map) {
		log.debug("*******************UserService addUser service in *******************");
		boolean result = false;
		result = userDao.insert(map)==Constants.SUCCESS;
		log.debug("*******************UserService addUser service in *******************");
		return result;
	}
	/**
	 * 登录验证(按照条件查询用户数据)
	 */
	@Override
	public User selectUserByNamePass(Map<String, Object> map) {
		//显示map中的值
		Set set = map.keySet();
		Iterator it = set.iterator();
	    while(it.hasNext()){
	        String key = (String) it.next();
	        String value = (String) map.get(key);
	        log.debug("*******************UserService map:"+key + "=" + value);
	    }
		
		log.debug("*******************UserService selectUserByNamePass *******************");
		List<User> list_User = new ArrayList<User>();
		list_User = userDao.selectUserByCondition(map);
		
		if(list_User.size()==1) {
			User user = list_User.get(0);
			log.debug("*******************UserService selectUserByNamePass 登录成功："+user.getUsername()+"*******************");
			return user;
		}else {
			User user = new User();
			user.setUsername("查无此人");
			log.debug("*******************UserService selectUserByNamePass 登录失败："+user.getUsername()+"*******************");
			return user;
		}
	}
	
	/**
	 * 按照条件查询用户数据(可分页)
	 */
	@Override
	public List<User> selectUserByCondition(String username, String password,String role,String role_id,String page1,String limit1) {
		log.debug("*******************UserService selectUserByCondition in*******************");
		List<User> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(username == null){	//对首次加载的页面进行处理，如果为null则为“”
			username = "";
		}
		if(password == null){
			password = "";
		} 
		if(role == null){
			role = "" ;
		}
		if(role_id == null){
			role_id = "" ;
		}
		if(page1 == null){
			page1 = "1" ;
		}
		if(limit1 == null){
			limit1 = "10";
		}
		int page = Integer.parseInt(page1) -1;
		int limit = Integer.parseInt(limit1) ;
		page = page * limit ;			//分页的起始位置
		map.put("username", username);
		map.put("password", password);
		map.put("role", role);
		map.put("role_id", role_id);
		map.put("page", page);
		map.put("limit", limit);
		list = userDao.selectUserByCondition(map);
		
		log.debug("*******************UserService selectUserByCondition out*******************");
		return list;
	}
	
	/**
	 * 查询总条数
	 */
	@Override
	public int selectCounts() {
		log.debug("******************* UserService selcetCounts service in*******************");
		int num = userDao.selectCount();
		log.debug("******************* UserService selcetCounts service out*******************");
		return num;
	}
	
	/**
	 * 修改密码
	 */
	@Override
	public String updatePassword(Map<String, Object> map) {
		String result = "false";
		log.debug("******************* UserService updatePassword service in*******************");
		List<User> list = null;
		String page1 = "1" ;
		String limit1 = "10";
		int page = Integer.parseInt(page1) -1;
		int limit = Integer.parseInt(limit1) ;
		page = page * limit ;			//分页的起始位置
		map.put("page", page);
		map.put("limit", limit);
		list = userDao.selectUserByCondition(map);
		if(list.size() == 1) {
			log.debug("******************* UserService updatePassword service 用户名、密码正确！*******************");
			int num = userDao.updatePassword(map);
			
			if(num == 1) {
				result = "success";
			}
		}else {
			log.debug("******************* UserService updatePassword service 用户名或密码输入错误！*******************");
			result = "false";
		}
		
		log.debug("******************* UserService selcetCounts service out*******************");
		return result;
	}
	
	
	
	

}
