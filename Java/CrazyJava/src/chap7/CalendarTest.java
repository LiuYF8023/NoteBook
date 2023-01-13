package chap7;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		// Calendar是抽象类，不能用构造器，但是可以使用getInstance方法获取对象
		Calendar c = Calendar.getInstance();
		// 取出Date对象
		Date date = c.getTime();

		// 因为Calendar没有构造器，所以想要把Date转为Calendar 必须先构建Calendar实例，然后传参数
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date);

		// Calendar的常用方法
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONDAY));
		System.out.println(calendar.get(Calendar.DATE));
		c.set(2003,10,23,12,32,12);
		System.out.println(c.getTime());

		// 向前推一年
		c.add(Calendar.YEAR,-1);
		// 向前推八个月
		c.roll(Calendar.MONTH,-8);
		System.out.println(c.getTime());

		System.out.println("=========================");
		// add
		Calendar call = Calendar.getInstance();
		call.set(2003,10,30,12,32,12);
		call.add(Calendar.MONTH,3);
		System.out.println(call.getTime());
		call.add(Calendar.MONTH,3);
		System.out.println(call.getTime());
	}
}
