package com.tje.starter;

import java.util.*;
import com.tje.model.*;

// AbstractApplicationContext 클래스
// - 스프링 컨테이너들의 추상 부모클래스
// - XML 또는 자바 클래스를 사용하여 스프링 컨테이너를 정의하고
//   부모 클래스인 AbstractApplicationContext 클래스를 사용하여
//   다형성을 구현할 수 있다.
import org.springframework.context.support.AbstractApplicationContext;
// GenericXmlApplicationContext 클래스
// - XML 기반으로 스프링 컨테이너를 정의한 경우
//   XML 파일로부터 스프링 컨테이너를 생성할 수 있는 클래스
import org.springframework.context.support.GenericXmlApplicationContext;

public class StoreMain {
	public static void main(String[] args) {
		// 스프링 컨테이너가 정의된 XML 파일의 경로
		// - classpath 접두어는 resources 디렉토리를 의미
		String configLocation = "classpath:conf/store_map.xml";
		// XML 파일로부터 스프링 컨테이너를 생성하는 코드
		// - GenericXmlApplicationContext 클래스의 객체를 생성하여 처리
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		// 스프링 컨테이너로부터 스프링 빈 객체를 반환받는 코드
		// - XML로 정의된 경우 bean 태그의 id 속성의 값을 사용하여
		//   특정 스프링 빈 객체를 반환받을 수 있다.
		// - 컨테이너객체.getBean("id값", 클래스타입.class);
		Store store = ctx.getBean("store", Store.class);
		
		// 객체 정보 출력
		System.out.println(store);
	}
}
