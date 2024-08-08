package com.app.escola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.escola.config.DataBaseConfig;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		System.out.println("Servidor iniciado na porta '8080'!");
		new DataBaseConfig().connect();
	}
}
