package com.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan(basePackages = "com.spring.mvc")
@SpringBootApplication
public class MvcApplication {


	@Bean
	public InternalResourceViewResolver resolver(){
		InternalResourceViewResolver resolver =
				new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	public static void main(String[] args) {

		SpringApplication.run(MvcApplication.class, args);

//		new Dog(); //이렇게 원래 내가 생성했었는데 스프링이 생성해서 던저준다.
		//의존성 주입
		//직접 객체를 생성하면 이점도
	}

}