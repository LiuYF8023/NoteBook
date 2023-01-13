package chap7;

import java.math.BigDecimal;

public class Arith {
	private static final int DEF_DIV_SCALE = 10;
	private Arith(){

	}
	public static double add(double v1,double v2){
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.add(b2).doubleValue();

	}
	public static void main(String[] args) {
		System.out.println(Arith.add(1,2));

	}
}
