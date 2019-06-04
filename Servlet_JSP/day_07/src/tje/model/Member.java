package tje.model;

public class Member {
    private String id;
	private String password;
	private String name;
	private int age;
	private String tel;
	private String address;
	
	public Member() {
	}
	
	public Member(String id, String password, String name, int age, String tel, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.address = address;
	}
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
