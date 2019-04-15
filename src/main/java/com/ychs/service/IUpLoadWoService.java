package com.ychs.service;

import java.io.IOException;

public interface IUpLoadWoService {
    
    /**
     * 读取并添加到数据库
     */
    public String javaPoi()throws  IOException;
    
    /**
     * 读取word表格中的数据，返回list集合
     */
    public void readXls() throws IOException ;

    /**
     * 读取word中的内容
     * @throws IOException
     */
    public void readWordDocx() throws IOException;


}

