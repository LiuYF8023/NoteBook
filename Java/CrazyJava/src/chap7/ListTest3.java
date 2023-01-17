package chap7;

import java.util.ArrayList;
import java.util.List;

public class ListTest3 {
	public static void main(String[] args) {
		List books = new ArrayList();
		books.add("askjmfgak");
		books.add("asldfghkl");
		books.add("akshgkja");
		books.add("akjsfdhgj");
		books.sort((o1,o2) -> ((String)o1).length() - ((String)o2).length());
		System.out.println(books);
		books.replaceAll(ele ->((String)ele).length());

	}
}
