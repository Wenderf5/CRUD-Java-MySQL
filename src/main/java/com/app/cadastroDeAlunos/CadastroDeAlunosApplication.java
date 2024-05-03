package com.app.cadastroDeAlunos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;


@SpringBootApplication
public class CadastroDeAlunosApplication {

	//Metodo principal (main)
	public static void main(String[] args) {
		System.out.println("Hello world!");
		SpringApplication.run(CadastroDeAlunosApplication.class, args);
		new conexaoDB().connect();
	}

	//Controlador das rotas
	@RestController
	public class Controller {
		private static Connection conexao;

		//Metodo/Rota
		@PostMapping("/cadastroaluno")
		//Rota para cadastrar alunos no banco de dados
		public String addAluno(@RequestBody aluno aluno) {
			try {
				PreparedStatement stmt = conexao.prepareStatement("INSERT INTO alunos (cpf, nome) VALUES (?, ?)");
				((PreparedStatement) stmt).setString(1, aluno.getCpf());
				stmt.setString(2, aluno.getNome());
				stmt.executeUpdate();
				return "Aluno cadastrado com sucesso!";
			} catch (SQLException ex) {
				ex.printStackTrace();
				return "Erro ao cadastrar aluno: " + ex.getMessage();
			}
		}

		//Rota para consulta dos alunos no banco de dados
		@PostMapping("/aluno")
		public String pesquisarAluno(@RequestBody pesquisaaluno aluno){
			try{
				//Query de consulta no banco de dados
				PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM alunoscursos WHERE nomeAluno = ? ");
				((PreparedStatement) stmt).setString(1, aluno.getNome());
				ResultSet rs = stmt.executeQuery();

				ObjectMapper objectMapper = new ObjectMapper();
				ArrayNode resultadoJSON = objectMapper.createArrayNode();

				while(rs.next()){
					ObjectNode alunoJSON = objectMapper.createObjectNode();
					alunoJSON.put("cpfAluno", rs.getString("cpfAluno"));
					alunoJSON.put("nomeAluno", rs.getString("nomeAluno"));
					alunoJSON.put("cursoAluno", rs.getString("cursoAluno"));

					resultadoJSON.add(alunoJSON);
				}
				return objectMapper.writeValueAsString(resultadoJSON);
			}catch (SQLException ex){
				ex.printStackTrace();
				return "Erro ao pesquisar aluno: " + ex.getMessage();
			} catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

		@PostMapping("/addcurso")
		public String addcurso(@RequestBody curso curso){
			try{
				PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cursos (nome) VALUES (?)");
				((PreparedStatement) stmt).setString(1, curso.getNome());
				stmt.executeUpdate();
				return "Curso adicionado!";
			}catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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

	//Classe para contruir um objeto aluno para se cadastrado no banco de dados
	public static class aluno{
		String cpf;
		String nome;

		//Contructor da classe aluno
		public aluno(String nome, String cpf){
			this.cpf = cpf;
			this.nome = nome;
		}

		public String getCpf(){
			return cpf;
		}
		public String getNome(){
			return nome;
		}
	}

	//Classe que me connecta com meu banco de dados
	public static class conexaoDB {

		//Metodo que faz a conexão com o banco dedados
		public void connect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Controller.conexao = DriverManager.getConnection("jdbc:mysql://localhost/nomedobanco", "user", "senha");
			} catch (ClassNotFoundException ex) {
				System.out.println("Driver do banco de dados não encontrado.");
			} catch (SQLException ex) {
				System.out.println("Erro ao conectar com o banco de dados.");
			}
		}
	}
}
