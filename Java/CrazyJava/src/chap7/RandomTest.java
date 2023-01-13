package chap7;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextBoolean());
		// 随机填充数组
		byte[] b = new byte[16];
		r.nextBytes(b);
		System.out.println(Arrays.toString(b));
		// 生成高斯数
		System.out.println(r.nextGaussian());
		// 生成0-26之间的伪随机数
		System.out.println(r.nextInt(26));

	}
}
