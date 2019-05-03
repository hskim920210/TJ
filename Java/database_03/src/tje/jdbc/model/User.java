package tje.jdbc.model;


public class User {
	private String id, password, name, alias, tel;
	
	public User() {}

	public User(String id, String password, String name, String alias, String tel) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.alias = alias;
		this.tel = tel;
	}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public User(String id) {
		this.id = id;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String toString() {
		String info = 
				String.format("ID : %s \nPASSWORD : %s \nNAME : %s \nALIAS : %s \nTEL : %s" , 
						id, password, name, alias, tel);
		return info;
//		return "id : " + this.id + "\npw : " + this.password + "\nname : " + this.name 
//				+ "\nalaias : " + this.alias + "\ntel : " + this.tel;
	}
	
}
