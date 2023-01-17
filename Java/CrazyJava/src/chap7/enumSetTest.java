package chap7;

import java.util.EnumSet;

public class enumSetTest {
	public static void main(String[] args) {
		// 创建一个Season枚举类集合
		EnumSet se = EnumSet.allOf(Season.class);
		System.out.println(se);
		// 创建一个EnumSet空集合，指定其集合元素是Season类的枚举值
		EnumSet se2 = EnumSet.noneOf(Season.class);
		System.out.println(se2);
		// 手动添加元素
		se2.add(Season.SPRING);
		System.out.println(se2);
		// 以指定枚举值创建集合
		EnumSet se3 = EnumSet.of(Season.SPRING,Season.WINNER);
		System.out.println(se3);
		//
		EnumSet se4 = EnumSet.range(Season.SPRING,Season.FALL);
		System.out.println(se4);
		EnumSet se5 = EnumSet.complementOf(se4); // se5 + se4 = Season
		System.out.println(se5);

	}
}

enum Season{
	SPRING,SUMMER,FALL,WINNER
}
