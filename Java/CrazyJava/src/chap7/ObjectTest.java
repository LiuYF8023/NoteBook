package chap7;

import java.util.Objects;

public class ObjectTest {
	static ObjectTest obj = null;
	public static void main(String[] args) {
		System.out.println(Objects.toString(obj));
		System.out.println(Objects.hashCode(obj));
		// TODO: 2023/1/12 通常下面的用于验证不能为空 
		System.out.println(Objects.requireNonNull(obj,"不能为null"));
	}
}
