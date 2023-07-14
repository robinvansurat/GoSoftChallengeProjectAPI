package com.robin.GoSoftChallengeProjectAPI;

import com.robin.GoSoftChallengeProjectAPI.request.RegisterRequest;
import com.robin.GoSoftChallengeProjectAPI.services.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import static com.robin.GoSoftChallengeProjectAPI.model.Role.ADMIN;
import static com.robin.GoSoftChallengeProjectAPI.model.Role.MANAGER;

@SpringBootApplication
public class GoSoftChallengeProjectApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(GoSoftChallengeProjectApiApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service
//	) {
//		return args -> {
//			var admin = RegisterRequest.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.email("admin@mail.com")
//					.password("password")
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token: " + service.register(admin).getAccessToken());
//
//			var manager = RegisterRequest.builder()
//					.firstname("Admin")
//					.lastname("Admin")
//					.email("manager@mail.com")
//					.password("password")
//					.role(MANAGER)
//					.build();
//			System.out.println("Manager token: " + service.register(manager).getAccessToken());
//
//		};
//	}
}
