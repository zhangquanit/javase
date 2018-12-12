package cn.java.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 张全
 */
public class SimpleDateFormatTest {

	public static void main(String[] args) {

		testFormat();
	}

	/**
	 * E 星期 EEE表示只显示三位 比如Sat d 日 dd 表示显示2位日期 M 月 MMM 表示显示3位 y 年 yyyy显示4位 H 小时 m
	 * 分 s 秒 z 时区
	 */
	public static void testFormat() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		// 星期一,31 三月 2014 04:17:03 GMT
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE,dd MMM yyyy HH:mm:ss z", Locale.CHINA);
		System.out.println(format.format(new Date()));
		// Sat,29 Mar 2014 08:34:51 GMT
		format = new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss z", Locale.US);
		System.out.println(format.format(new Date()));
		
//		String[] timezones=TimeZone.getAvailableIDs();
//		for(String item:timezones){
//			System.out.println(item);
//		}
		
		TimeZone defauleTimeZone = TimeZone.getDefault();
		System.out.println(defauleTimeZone);

	}

}
