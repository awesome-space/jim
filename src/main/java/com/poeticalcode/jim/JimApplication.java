package com.poeticalcode.jim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 启动类
 * 
 * @author poeticalcode
 */
@SpringBootApplication
@MapperScan("com.poeticalcode.jim.mapper")
public class JimApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(JimApplication.class, args);
	}

}
