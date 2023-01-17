package chap7;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

public class EnumSetTest2 {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.clear();
		c.add(Season.SPRING);
		c.add(Season.WINNER);
		// 复制Collection集合中的所有元素来创建EnumSet集合
		EnumSet es = EnumSet.copyOf(c);
		System.out.println(es);
		c.add("askjfhafk");
//		es = EnumSet.copyOf(c); 出问题
		System.out.println(es);
	}
}
