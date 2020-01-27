package com.encurtador.msencurtadorurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsEncutadorUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEncutadorUrlApplication.class, args);
	}

}
