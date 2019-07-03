package com.tje.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tje.services.*;

// services.xml 파일의 스프링 컨테이너 설정을
// 아래의 ServiceConfig를 사용하여 정의한 후,
// MainWithAnnotation 클래스를 사용하여 실행해보자.

@Configuration
public class RegistServiceConfig {

	
	// 이거를 작성 안해도 상관없지만 가독성을 위해 ..
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	
	
	@Bean(name = "rs")
	public RegistService getRegistService() {
		return new RegistService(memberDAO);
	}
}
