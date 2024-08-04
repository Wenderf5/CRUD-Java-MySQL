package com.app.escola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.escola.config.DataBaseConfig;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		SpringApplication.run(Main.class, args);
		new DataBaseConfig().connect();
	}
}
