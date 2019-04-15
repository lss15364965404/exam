package com.ychs.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ychs.bean.SingleChoices;
import com.ychs.service.ISingleChoicesService;

/**
 * 单选题的controller层
 * @author 冯永强
 *
 */
@Controller
public class SingleChoicesController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ISingleChoicesService iscs;		//单选题接口
	
	@RequestMapping("singleChoices")
	public String addSingleChoices(){
		
		log.debug("singleChoice  controller in");
		
		String result = "success";
		SingleChoices singleChoices = new SingleChoices();
		singleChoices.setSingleChoice_id("1");
	 	singleChoices.setSingleChoice_choice("sdfaf s");
		
		
		iscs.addSingleChoices(singleChoices);
		
		log.debug("singleChoice  controller out");
		return result;
	}
	
}
