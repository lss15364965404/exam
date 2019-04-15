package com.ychs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.FillBlank;
import com.ychs.dao.IFillBlankDao;
import com.ychs.util.Constants;

/**
 * 填空题Service层
 * @author 李少石
 *
 */
@Service
public class FillBlankService implements IFillBlankService{

	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IFillBlankDao ifb;
	
	/**
	 * 插入一条填空题
	 */
	@Override
	public boolean addFillBlank(FillBlank fillBlank) {
		log.debug("********** FillBlankService addFillBlank service in **********");
		boolean result = false;
		result = ifb.insert(fillBlank)==Constants.SUCCESS;
		log.debug("********** FillBlankService addFillBlank service out **********");
		return result;
	}
	
	/**
	 * 按条件查询填空题
	 */
	@Override
	public List<FillBlank> selectFkByCondition(String stem, String stage,String page1,String limit1) {
		log.debug("********** FillBlankService selectFkByCondition service in **********");
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<FillBlank> list = null;
		
		if(stage == null){
			stage = "";
		}
		if(stem == null){
			stem = "";
		}
		log.debug("service stage"+stage);
		log.debug("service stem"+stem);
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
		log.debug("map"+map);
		list = ifb.selectFkByCondition(map);
		log.debug("********** FillBlankService selectFkByCondition service out **********");
		return list;
	}

	/**
	 * 查询填空题总条数
	 */
	@Override
	public int selcetCountS() {
		log.debug("********** FillBlankService selcetCountS service in **********");
		int count = ifb.selectCount();
		log.debug("********** FillBlankService selcetCountS service out **********");
		return count;
	}

}
