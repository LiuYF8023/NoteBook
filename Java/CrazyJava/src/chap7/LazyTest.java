package chap7;

import java.util.Calendar;

public class LazyTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2003,7,31); // 这是设置为8月
		System.out.println(cal.getTime());
		cal.set(Calendar.MONTH,8); // 这是设置为9月 但是9月没有31号，所以会显示10月1号
//		System.out.println(cal.getTime());
		cal.set(Calendar.DATE,5);
		System.out.println(cal.getTime());
	}
}
