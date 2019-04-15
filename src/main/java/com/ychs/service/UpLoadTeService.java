package com.ychs.service;

import org.apache.log4j.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ychs.bean.TeacherAndUser;
import com.ychs.dao.ITeacherDao;
import com.ychs.dao.IUserDao;

/**
 * Excel上传教师service
 */
@Service
public class UpLoadTeService  implements IUpLoadTeService {
	
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ITeacherDao teacherDao;
	@Resource
	private IUserDao userDao;

    /**
     * 读取并添加到数据库
     */
    @Override
    public String javaPoi(MultipartFile file)throws  IOException{
		log.debug("**********UpLoadTeService  javaPoi in**********");
		String result = "false";
		int num = 0;
        List<TeacherAndUser> list = readXls(file);
		log.debug("**********UpLoadTeService  javaPoi list:"+list+"**********");
		Map<String, Object> map = new HashMap<String, Object>();
        for(int i=0;i < list.size();i++){
			map.put("teacher_name",list.get(i).getTeacher_name());
			map.put("user_name",list.get(i).getTeacher_name());
			map.put("username",list.get(i).getUsername());
			map.put("password",list.get(i).getPassword());
			map.put("role",list.get(i).getRole());
			map.put("role_id",list.get(i).getRole_id());
            if(((teacherDao.insert(map)) == 1)&&((userDao.insert(map)) == 1)) {
            	num++;
            }
        }
        if(num == list.size()) {
        	result = "success";
        }
		log.debug("**********UpLoadTeService  javaPoi result:"+result+"**********");
		log.debug("**********UpLoadTeService  javaPoi out**********");

      return result;
    }
    
    /**
     * 读取excel中的数据，返回list集合
     */
     @Override
     public List<TeacherAndUser> readXls(MultipartFile file) throws IOException {
 		log.debug("**********UpLoadTeService  readXls in**********");

    	//文件地址
        //InputStream is = new FileInputStream("D:\\classes.xls");
        InputStream is = file.getInputStream();
        
        
        XSSFWorkbook  hssfWorkbook = new XSSFWorkbook (is);
        TeacherAndUser teacherAndUser = null;
        List<TeacherAndUser> list = new ArrayList<TeacherAndUser>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
        	// 获取每一个工作薄
        	XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
        	//Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                //创建序号为rownum的行
            	Row hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                	teacherAndUser = new TeacherAndUser();
                    //创建rownum行teacher_name这一列的单元格的数据
                    Cell teacher_name = hssfRow.getCell(1);
                    //创建rownum行username这一列的单元格的数据
                    Cell username = hssfRow.getCell(2);
                    //创建rownum行password这一列的单元格的数据
                    Cell password = hssfRow.getCell(3);
                    //创建rownum行role这一列的单元格的数据
                    Cell role = hssfRow.getCell(4);
                    //设置id
                    //teacherAndUser.setUser_id(Integer.parseInt(getValue(id)));
                    teacherAndUser.setUser_id(1);
                    //设置username
                    teacherAndUser.setUsername(getValue(username));
                    
                   /**
                    * 注：从Excel中取出的纯数字数据为double类型，通过字符串截取即可去掉小数
                    */
                 	//设置password
                    teacherAndUser.setPassword(getValue(password).substring(0, 6));
                    //设置role
                    teacherAndUser.setRole(getValue(role));
                    //设置role_id
                    teacherAndUser.setRole_id("2");
                    //设置teacher_id
                    teacherAndUser.setTeacher_id(1);
                    //设置teacher_name
                    teacherAndUser.setTeacher_name(getValue(teacher_name));
                  //添加到list集合中
                    list.add(teacherAndUser);
                }
            }
        }
		log.debug("**********UpLoadTeService  readXls out**********");

        return list;
    }
     /**
      * 获取单元格内的数据
      */
    @Override
    public String getValue(Cell hssfCell) {
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

