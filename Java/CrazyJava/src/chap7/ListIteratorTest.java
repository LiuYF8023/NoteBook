package chap7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
	public static void main(String[] args) {

		List bookList = new ArrayList();
		bookList.add("1");
		bookList.add("2");
		bookList.add("3");
		bookList.add("4");
		ListIterator it = bookList.listIterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		while (it.hasPrevious()){
			System.out.println(it.previous());
		}
	}
}
