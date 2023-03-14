package com.hewenyao.jim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hewenyao.jim.utils.JwtUtil;

@SpringBootApplication
public class JimApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(JimApplication.class, args);
		System.out.println(JwtUtil.sign("123456456"));


		


	}

}
