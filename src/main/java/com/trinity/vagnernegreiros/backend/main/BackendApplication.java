package com.trinity.vagnernegreiros.backend.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories("com.trinity.vagnernegreiros.cursos.repository")
@EnableTransactionManagement
@EntityScan(basePackages = {"com.trinity.vagnernegreiros.cursos.model"}) 
@ComponentScan("com.trinity.vagnernegreiros.cursos.rest")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
