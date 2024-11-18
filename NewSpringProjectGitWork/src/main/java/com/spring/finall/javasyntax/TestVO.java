package com.spring.finall.javasyntax;


//여기서 주의할 점은
//반드시 !!!  JSON으로 직렬화 시킬 클래스에 Getter가 존재해야 한다는 것이다.
// 현재 name 필드는 get set 메서드가 없어서 직렬화 대상이 아님!
public class TestVO {
	
	private String name;
	private int age;
	private String sex;
	
	public TestVO (int age, String sex ) {
		this.age=age;
		this.sex=sex;	
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
