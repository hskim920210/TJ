package com.tje.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tje.services.*;

// services.xml 파일의 스프링 컨테이너 설정을
// 아래의 ServiceConfig를 사용하여 정의한 후,
// MainWithAnnotation 클래스를 사용하여 실행해보자.

@Configuration
public class ConnectionProviderConfig {
	
	@Bean(name = "provider")
	public ConnectionProvider getConnectionProvider() {
		ConnectionProvider obj = new ConnectionProvider("com.mysql.cj.jdbc.Driver");
		obj.setUrl("jdbc:mysql://localhost:3306/di?serverTimezone=UTC");
		obj.setUser("root");
		obj.setPassword("SystemManager304");
		return obj;
	}
}
