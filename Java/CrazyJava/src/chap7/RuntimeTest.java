package chap7;

import java.io.IOException;

public class RuntimeTest {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.availableProcessors());
		System.out.println(rt.freeMemory());
		System.out.println(rt.maxMemory());

		// 还可以单独启动一个进程来运行操作系统的命令
		try {
			System.out.println(rt.exec("notepad.exe"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
