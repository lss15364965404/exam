package com.ychs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ychs.bean.Paper;
import com.ychs.dao.IPaperDao;
import com.ychs.util.Constants;

/**
 * 试卷 的service层
 * @author FENG
 *
 */
@Service
public class PaperService implements IPaperService {
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IPaperDao iPaper;
	/**
	 * 添加单选题
	 * @param fillBlank
	 * @return
	 */
	@Override
	public boolean addPaper(Map<String, String> map) {
		log.debug("**********PaperService addPaper in **********");
		boolean result = false;
		result = iPaper.insert_paper(map)==Constants.SUCCESS;
		log.debug("**********PaperService addPaper out **********");
		return result;
	}
	
	
	/**
	 * 按条件查询试卷
	 */
	@Override
	public List<Paper> selectPaperService(String paperName,String page1,String limit1) {
		log.debug("**********PaperService selectPaperService in **********");
		List<Paper> list  = null;
		log.debug("**********PaperService selectPaperService  paperName："+ paperName);
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(paperName==null){
			paperName="";
		}
		if(page1 ==null){
			page1 = "1";
		}
		if(limit1 == null){
			limit1 = "10";
		}
		int page = Integer.parseInt(page1);
		int limit = Integer.parseInt(limit1);
		map.put("paperName","%"+ paperName+"%");
		map.put("page", page);
		map.put("limit", limit);
		log.debug("**********PaperService selectPaperService paperName："+ paperName);
		log.debug("**********PaperService selectPaperService page："+ page);
		log.debug("**********PaperService selectPaperService limit："+ limit);
		list = iPaper.selectPaper(map);
		
		log.debug("**********PaperService selectPaperService list:" + list);
		log.debug("**********PaperService selectPaperService out **********");
		return list;
	}

	/**
	 * 查询试卷数
	 */
	@Override
	public int selectCountS() {
		log.debug("**********PaperService selectCountS in **********");
		int num = iPaper.selectCount();
		log.debug("**********PaperService selectCountS out **********");
		return num;
	}
	
	

}
