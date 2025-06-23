package com.devlink;

import com.devlink.domain.User;
import com.devlink.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevlinkApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			if (!userRepository.existsByEmail("test@example.com")) {
				userRepository.save(User.builder()
						.username("테스트유저")
						.email("test@example.com")
						.password("1234") // 나중에 암호화 예정
						.role(User.Role.ROLE_USER)
						.build());
			}
		};
	}

}
