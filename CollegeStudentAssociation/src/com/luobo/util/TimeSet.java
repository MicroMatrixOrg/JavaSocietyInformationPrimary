package com.luobo.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSet {
	public static String currentDate(){
		 //取当前时间
        Date nowdate=new Date();
        //转换时间格式
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  simpleDate.format(nowdate);
        
	}
	

}
