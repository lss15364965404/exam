package com.ychs.service;
/**
 * 上传service
 */
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

import com.ychs.bean.StudentAndUser;
import com.ychs.bean.Class;
import com.ychs.dao.IClassDao;
import com.ychs.dao.IStudentDao;
import com.ychs.dao.IUserDao;


@Service
public class UpLoadStService  implements IUpLoadStService {
	
	/**
	 * 日志声明
	 */
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IStudentDao studentDao;
	@Resource
	private IUserDao userDao;
	@Resource
	private IClassDao classDao;

    /**
     * 读取并添加到数据库
     */
    @Override
    public String javaPoi(MultipartFile file)throws  IOException{
		log.debug("**********UpLoadStService  javaPoi in**********");
		String result = "false";
		int num = 0;
        List<StudentAndUser> list = readXls(file);
		log.debug("**********UpLoadStService  javaPoi list:"+list+"**********");
		Map<String, Object> map = new HashMap<String, Object>();
        for(int i=0;i < list.size();i++){
			map.put("student_name",list.get(i).getStudent_name());
			map.put("user_name",list.get(i).getStudent_name());
			map.put("class_id",list.get(i).getClass_id());
			map.put("username",list.get(i).getUsername());
			map.put("password",list.get(i).getPassword());
			map.put("role",list.get(i).getRole());
			map.put("role_id",list.get(i).getRole_id());
            if(((studentDao.insert(map)) == 1)&&((userDao.insert(map)) == 1)) {
            	num++;
            }
        }
        if(num == list.size()) {
        	result = "success";
        }
		log.debug("**********UpLoadStService  javaPoi result:"+result+"**********");
		log.debug("**********UpLoadStService  javaPoi out**********");

      return result;
    }
    
    /**
     * 读取excel中的数据，返回list集合
     */
     @Override
     public List<StudentAndUser> readXls(MultipartFile file) throws IOException {
 		log.debug("**********UpLoadStService  readXls in**********");

    	//文件地址
        //InputStream is = new FileInputStream("D:\\classes.xls");
        InputStream is = file.getInputStream();
        
        XSSFWorkbook  hssfWorkbook = new XSSFWorkbook (is);
        StudentAndUser studentAndUser = null;
        List<StudentAndUser> list = new ArrayList<StudentAndUser>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
        	// 获取每一个工作薄
        	XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                //创建序号为rownum的行
            	Row hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                	studentAndUser = new StudentAndUser();
                	
                    //创建rownum行student_name这一列的单元格的数据
                    Cell student_name = hssfRow.getCell(1);
                  //创建rownum行student_name这一列的单元格的数据
                    Cell class_name = hssfRow.getCell(2);
                    //创建rownum行username这一列的单元格的数据
                    Cell username = hssfRow.getCell(3);
                    //创建rownum行password这一列的单元格的数据
                    Cell password = hssfRow.getCell(4);
                    
                    //设置user_id
                    //studentAndUser.setUser_id(Integer.parseInt(getValue(id)));
                    studentAndUser.setUser_id(1);
                    //设置username
                    studentAndUser.setUsername(getValue(username));
                   /**
                    * 注：从Excel中取出的纯数字数据为double类型，通过字符串截取即可去掉小数
                    */
                 	//设置password
                    studentAndUser.setPassword(getValue(password).substring(0, 6));
                    //设置role
                    studentAndUser.setRole("学生");
                    //设置Role_id
                    studentAndUser.setRole_id("3");
                    //设置User_id
                    studentAndUser.setStudent_id(1);
                    //设置teacher_name
                    studentAndUser.setStudent_name(getValue(student_name));
                    //设置class_id
            		Map<String, Object> map = new HashMap<String, Object>();
            		map.put("class_name", (getValue(class_name).substring(0, 7)));
            		List<Class> list_cl = classDao.selectClassByCondition(map);
            		log.debug("**********UpLoadStService  readXls list_cl:"+list_cl+"**********");
            		Class cl = list_cl.get(0);
                    studentAndUser.setClass_id(cl.getClass_id());
                    
                  //添加到list集合中
                    list.add(studentAndUser);
                }
            }
        }
		log.debug("**********UpLoadStService  readXls out**********");

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

