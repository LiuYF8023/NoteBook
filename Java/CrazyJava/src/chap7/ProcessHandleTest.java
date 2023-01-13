package chap7;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class ProcessHandleTest {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		// 运行笔记本程序
		try {

			Process p = rt.exec("notepad.exe");
			ProcessHandle ph = p.toHandle();
			System.out.println("进程是否运行：" + ph.isAlive());
			System.out.println("进程ID：" + ph.pid());
			System.out.println("父进程：" + ph.parent());

			// 获取ProcessHandle.info的信息
			ProcessHandle.Info info = ph.info(); // ProcessHandle.Info 内部接口

			System.out.println("进程命令：" + info.command());
			System.out.println("进程参数：" + info.arguments());
			System.out.println("进程启动时间：" + info.startInstant());
			System.out.println("进程累计运行时间：" + info.totalCpuDuration());

			// 通过CompletableFuture在进程结束的时候运行某个任务
			CompletableFuture<ProcessHandle> cf = ph.onExit();
			cf.thenRunAsync(()->{
				System.out.println("程序退出！");
			});
			Thread.sleep(5000);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
}
