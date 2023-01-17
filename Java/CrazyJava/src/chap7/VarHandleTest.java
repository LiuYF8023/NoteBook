package chap7;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VarHandleTest {
	public static void main(String[] args) throws Throwable{
		String[] sa = new String[]{"JAVA", "Kotlin", "GO"};
		// 获取sa的VarHandle对象
		VarHandle vh = MethodHandles.arrayElementVarHandle(String[].class);
		// 比较并设置
		boolean r = vh.compareAndSet(sa, 2, "GO", "Lua");
		System.out.println(r);

		// 获取sa数组的第二个元素
		System.out.println(vh.get(sa, 1));

		// 获取并设置第三个元素
		System.out.println(vh.getAndSet(sa, 2, "Swift"));

		//
		VarHandle vh2 = MethodHandles.lookup().findVarHandle(User2.class,"name", String.class);

		User2 u2 = new User2();
		vh2.set(u2,"sunwukong");

		System.out.println(u2.name);
		VarHandle vh3 = MethodHandles.lookup().findStaticVarHandle(User2.class,"MAX_AGE", int.class);
		vh3.set(37);
		System.out.println(User2.MAX_AGE);

	}
}

class User2 {
	String name;
	static int MAX_AGE;
}
