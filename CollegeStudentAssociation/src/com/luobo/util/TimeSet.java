package com.luobo.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSet {
	public static String currentDate(){
		 //ȡ��ǰʱ��
        Date nowdate=new Date();
        //ת��ʱ���ʽ
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  simpleDate.format(nowdate);
        
	}
	

}
