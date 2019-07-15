package com.tje.jdbc.starter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.tje.jdbc.pool.DataSourcePoolConfig;
import com.tje.jdbc.service.*;
import com.tje.jdbc.model.*;

public class JDBCMainStarter {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourcePoolConfig.class);
		
		// RegistService rService = ctx.getBean("rService", RegistService.class);
		// rService.service();
		
		ArticleDeleteService adService = ctx.getBean("adService", ArticleDeleteService.class);
		// article 테이블과 comment 테이블을 모두 지우는 transaction
		adService.service();
		
	}

}
