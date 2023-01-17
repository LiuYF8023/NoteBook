package chap9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiamondTest {
	public static void main(String[] args) {
		List<String> books = new ArrayList<>();
		books.add("疯狂Java讲义");
		books.add("疯狂IOS讲义");
		books.forEach(ele -> System.out.println(ele.length()));

		Map<String,List<String>> schoolsInfo = new HashMap<>();
		List<String> schools = new ArrayList<>();
		schools.add("ajhgfk");
		schools.add("skjgfk");
		schoolsInfo.put("sgdf",schools);
		schoolsInfo.forEach((key,value) -> System.out.println(key + "=" + value));
	}
}
