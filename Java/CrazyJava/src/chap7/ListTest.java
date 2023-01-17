package chap7;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List books = new ArrayList();
		books.add("jaksgk");
		books.add("jaksgk");
		books.add("jaksgk");
		books.add("jaksgk");
		System.out.println(books);
		books.add(1,new String("asjfgk"));
		for (int i = 0;i < books.size();i++){
			System.out.println(books.get(i));
		}
		books.remove(3);
		System.out.println(books);
		// 判定位置
		System.out.println(books.indexOf(new String("asjfgk")));
		// 将第二个替换成新的字符串对象
		books.set(1,new String("askjdfhak"));
		System.out.println(books);
		// 截取子集合
		System.out.println(books.subList(1,3));

	}
}
