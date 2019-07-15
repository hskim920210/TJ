package com.tje.jdbc.pool;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.tje.jdbc.dao.*;
import com.tje.jdbc.service.*;

@Configuration
public class DataSourcePoolConfig {
	@Value("${JDBC_DRIVER}")
	private String driver;
	@Value("${JDBC_URL}")
	private String url;
	@Value("${JDBC_USER}")
	private String user;
	@Value("${JDBC_PASSWORD}")
	private String password;
	@Value("${INIT_SIZE}")
	private int init_size;
	@Value("${MAX_ACTIVE}")
	private int max_active;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		config.setLocation(new ClassPathResource("jdbc.properties"));
		return config;
	}
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(init_size);
		ds.setMaxActive(max_active);
		return ds;
	}
	
	@Bean("memberDAO")
	public MemberDAO getMemberDAO() {
		return new MemberDAO(dataSource());
	}
	
	@Bean("commentDAO")
	public CommentDAO getCommentDAO() {
		return new CommentDAO(dataSource());
	}
	
	@Bean("simpleArticleDAO")
	public SimpleArticleDAO getSimpleArticleDAO() {
		return new SimpleArticleDAO(dataSource());
	}
	
	@Bean("detailArticleDAO")
	public DetailArticleDAO getDetailArticleDAO() {
		return new DetailArticleDAO(dataSource());
	}
	
	@Bean
	public RegistService rService() {
		return new RegistService(getMemberDAO());
	}
	
	@Bean
	public ArticleDeleteService adService() {
		return new ArticleDeleteService(getDetailArticleDAO(), getCommentDAO());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
}
