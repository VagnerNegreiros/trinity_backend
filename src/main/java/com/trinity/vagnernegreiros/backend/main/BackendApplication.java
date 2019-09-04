package com.trinity.vagnernegreiros.backend.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.trinity.vagnernegreiros.backend.model.Usuario;
import com.trinity.vagnernegreiros.backend.repository.UsuarioRepository;
import com.trinity.vagnernegreiros.backend.util.Util;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties
@EnableJpaRepositories("com.trinity.vagnernegreiros.backend.repository")
@EnableTransactionManagement
@EntityScan(basePackages = {"com.trinity.vagnernegreiros.backend.model"}) 
@ComponentScan("com.trinity.vagnernegreiros.backend.rest")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
    CommandLineRunner initDatabase(UsuarioRepository repository) {
        return args -> {
            repository.save(new Usuario("vagnerlimanegreiros@gmail.com" , Util.generateMD5("123456")));
        };
    }

}
