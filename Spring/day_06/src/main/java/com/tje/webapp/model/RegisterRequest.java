package com.tje.webapp.model;

// 커맨드 객체로 사용되는 모델 클래스의 선언
// 커맨드 객체 : 클라이언트가 전달하는 요청 객체로부터 
//			  파라메터 정보를 추출하여 생성되는 객체
// 주의사항 !
// input 태그에 정의되는 name 속성과 동일한 이름의 멤버필드를 선언해야 한다.
// 대소문자까지 완벽히 일치해야 한다.
public class RegisterRequest extends Member {
	private String confirmPassword;
	
	public RegisterRequest() {
	}

	public RegisterRequest(String email, String name, String password, String confirmPassword) {
		super(0, email, password, name, null);
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return super.getEmail();
	}

	public void setEmail(String email) {
		super.setEmail(email);;
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}

	public String getPassword() {
		return super.getPassword();
	}

	public void setPassword(String password) {
		super.setPassword(password);
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
