package com.devlink;

import com.devlink.domain.Company;
import com.devlink.domain.User;
import com.devlink.repository.CompanyRepository;
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


}
