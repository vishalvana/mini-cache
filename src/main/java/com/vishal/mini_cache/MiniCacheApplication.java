package com.vishal.mini_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MiniCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				MiniCacheApplication.class,
				args
		);
	}
}