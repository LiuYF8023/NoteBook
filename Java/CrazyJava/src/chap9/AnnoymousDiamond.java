package chap9;

public class AnnoymousDiamond {
	public static void main(String[] args) {
		Foo<String> f = new Foo<String>() {
			@Override
			public void test(String s) {
				System.out.println();
			}
		};

		Foo<?> fo = new Foo<>() {
			@Override
			public void test(Object o) {
				System.out.println();
			}
		};

		Foo<? extends Number> fn = new Foo<Number>() {
			@Override
			public void test(Number number) {
				System.out.println();
			}
		};
	}
}

interface Foo<T>{
	void test(T t);
}
