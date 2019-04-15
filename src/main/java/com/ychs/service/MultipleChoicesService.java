package com.ychs.service;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.MultipleChoices;
import com.ychs.dao.IMultipleChoicesDao;
import com.ychs.util.Constants;
/**
 * 多选题选项的service
 * @author 冯永强
 */
@Service
public class MultipleChoicesService implements IMultipleChoicesService{

	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IMultipleChoicesDao imcd;
	
	/**
	 * 添加一条多选题选项
	 */
	@Override
	public boolean addMultipleChoices(MultipleChoices multipleChoices) {
		log.debug("multipleChoices   ---------");
		boolean result = false;
		result = imcd.insert(multipleChoices)==Constants.SUCCESS;
		log.debug("multipleChoices   +++++++++");
		return result;
	}

	@Override
	public MultipleChoices select(MultipleChoices multipleChoices) {
		
		return imcd.select(multipleChoices);
	}
	
}
