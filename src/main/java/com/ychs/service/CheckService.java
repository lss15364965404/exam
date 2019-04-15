package com.ychs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.Check;
import com.ychs.dao.ICheckDao;
import com.ychs.util.Constants;

/**
 * 判断题Service层
 * @author 李少石
 * @version 2018-4-10
 */
@Service
public class CheckService implements ICheckService{

	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ICheckDao checkDao;
	
	/**
	 * 添加一条判断题
	 */
	@Override
	public boolean addCheck(Check check) {
		log.debug("********** CheckService addCheck service in **********");
		boolean result = false;
		result = checkDao.insert(check)==Constants.SUCCESS;
		log.debug("********** CheckService addCheck service out **********");
		return result;
	}
	
	/**
	 * 按条件查询判断题
	 */
	@Override
	public List<Check> selectCkByCondition(String stage, String stem,String page1,String limit1) {
		log.debug("********** CheckService selectCkByCondition in**********");
		List<Check> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(stage == null){	//对首次加载的页面进行处理，如果为null则为“”
			stage = "";
		}
		if(stem == null){
			stem = "";
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
		map.put("stage", "%"+stage+"%");
		map.put("stem", "%"+stem+"%");
		map.put("page", page);
		map.put("limit", limit);
		list = checkDao.selectCkByCondition(map);
		
		log.debug("**********CheckService selectCkByCondition out**********");
		return list;
	}
	
	/**
	 * 查询总条数
	 */
	@Override
	public int selcetCountS() {
		log.debug("********** CheckService selcetCountS service in**********");
		int num = checkDao.selectCount();
		log.debug("********** CheckService selcetCountS service out**********");
		return num;
	}

}
