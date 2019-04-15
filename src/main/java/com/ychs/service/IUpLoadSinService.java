package com.ychs.service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ychs.bean.SingleChoice;
import com.ychs.bean.TeacherAndUser;

public interface IUpLoadSinService {
    
    /**
     * 读取并添加到数据库
     */
    public String javaPoi()throws  IOException;
    
    /**
     * 读取excel中的数据，返回list集合
     */
     public List<Map<String, Object>> readXls() throws IOException ;
     /**
      * 获取单元格内的数据
      */
    public String getValue(HSSFCell hssfCell) ;

	

	

	


}

