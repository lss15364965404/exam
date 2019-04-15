package com.ychs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.SingleChoice;
import com.ychs.bean.SingleChoiceAndTeacher;
import com.ychs.dao.ISingleChoiceDao;
import com.ychs.util.Constants;

/**
 * 单选题 的service层
 * @author FENG
 *
 */
@Service
public class SingleChoiceService implements ISingleChoiceService {

	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ISingleChoiceDao iscd;
	/**
	 * 添加单选题
	 * @param fillBlank
	 * @return
	 */
	@Override
	public boolean addSingleChoice(SingleChoice singleChoice) {

		log.debug("********************************SingleChoiceService  addSingleChoice in********************************");
		boolean result = false;
		result = iscd.insert(singleChoice)==Constants.SUCCESS;
		log.debug("********************************SingleChoiceService  addSingleChoice out********************************");
		return result;
	}
	
	
	/**
	 * 查看条件的单选题
	 * @return
	 */
	@Override
	public List<SingleChoiceAndTeacher> selectByCondition(String stage,String singleChoice_question,String page1,String limit1) {
		
		log.debug("********************************SingleChoiceService  selectByCondition in********************************");
		
		List<SingleChoiceAndTeacher> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		if(stage == null){
			stage = "";
		}
		if(singleChoice_question == null){
			singleChoice_question = "";
		}
		log.debug("**********service stage："+stage);
		log.debug("**********service singleChoice_question："+singleChoice_question);
		
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
		map.put("singleChoice_question", singleChoice_question);
		map.put("page", page);
		map.put("limit", limit);
		log.debug("********************************SingleChoiceService  selectByCondition map:"+map+"********************************");

		list = iscd.selectSingleChoice(map);
		
		log.debug("********************************SingleChoiceService  selectByCondition list："+list+"********************************");
		log.debug("********************************SingleChoiceService  selectByCondition out********************************");
		return list;
	}
	
	/**
	 * 查看条件的单选题
	 * @return
	 */
	@Override
	public List<SingleChoiceAndTeacher> selectByConditionAdd(String stage,String singleChoice_question,String page1,String limit1) {
		
		log.debug("********************************SingleChoiceService  selectByConditionAdd in********************************");
		
		List<SingleChoiceAndTeacher> list = null;
		Map<String,Object> map = new HashMap<String,Object>();
		if(stage == null){
			stage = "";
		}
		if(singleChoice_question == null){
			singleChoice_question = "";
		}
		log.debug("**********service stage："+stage);
		log.debug("**********service singleChoice_question："+singleChoice_question);
		
		if(page1 == null){
			page1 = "1" ;
		}
		if(limit1 == null){
			limit1 = "10";
		}
		int page = Integer.parseInt(page1) -1;
		int limit = Integer.parseInt(limit1) ;
		page = page * limit ;			//分页的起始位置
		map.put("stage:", "%"+stage+"%");
		map.put("singleChoice_question", singleChoice_question);
		map.put("page", page);
		map.put("limit", limit);
		log.debug("********************************SingleChoiceService  selectByConditionAdd map:"+map+"********************************");

		list = iscd.selectSingleChoiceAdd(map);
		
		log.debug("********************************SingleChoiceService  selectByConditionAdd list："+list+"********************************");
		log.debug("********************************SingleChoiceService  selectByConditionAdd out********************************");
		return list;
	}



	/**
	 * 单选题的修改
	 */
	@Override
	public boolean updateSingleChoice(SingleChoice singleChoice) {
		log.debug("********************************SingleChoiceService  updateSingleChoice in********************************");
		boolean result = false;
		result = iscd.update(singleChoice)==Constants.SUCCESS;
		log.debug("********************************SingleChoiceService  updateSingleChoice out********************************");
		return result;
	}
	/**
	 * 单选题的修改
	 */
	@Override
	public boolean updateSingleChoiceRight(Map<String,String> map) {
		log.debug("********************************SingleChoiceService  updateSingleChoice in********************************");
		boolean result = false;
		result = iscd.updateRight(map)==Constants.SUCCESS;
		log.debug("********************************SingleChoiceService  updateSingleChoice out********************************");
		return result;
	}


	/**
	 * 查询总条数
	 */
	@Override
	public int selcetCountS() {
		log.debug("********************************SingleChoiceService  selcetCountS in********************************");
		int num = iscd.selectCount();
		log.debug("********************************SingleChoiceService  selcetCountS out********************************");
		return num;
	}

}
