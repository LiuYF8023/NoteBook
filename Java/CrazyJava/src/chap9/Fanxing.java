package chap9;

import java.util.Set;

public class Fanxing {
	public static void main(String[] args) {

	}
}

interface List<E> {
	void add(E e);
	Iterable<E> iterator();
}

interface Iterator<E>{
	// E 完全可以当做类型使用
	E next();
	boolean hasNext();
}

interface Map<K,V> {
    Set<K> keySet();

}
