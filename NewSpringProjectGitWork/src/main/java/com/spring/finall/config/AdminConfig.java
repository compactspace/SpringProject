package com.spring.finall.config;



import org.apache.commons.chain.web.WebContext;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.transaction.ChainedTransactionManager;

import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.finall.admindto.PageableRequest;
import com.spring.finall.adminresolver.PageableHandlerMethodArgumentResolve;

//@Configuration은 설정파일임을 알려주며, 
//@EnableWebMvc의 경우 xml파일에 <mvc:annotation-driven/> 를  입력한것과 동일한 효과를 줍니다.
//즉 어노테이션 기반의 SpringMVC 웹 제작에 도움이 되는 Bean들을 자동으로 등록해주는 설정입니다.
//@ComponentScan(basePackageClasses = WebConfig.class)
//는 basePackageClasses에 적힌 class의 위치를 
//기반으로 모든 @Component(@Service, @Controller, @Repository)어노테이션을 달고 있는
//class를 bean으로 등록하도록 합니다.

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackageClasses = WebContext.class)
//아래 어노 테이션이 없다면?? 컨트롤러에서 @Autowired가 안먹힘 펙트 체크함
//JpaReposotyiry  bean생성에도 영향 주니.. 경로 조심..
@EnableJpaRepositories("com.spring.finall")
public class AdminConfig implements WebMvcConfigurer {

	// DB 정보
	//BasicDataSource datasource = new BasicDataSource() dbcp2 dbcp comon.dbcp 에 따라 타게팅삼는다.
	//실제로 임폴트시 3개나 뜬다.
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("org.mariadb.jdbc.Driver");
		datasource.setUrl("jdbc:mariadb://localhost:3306/finall");
		datasource.setUsername("root");
		datasource.setPassword("1111");
		return datasource;
	}

	// jpa 설정
	//META-INF에서 만들었던 persistence.xml 을 가지고 메니져를 만든다.
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPersistenceUnitName("jpa-maria"); // persistence.xml의 설정 정의된 이름
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		return entityManagerFactory;
	}

	// transactional 설정
	// 만들어진 메니져에게 트랜잭션을 세팅해준다는 정도로 이해
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		//단 주의 하자. 지금 presentation.xml 에서 사용하고 있는 트랜잭션 메니져랑 동일해서 충돌이 있을 수도 있다.
		// mariadb transactional
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());

		// JPA transactional
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		// Chained transaction manager (MyBatis X JPA)
		ChainedTransactionManager transactionManager = new ChainedTransactionManager(jpaTransactionManager,
				dataSourceTransactionManager);
		return transactionManager;
	}	

	
}
