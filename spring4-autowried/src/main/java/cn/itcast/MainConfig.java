package cn.itcast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import cn.itcast.service.UserService;

@Configuration
@ComponentScan(basePackages={"cn.itcast.controller","cn.itcast.service","cn.itcast.dao"}) 
public class MainConfig {
	
	@Bean
	@Primary
	public UserService service(){
		UserService service = new UserService();
		service.setLable("service02");
		return service;
	}
}
