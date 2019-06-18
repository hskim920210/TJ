package khs.model;

import java.util.*;
import java.text.*;

public class User {
	private String user_id;
	private String user_pw;
	private String user_nick;
	private int user_tel;
	private String user_mail;
	private Date user_regist_date;
	private int user_count_day;

	public User() {}

	public User(String user_id, String user_pw, String user_nick, int user_tel, String user_mail, Date user_regist_date,
			int user_count_day) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_nick = user_nick;
		this.user_tel = user_tel;
		this.user_mail = user_mail;
		this.user_regist_date = user_regist_date;
		this.user_count_day = user_count_day;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public int getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(int user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public Date getUser_regist_date() {
		return user_regist_date;
	}
	
	public String getUser_regist_dateString() {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");		
		return sdf.format(user_regist_date);
	}

	public void setUser_regist_date(Date user_regist_date) {
		
		this.user_regist_date = user_regist_date;
	}

	public int getUser_count_day() {
		return user_count_day;
	}

	public void setUser_count_day(int user_count_day) {
		this.user_count_day = user_count_day;
	}

	
	
	
	
	
}
	
	
	/*

	public User(String member_id, String password, String name, int gender, int age, Date birth, String tel,
			String address, Date regist_date, Date last_access_time) {
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birth = birth;
		this.tel = tel;
		this.address = address;
		this.regist_date = regist_date;
		this.last_access_time = last_access_time;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public String getGenderString() {
		return gender == 1 ? "남성" : "여성";
	}
	
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getBirthString() {
		if( birth == null )
			return "생년월일이 입력되지 않았습니다.";
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy년 MM월 dd일");		
		return sdf.format(birth);
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public void setBirth(int year, int month, int day) {
		if( year == 0 || month == 0 || day == 0 )
			return;
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		String source = String.format("%04d-%02d-%02d", 
				year, month, day);
		try {
			this.birth = sdf.parse(source);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
	}
	
	public void setBirth(String source) {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");		
		try {
			this.birth = sdf.parse(source);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
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

	public String getRegist_dateString() {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy년 MM월 dd일");		
		return sdf.format(regist_date);
	}
	
	public Date getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}

	public String getLast_access_timeString() {
		if( last_access_time == null )
			return "로그인 이력이 존재하지 않습니다.";
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");		
		return sdf.format(last_access_time);
	}
	
	public Date getLast_access_time() {
		return last_access_time;
	}

	public void setLast_access_time(Date last_access_time) {
		this.last_access_time = last_access_time;
	}


*/

