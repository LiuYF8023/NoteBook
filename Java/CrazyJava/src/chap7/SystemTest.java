package chap7;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SystemTest {
	public static void main(String[] args) {
		// 获取系统的所有环境变量
		Map<String,String> env = System.getenv();
		for (String name: env.keySet()) {
			System.out.println(name);
		}
		System.out.println("================");
		for (String name: env.values()) {
			System.out.println(name);
		}
		System.out.println("获取指定环境变量的值" + System.getenv("JAVA_HOME"));
		// 将所有的系统属性保存到prop中
		Properties props = System.getProperties();
		try {
			props.store(new FileOutputStream("prop.txt"),"System properties");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// 输出指定的值
		System.out.println(System.getProperty("os.name"));
	}
}
