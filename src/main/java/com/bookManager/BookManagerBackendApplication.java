package com.bookManager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bookManager.dao.mapper")
public class BookManagerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagerBackendApplication.class, args);
	}

}
