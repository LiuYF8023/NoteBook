package chap7;

import com.alibaba.fastjson.JSONObject;

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
//		User u1 = new User(29);
//		User u2 = u1.clone();
//		System.out.println(u1 == u2);
//		System.out.println(u1.address == u2.address);

		Address add = new Address("南山");
		User u3 = new User(27,add);
		User u4 = JSONObject.parseObject(JSONObject.toJSONBytes(u3),User.class);
		System.out.println(u3 == u4);
		System.out.println(u3.address == u4.address);
	}
}

class Address{
	String detail;

	public Address(String detail){
		this.detail = detail;
	}
}

// 实现Cloneable接口
class User{
	int age;
	Address address;
	public User(int age,Address address){
		this.age = age;
		this.address = address;
	}
}
