package chap7;

public class SystemMethodTest {
	public static void main(String[] args) {
		// 获取系统时间
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime()); // 以纳秒为单位

		// 返回对象的精确HashCode 即使自定义类的HashCode方法被重写了，也不影响
		String s = new String("asda");
		System.out.println(System.identityHashCode(s));
	}
}
