package com.ychs.service;

import org.apache.log4j.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.ychs.dao.ITeacherDao;
import com.ychs.dao.IUserDao;

/**
 * 上传word
 * @author 李少石
 * 
 */
@Service
public class UpLoadWoService  implements IUpLoadWoService {
	
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
     * @throws IOException 
     */
    @Override
   // public String javaPoi(MultipartFile file)throws  IOException{
     public String javaPoi() throws IOException{
		log.debug("**********UpLoadTeService  javaPoi in**********");
		String result = "false";
		
	       //readXls();
	       readWordDocx();
	    
		log.debug("**********UpLoadTeService  javaPoi result:"+result+"**********");
		log.debug("**********UpLoadTeService  javaPoi out**********");

      return result;
    }
    
    /**
     * 读取word表格中的数据
     * @throws IOException 
     */
     @Override
     //public void readXls(MultipartFile file) throws IOException {
    public void readXls() throws IOException{
 		log.debug("**********UpLoadTeService  readXls in**********");
      //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后  
 		String filePath = "D:\\new.docx";
 		try{  
            //如果是office2007  docx格式  
            if(filePath.toLowerCase().endsWith("docx")){  
                FileInputStream in = new FileInputStream(filePath);//载入文档  
               //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后     
                XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息  
                Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格  
                while(it.hasNext()){  
                    XWPFTable table = it.next();    
                    List<XWPFTableRow> rows=table.getRows();   
                    //读取每一行数据  
                    for (int i = 0; i < rows.size(); i++) {  
                        XWPFTableRow  row = rows.get(i);  
                        //读取每一列数据  
                        List<XWPFTableCell> cells = row.getTableCells();   
                        for (int j = 0; j < cells.size(); j++) {  
                            XWPFTableCell cell=cells.get(j);  
                            //输出当前的单元格的数据   
                     		log.debug("**********UpLoadTeService  readXls cell.getText():"+cell.getText()+"**********");
                       }  
                    }  
                }
            }else{  
        		log.debug("**********UpLoadTeService  readXls 所选文件格式错误，应为.docx文件**********");
            }  
         }catch(Exception e){  
          e.printStackTrace();  
         }  
		log.debug("**********UpLoadTeService  readXls out**********");
        //return list;
     }
     
     /**
      * 读取word中的内容
      * @throws IOException 
      */
     @Override
    public void readWordDocx() throws IOException {
        File file = new File("D:\\new.docx");
        try {
        	FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc1 = extractor.getText();
     		log.debug("**********UpLoadTeService  readWordDocx doc1："+doc1+"**********");
     		String paperName = doc1.substring(doc1.indexOf("试卷题目:")+1, doc1.indexOf("教师姓名:"));
     		String teacherName = doc1.substring(doc1.indexOf("教师姓名:")+1, doc1.indexOf("单选题"));
     		String singleChoice = doc1.substring(doc1.indexOf("单选题")+1, doc1.indexOf("判断题"));
     		String Check = doc1.substring(doc1.indexOf("判断题")+1, doc1.indexOf("填空题"));
     		String FillBlank = doc1.substring(doc1.indexOf("填空题")+1, doc1.indexOf("多选题"));
     		String MultipleChoice = doc1.substring(doc1.indexOf("多选题")+1);
     		log.debug("**********UpLoadTeService  readWordDocx paperName："+paperName+"**********");
     		log.debug("**********UpLoadTeService  readWordDocx teacherName："+teacherName+"**********");
     		log.debug("**********UpLoadTeService  readWordDocx singleChoice："+singleChoice+"**********");
     		log.debug("**********UpLoadTeService  readWordDocx Check："+Check+"**********");
     		log.debug("**********UpLoadTeService  readWordDocx FillBlank："+FillBlank+"**********");
     		log.debug("**********UpLoadTeService  readWordDocx MultipleChoice："+MultipleChoice+"**********");

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
}

