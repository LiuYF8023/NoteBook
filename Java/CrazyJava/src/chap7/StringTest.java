package chap7;

import java.nio.charset.Charset;

public class StringTest {
	public static void main(String[] args) {
		// 创建一个包含0个字符的String对象，不是null
		String s1 = new String();
		// 使用指定byte数组，转换成指定字符编码的String对象
		byte[] b1 = new byte[]{'1','2'};
		String s2 = new String(b1, Charset.forName("utf-8"));
		System.out.println(s2);
		// 根据StringBuffer创建String对象
		StringBuffer sb = new StringBuffer("123");
		String s3 = new String(sb);
		System.out.println(s3);
		StringBuilder sb2 = new StringBuilder("123");
		String s4 = new String(sb2);
		System.out.println(s4);

		// 常用方法
		// 获取指定位置的字符 charAt()
		// 判断是否是以某个字符串结尾
		String s5 = new String("akjshgjkalkf.com");
		System.out.println(s5.endsWith(".com"));

		// 忽略大小写进行比较
		String s6 = new String("Abc");
		String s7 = new String("abc");
		System.out.println(s6.equalsIgnoreCase(s7));

		// 字符串出现的位置
		String s8 = new String("askfhkalhakgnjklasdf");
		// 第一次出现的位置
		System.out.println(s8.indexOf('a'));
		// 在某个位置之后，第一次出现的位置 返回的是绝对位置
		System.out.println(s8.indexOf('a',3));
		// 子串的位置
		System.out.println(s8.indexOf("hakg"));

		// lastIndexOf 相同的道理，最后出现的位置

		// replace 替换旧字符串为新字符串
		String s9 = new String("asfjhkkjasfn");
		// 是否以xxx字符串开头
		System.out.println(s9.startsWith("asf"));

		// 将一些基本类型转为String
		String s10 = String.valueOf(10);
		// 将String转为基本类型
		int a = Integer.parseInt(s10);
	}
}
