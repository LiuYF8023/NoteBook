package chap7;

import java.util.Arrays;
import java.util.List;

public class FixedSizeList {
	public static void main(String[] args) {
		List fixedList = Arrays.asList("asgfas","asf");
		System.out.println(fixedList.getClass());
		fixedList.forEach(System.out::println);
	}
}
