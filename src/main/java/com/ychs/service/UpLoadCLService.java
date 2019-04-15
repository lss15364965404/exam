package com.ychs.service;
/**
 * 上传service
 */
import org.apache.log4j.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ychs.bean.Class;
import com.ychs.dao.IClassDao;

@Service
public class UpLoadCLService  implements IUpLoadClService {
	
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IClassDao classDao;

    /**
     * 读取并添加到数据库
     */
    @Override
    public String javaPoi(MultipartFile file)throws  IOException{
		log.debug("**********UpLoadService  javaPoi in**********");
		String result = "false";
		int num = 0;
        List<Class> list = readXls(file);
		log.debug("**********UpLoadService  javaPoi list:"+list+"**********");
		Map<String, Object> map = new HashMap<String, Object>();
        for(int i=0;i < list.size();i++){
			map.put("class_name",list.get(i).getClass_name());
            if((classDao.insert(map)) == 1) {
            	num++;
            }
        }
        if(num == list.size()) {
        	result = "success";
        }
		log.debug("**********UpLoadService  javaPoi result:"+result+"**********");
		log.debug("**********UpLoadService  javaPoi out**********");

      return result;
    }
    
    /**
     * 读取excel中的数据，返回list集合
     */
     @Override
     public List<Class> readXls(MultipartFile file) throws IOException {
 		log.debug("**********UpLoadService  readXls in**********");

    	//文件地址
        //InputStream is = new FileInputStream("D:\\classes.xls");
        InputStream is = file.getInputStream();
        
        
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Class classes = null;
        List<Class> list = new ArrayList<Class>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
        	// 获取每一个工作薄
        	HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                //创建序号为rownum的行
            	HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                   classes = new Class();
                   //创建rownum行id这一列的单元格的数据
                    HSSFCell id = hssfRow.getCell(0);
                    //创建rownum行name这一列的单元格的数据
                    HSSFCell className = hssfRow.getCell(1);
                    //创建rownum行score这一列的单元格的数据
                    HSSFCell score = hssfRow.getCell(3);
                  //设置id
                    classes.setClass_id(getValue(id));
                  //设置name
                    classes.setClass_name(getValue(className));
                  //添加到list集合中
                    list.add(classes);
                }
            }
        }
		log.debug("**********UpLoadService  readXls out**********");

        return list;
    }
     /**
      * 获取单元格内的数据
      */
    @Override
    public String getValue(HSSFCell hssfCell) {
    	//判断单元格内数据的格式
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
        	//布尔类型转String
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
        	//数字转String
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
        	//String转String
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}

