package chap7;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
	private static void hello() {
		System.out.println("hello world !");
	}

	private int hello(String name) {
		System.out.println("执行带参数的hello" + name);
		return 1;
	}

	public static void main(String[] args) throws Throwable {
		// 获取类方法
		MethodType type = MethodType.methodType(void.class);
		MethodHandle mtd = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", type);
		mtd.invoke();

		// 获取实例方法
		MethodHandle mtd2 = MethodHandles.lookup()
				.findVirtual(MethodHandleTest.class, "hello", MethodType.methodType(int.class, String.class));
		System.out.println(mtd2.invoke(new MethodHandleTest(),"孙悟空"));
	}
}
