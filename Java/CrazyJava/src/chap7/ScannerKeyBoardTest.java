package chap7;

import java.util.Scanner;

public class ScannerKeyBoardTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 只把回车作为分隔符
		sc.useDelimiter("\n");
		while (sc.hasNextInt()){
			System.out.println("键盘输入的是：" + sc.nextInt());
		}
	}
}
