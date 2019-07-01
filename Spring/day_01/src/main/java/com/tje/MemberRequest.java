package com.tje;

// 모델 클래스의 정보를 저장하고 있는 요청 객체
// DI 사용하지 않고 소스코드 상에서 정보를 입력

public class MemberRequest {
	private Member member;

	public MemberRequest() {
		member = new Member();
		member.setName("ABC");
		member.setAge(22);
	}
	
	public Member getMember() {
		return this.member;
	}
	
}
