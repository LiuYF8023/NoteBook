package chap7;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SeedTest {
	public static void main(String[] args) {
		Random r1 = new Random(50);
		Random r2 = new Random(50);
		Random r3 = new Random(100);
		System.out.println(r1.nextInt());
		System.out.println(r2.nextInt());
		System.out.println(r3.nextInt());

		// 使用时间作为种子
		Random rand = new Random(System.currentTimeMillis());
		System.out.println(rand.nextInt());

		// 多线程随机
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		int val1 = tlr.nextInt();
		System.out.println(val1);
	}
}
