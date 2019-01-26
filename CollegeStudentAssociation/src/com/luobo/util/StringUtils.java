package com.luobo.util;

public class StringUtils {
	public static boolean isEmpty(String string){
		if("".equals(string)||string == null){
			return true;
		}
		return false;
	}
}
