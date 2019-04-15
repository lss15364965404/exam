package com.ychs.service;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.ychs.bean.SingleChoice;
import com.ychs.bean.TeacherAndUser;
import com.ychs.dao.ISingleChoiceDao;
import com.ychs.dao.ITeacherDao;
import com.ychs.dao.IUserDao;

/**
 * 上传单选题service
 */
@Service
public class UpLoadSinService  implements IUpLoadSinService {
	
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ITeacherDao teacherDao;
	@Resource
	private ISingleChoiceDao singleChoiceDao;

    /**
     * 读取并添加到数据库
     */
    @Override
    //public String javaPoi(MultipartFile file)throws  IOException{
    public String javaPoi()throws  IOException{
		log.debug("**********UpLoadSinService  javaPoi in**********");
		String result = "false";
		int num = 0;
        List<Map<String, Object>> list = readXls();
		log.debug("**********UpLoadSinService  javaPoi list:"+list+"**********");
		Map<String, Object> map = new HashMap<String, Object>();
        for(int i=0;i < list.size();i++){
    		log.debug("**********UpLoadSinService  javaPoi excel:"+map.get("singleChoice_question")+","+map.get("singleChoice_choice_s")+","+map.get("singleChoiceRightChoice_choice")+","+map.get("singleChoice_stage")+","+map.get("teacher_name")+","+map.get("num_excel")+"**********");
        }
        if(num == list.size()) {
        	result = "success";
        }
		log.debug("**********UpLoadSinService  javaPoi result:"+result+"**********");
		log.debug("**********UpLoadSinService  javaPoi out**********");

      return result;
    }
    
    /**
     * 读取excel中的数据，返回list集合
     */
     @Override
     public List<Map<String, Object>> readXls() throws IOException {
 		log.debug("**********UpLoadSinService  readXls in**********");

    	//文件地址
        InputStream is = new FileInputStream("D:\\singo.xls");
        //InputStream is = file.getInputStream();
        
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int num = 0;
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
        	// 获取每一个工作薄
        	HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
        	//Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                //创建序号为rownum的行
            	HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    //创建rownum行singleChoice_question这一列的单元格的数据
                	HSSFCell no = hssfRow.getCell(0);
                	HSSFCell singleChoice_question = hssfRow.getCell(1);
                    //创建rownum行singleChoiceAnswer_id这一列的单元格的数据
                	HSSFCell singleChoice_choice_s = hssfRow.getCell(2);
                   //创建rownum行singleChoiceRightAnswer_id这一列的单元格的数据
                	HSSFCell singleChoiceRightChoice_choice = hssfRow.getCell(3);
                    //创建rownum行singleChoice_stage这一列的单元格的数据
                	HSSFCell singleChoice_stage = hssfRow.getCell(4);
                    //创建rownum行teacher_name这一列的单元格的数据
                	HSSFCell teacher_name = hssfRow.getCell(5);
                    num++;
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("singleChoice_question", getValue(singleChoice_question));
                    map.put("singleChoice_choice_s", getValue(singleChoice_choice_s));
                    map.put("singleChoiceRightChoice_choice", getValue(singleChoiceRightChoice_choice));
                    map.put("singleChoice_stage", getValue(singleChoice_stage));
                    map.put("teacher_name", getValue(teacher_name));
                    map.put("num_excel", num);
                    list.add(map);
                  
                }
            }
        }
		log.debug("**********UpLoadSinService  readXls out**********");

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
    /**
     * 将单选题答案集分解成list
     * @param singleChoice_choice_s 单选答案集
     * @return
     */
    public List<String> chaiFen(String singleChoice_choice_s){
    	List<String> list = new ArrayList<String>();
    	String singleChoice_choices[] = singleChoice_choice_s.split(",");
    	for(int i = 0;i<singleChoice_choices.length;i++) {
    		list.add(singleChoice_choices[i]);
    	}
    	return list;
    }
}

