package chap8;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("Java",12873);
		map.put("C",1534);
		map.put("Go",128423573);
		// 尝试替换key
		map.replace("疯狂XML讲义",66);
		System.out.println(map);
		// 使用原value与传入参数计算的结果覆盖原有value
		map.merge("疯狂ios讲义",10,(oldVal,para) -> (Integer)oldVal + (Integer) para);
		System.out.println(map);
	}
}
