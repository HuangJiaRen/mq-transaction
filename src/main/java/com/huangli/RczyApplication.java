package com.huangli;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.huangli.dao.mapper")
@EnableSwagger2Doc
@SpringBootApplication
public class RczyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RczyApplication.class, args);
	}
}
