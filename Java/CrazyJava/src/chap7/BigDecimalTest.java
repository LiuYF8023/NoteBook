package chap7;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = BigDecimal.valueOf(0.01);
		BigDecimal f3 = new BigDecimal(0.05);
		System.out.println(f1.add(f2));
		System.out.println(f1.subtract(f2));
		System.out.println(f1.multiply(f2));
		System.out.println(f1.divide(f2));

		// 下面的容易精度丢失
		System.out.println(f3.add(f2));
		System.out.println(f3.subtract(f2));
		System.out.println(f3.multiply(f2));
		System.out.println(f3.divide(f2));
	}
}
