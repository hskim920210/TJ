package com.tje;

// 모델 클래스의 정보를 저장하고 있는 요청 객체
// 생성자를 통한 DI 방법을 구현

public class MemberRequestUsingDI {
	private Member member;

	// 스프링 컨테이너에서 전달받은 멤버객체로 초기화
	public MemberRequestUsingDI(Member member) {
		this.member = member;
	}
	
	public Member getMember() {
		return this.member;
	}
	
}
