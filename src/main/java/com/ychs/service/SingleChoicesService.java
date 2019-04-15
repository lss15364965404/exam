package com.ychs.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.SingleChoices;
import com.ychs.dao.ISingleChoicesDao;
import com.ychs.util.Constants;

/**
 * 单选题 选项的service层
 * @author FENG
 *
 */
@Service
public class SingleChoicesService implements ISingleChoicesService {

	
	
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ISingleChoicesDao iscd;
	/**
	 * 添加单选题选项
	 * @param fillBlank
	 * @return
	 */
	@Override
	public boolean addSingleChoices(SingleChoices singleChoices) {

		log.debug("SingleChoices service-----------");
		boolean result = false;
		result = iscd.insert(singleChoices)==Constants.SUCCESS;
		log.debug("SingleChoices service+++++++++");
		return result;
	}
	@Override
	public SingleChoices selectSingleChoices(SingleChoices singleChoices) {
		log.debug("SingleChoices selectSingleChoices in -----------");
		return iscd.select(singleChoices);
	}

}
