package com.ychs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.StudentAndUser;
import com.ychs.dao.IStudentDao;
import com.ychs.util.Constants;

/**
 * 学生数据的Service层
 * @author 李少石
 * @version 2018-04-09
 */
@Service
public class StudentService implements IStudentService{

	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IStudentDao studentDao;
	
	/**
	 * 增加一条用户数据
	 */
	@Override
	public boolean addStudent(Map<String, Object> map) {
		log.debug("*******************StudentService addStudent in *******************");
		boolean result = false;
		result = studentDao.insert(map)==Constants.SUCCESS;
		log.debug("*******************StudentService addStudent out *******************");
		return result;
	}
	
	
	/**
	 * 按照条件查询用户数据(可分页)
	 */
	@Override
	public List<StudentAndUser> selectStudentByCondition(String username,String page1,String limit1) {
		log.debug("*******************StudentService selectStudentByCondition in*******************");
		List<StudentAndUser> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		if(username == null){	//对首次加载的页面进行处理，如果为null则为“”
			username = "";
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
		map.put("username", "%"+username+"%");
		map.put("page", page);
		map.put("limit", limit);
		log.debug("*******************StudentService selectStudentByCondition username:"+username+"*******************");
		log.debug("*******************StudentService selectStudentByCondition page:"+page+"*******************");
		log.debug("*******************StudentService selectStudentByCondition limit:"+limit+"*******************");

		
		list = studentDao.selectStudentByCondition(map);
		
		log.debug("*******************StudentService selectStudentByCondition out*******************");
		return list;
	}
	
	/**
	 * 查询总条数
	 */
	@Override
	public int selectCounts() {
		log.debug("******************* StudentService selcetCounts service in*******************");
		int num = studentDao.selectCount();
		log.debug("******************* StudentService selcetCounts service out*******************");
		return num;
	}

}
