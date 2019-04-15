package com.ychs.service;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import com.ychs.bean.StudentAndUser;

public interface IUpLoadStService {
    
    /**
     * 读取并添加到数据库
     */
    public String javaPoi(MultipartFile file)throws  IOException;
    
    /**
     * 读取excel中的数据，返回list集合
     */
     public List<StudentAndUser> readXls(MultipartFile file) throws IOException ;
     /**
      * 获取单元格内的数据
      */
    public String getValue(Cell hssfCell) ;


}

