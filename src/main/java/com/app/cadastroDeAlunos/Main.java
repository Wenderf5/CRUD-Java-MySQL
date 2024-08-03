package com.app.cadastroDeAlunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.cadastroDeAlunos.config.DataBaseConfig;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		SpringApplication.run(Main.class, args);
		new DataBaseConfig().connect();
	}

	//Classe para curso
	public static class curso{
		String nome;

		public void curso(String nome){
			this.nome = nome;
		}

		public String getNome(){
			return nome;
		}
	}

	//Classe para pesquisar por um aluno
	public static class pesquisaaluno {
		String nome;

		// Construtor padrão sem argumentos
		public pesquisaaluno() {
		}

		public pesquisaaluno(String nome) {
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}
	}
}
