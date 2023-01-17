package chap8;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList books = new LinkedList();
		books.offer("amgjkdsjg"); // 尾部加入
		books.push("amhfshdjbg"); // 顶部加入
		books.offer("顶部加入");
	}
}
