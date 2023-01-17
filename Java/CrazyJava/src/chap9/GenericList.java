package chap9;

import java.util.ArrayList;
import java.util.List;

public class GenericList {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("ak,sjfk");
		strList.add("ak,sjfk");
		strList.add("ak,sjfk");
//		strList.add(5);
		strList.forEach(str -> System.out.println(str.length()));
	}
}
