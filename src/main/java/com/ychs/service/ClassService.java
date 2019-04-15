package com.ychs.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.Class;
import com.ychs.dao.IClassDao;
import com.ychs.util.Constants;

/**
 * 班级数据的Service层
 * @author 李少石
 * @version 2018-04-09
 */
@Service
public class ClassService implements IClassService{

	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IClassDao classDao;
	
	/**
	 * 增加一条用户数据
	 */
	@Override
	public boolean addClass(Map<String, Object> map) {
		log.debug("*******************ClassService addClass in *******************");
		boolean result = false;
		result = classDao.insert(map)==Constants.SUCCESS;
		log.debug("*******************ClassService addClass out *******************");
		return result;
	}
	
	
	/**
	 * 按照条件查询用户数据(可分页)
	 */
	@Override
	public List<Class> selectClassByCondition(Map<String, Object> map) {
		log.debug("*******************ClassService selectClassByCondition in*******************");
		List<Class> list = null;
		String class_name = (String) map.get("class_name");
		String page1 = (String) map.get("page1");
		String limit1 = (String) map.get("limit1");
		
		//Map<String,Object> map = new HashMap<String,Object>();
		
		if(class_name == null){	//对首次加载的页面进行处理，如果为null则为“”
			class_name = "";
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
		map.put("class_name", "%"+class_name+"%");
		map.put("page", page);
		map.put("limit", limit);
		log.debug("*******************ClassService selectClassByCondition class_name:"+class_name+"*******************");
		log.debug("*******************ClassService selectClassByCondition page:"+page+"*******************");
		log.debug("*******************ClassService selectClassByCondition limit:"+limit+"*******************");

		
		list = classDao.selectClassByCondition(map);
		
		log.debug("*******************ClassService selectClassByCondition list:"+list+"*******************");
		log.debug("*******************ClassService selectClassByCondition out*******************");
		return list;
	}
	
	/**
	 * 查询总条数
	 */
	@Override
	public int selectCounts() {
		log.debug("******************* ClassService selcetCounts service in*******************");
		int num = classDao.selectCount();
		log.debug("******************* ClassService selcetCounts service out*******************");
		return num;
	}

	/**
	 * 查询本班学生数目
	 */
	@Override
	public int selectClassStudentNum(Map<String, Object> map) {
		log.debug("******************* ClassService selectClassStudentNum service in*******************");
		int num = classDao.selectStudentNum(map);
		log.debug("******************* ClassService selectClassStudentNum service out*******************");
		return num;
	}

}
