package com.ychs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoiceAndTeacher;
import com.ychs.dao.IMultipleChoiceDao;
import com.ychs.util.Constants;

@Service
public class MultipleChoiceService implements IMultipleChoiceService{

	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IMultipleChoiceDao imcd;
	@Override
	public boolean addMultipleChoice(MultipleChoice multipleChoice) {
		log.debug("multipleChoice -----------");
		boolean result = false;
		result = imcd.insert(multipleChoice)==Constants.SUCCESS;
		log.debug("multipleChoice  +++++++++");
		return result;
	}
	
	

	@Override
	public List<MultipleChoiceAndTeacher> selectMuByCondition(String stage, String stem,String page1 ,String limit1) {
		log.debug("multipleChoice service selectMuByCondition -----------");
		
		List<MultipleChoiceAndTeacher> list = null;
		Map<String,Object> map = new HashMap<String, Object>();
		if(stage == null){
			stage = "";
		}
		if(stem == null){
			stem = "";
		}
		log.debug(stage + "$$$" + stem); 
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
		list = imcd.selectMuByContion(map);
		log.debug("multipleChoice service selectMuByCondition +++++++++++");
		return list;
	}



	/**
	 * 修改多选题
	 * @param multipleChoice
	 * @return
	 */
	@Override
	public boolean updateMultipleChoice(MultipleChoice multipleChoice) {
		log.debug("multipleChoice -----------");
		boolean result = false;
		result = imcd.update(multipleChoice)==Constants.SUCCESS;
		log.debug("multipleChoice  +++++++++");
		return result;
	}


	/**
	 * 查询总条数
	 */
	@Override
	public int selcetCountS() {
		log.debug(" check selcetCountS service ---------");
		int num = imcd.selectCount();
		log.debug("check selcetCountS service ++++++++");
		return num;
	}
	

}
