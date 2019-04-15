package com.ychs.service;

import com.ychs.bean.SingleChoices;

/**
 * 单选题选项接口
 * @author 冯永强
 *
 */
public interface ISingleChoicesService {
	/**
	 * 添加单选题选项
	 * @return boolean
	 */
	public boolean addSingleChoices(SingleChoices singleChoices);
	/**
	 * 查询单选题选项
	 * @param singleChoices
	 * @return
	 */
	public SingleChoices selectSingleChoices(SingleChoices singleChoices);
}
