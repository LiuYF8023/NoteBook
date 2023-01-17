package chap8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Throwable {
		Properties props = new Properties();
		props.setProperty("username","afyu");
		props.setProperty("password","123134");
		// 将key value保存到a.ini文件中
		props.store(new FileOutputStream("a.ini"),"comment line");
		Properties props2 = new Properties();
		props2.setProperty("adjhfgas","skjf");
		props2.load(new FileInputStream("a.ini"));
		System.out.println(props2);
	}
}
