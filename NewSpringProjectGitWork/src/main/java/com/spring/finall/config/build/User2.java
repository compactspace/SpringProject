package com.spring.finall.config.build;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity

@Builder
@AllArgsConstructor
public class User2 {
	@Id
	private String name;
	// 자바 문법용으로 pubiic 처리함
	public String sex;
	private int age;

	@Builder
	@AllArgsConstructor
	public static class ReqUserDTO {

		private String name;
		// 메인클래스에서 문법 확이용으로 public으로 둠
		public String sex;
		private int age;

		//

		public ReqUserDTO builder() {

			return new ReqUserDTO();
		}

		// 이부분이
		public ReqUserDTO() {
		}

		// 선택 적으로 장착시킬 것만들기
		public ReqUserDTO setSex(String sex) {
			this.sex = sex;
			return this;

		}

		// 선택 적으로 장착시킬 것만들기
		public ReqUserDTO setSex(int age) {
			this.age = age;
			return this;

		}

		// 이제 필수와 옵션 장착한 빌더를 User 화 하여 반납
		// 한편 이걸 인터넷에선 toEntity 라 하니 그 렇게 하자.
//		public User2 builder() {
//			return new User2(this);
//
//		}

		public User2 toEnity() {
			return new User2(this);
		}

	}// 중첩 클래스 ReqUserDTOBuilder 종료

	public User2(ReqUserDTO reqdto) {
		this.name = reqdto.name;
		this.sex = reqdto.sex;
		this.age = reqdto.age;
	}

	@Getter

	public static class ResUserDTO {
		private String name;
		// 메인클래스에서 문법 확이용으로 public으로 둠
		public String sex;
		private int age;

		public ResUserDTO() {

		}

		public ResUserDTO toresDto(User2 user) {

			this.name = user.name;
			this.sex = user.sex;
			this.age = age;
			return this;

		}

	}// 중첩클래스 ResUserDTO 종료

}
