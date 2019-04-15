package com.ychs.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ychs.bean.MultipleChoice;
import com.ychs.bean.MultipleChoices;
import com.ychs.service.IMultipleChoicesService;

/**
 * 填空题controller
 * @author FENG
 *
 */
@Controller
public class MultipleChoicesController {
	
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IMultipleChoicesService imcs ;
	
	@RequestMapping("/MultipleChoices")
	public String add1(){
		
		log.debug("MultipleChoices  controller in");
		String result = "success";
		MultipleChoices multipleChoices = new MultipleChoices();
		multipleChoices.setMultipleChoice_id("1");
		multipleChoices.setMultipleChoice_choice("asdf");
		
		imcs.addMultipleChoices(multipleChoices);
		
		log.debug("MultipleChoices  controller out");
		return result;
	}
	
}
