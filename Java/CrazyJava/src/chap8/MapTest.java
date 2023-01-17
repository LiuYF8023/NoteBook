package chap8;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("Java",12873);
		map.put("C",1534);
		map.put("Go",128423573);
		System.out.println(map.containsKey("Java"));
		System.out.println(map.containsValue(1534));
		for (Object key: map.keySet()){
			System.out.println(key + " = " + map.get(key));
		}
	}
}
