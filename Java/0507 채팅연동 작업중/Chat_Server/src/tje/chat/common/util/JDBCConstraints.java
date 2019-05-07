package tje.chat.common.util;

// 실행 전에 
// create database naver;
// create table info (
// 		id varchar(20),
//	    pw varchar(20) not null,
//	    name varchar(10) not null,
//	    birth varchar(20) not null,
//		gender varchar(5) not null,
//	    mail varchar(30),
//	    tel varchar(15) not null,
//	    primary key (id)
//	);

// mySQL에 접속하기 위한 정보들을 상수로 정해놓은 클래스
public class JDBCConstraints {
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/clientinfo?serverTimezone=UTC&useSSL=false";
	public static final String JDBC_USER = "root";
	public static final String JDBC_PASSWORD = "SystemManager304";
}
