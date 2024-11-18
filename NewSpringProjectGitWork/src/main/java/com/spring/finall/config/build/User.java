package com.spring.finall.config.build;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

	private String name;
	private String sex;
	private int age;

	public static class UserBuilder {

		@Id
		// 필수로 장착시킬 필드를 선언
		private String name;
		// 선택 옵션 사항으로 장착시킬 필드를 선언
		private String sex;
		private int age;

		// 먼저 필수 장착 빌더 생성자를 만들어야한다 그리구 점차 확장하면서 빌더 하는거임
		public UserBuilder(String name) {
			this.name = name;

		}

		// 선택 적으로 장착시킬 것만들기
		public UserBuilder setSex(String sex) {
			this.sex = sex;
			return this;

		}

		// 선택 적으로 장착시킬 것만들기
		public UserBuilder setSex(int age) {
			this.age = age;
			return this;

		}

		// 이제 필수와 옵션 장착한 빌더를 User 화 하여 반납
		public User Builer() {
			return new User(this);

		}
	}// 중첩 UserBuiler 클래스 종료

	private User(UserBuilder builder) {
		this.name = builder.name;
		this.sex = builder.sex;
		this.age = builder.age;

	}

	@Override
	public String toString() {

		return "[이름= " + this.name + " 성별 " + this.name + " 나이 " + this.age + "]";

	}

}// User 클래스 종료
