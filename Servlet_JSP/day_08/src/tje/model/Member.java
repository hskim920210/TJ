package tje.model;

public class Member {
	public String id;
	public String password;
	public String name;
	
	public void printInfo() {
		String msg = String.format("id : %s, pw : %s, name : %s", id, password, name);
		System.out.println(msg);
	}
	
	// 자바빈 객체를 선언하여 setter, getter 메소드를
	// 정의해야만 EL 언어에서 해당 클래스의 멤버필드의 값을
	// 추출할 수 있다. (접근 지정자가 public으로 지정되어도 안됨)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
