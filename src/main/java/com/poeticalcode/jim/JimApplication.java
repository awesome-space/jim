package com.poeticalcode.jim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poeticalcode.jim.utils.JwtUtil;

@SpringBootApplication
@MapperScan("com.poeticalcode.jim.mapper")
public class JimApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(JimApplication.class, args);
		System.out.println(JwtUtil.sign("123456456"));
		




	}

}
