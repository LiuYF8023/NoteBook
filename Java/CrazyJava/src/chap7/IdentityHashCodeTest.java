package chap7;

public class IdentityHashCodeTest {
	public static void main(String[] args) {
		// 两个对象指向的都是Hello
		String s1 = new String("Hello");
		String s2 = new String("Hello");

		// 由于String的Hash计算规则是 根据字符串内容，所以HashCode是一样的
		System.out.println(s1.hashCode() == s2.hashCode());

		// 使用System的方法去判断
		System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));

		//
		String s3 = "Java";
		String s4 = "Java";
		System.out.println(System.identityHashCode(s3) == System.identityHashCode(s4));
	}
}
