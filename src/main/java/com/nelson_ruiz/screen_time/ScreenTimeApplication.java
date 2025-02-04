package com.nelson_ruiz.screen_time;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScreenTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenTimeApplication.class, args);
	}

}
