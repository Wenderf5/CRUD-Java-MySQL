# CRUD Java + MySQL

Este sistema é um gerenciador de alunos e cursos de uma escola. Com ele, você pode:

- Cadastrar alunos "/new-student".
- Deletar alunos "/delete-student/id_do_estudante".
- Criar cursos "/new-course".
- Deletar cursos "/delete-course/id_do_curso".
- Pesquisar todos os cursos "/get-all-course".
- Pesquisar todos os alunos "/get-all-student".
- Pesquisar um aluno específico "/get-student/id_do_estudante".
- Matricular alunos em cursos "/enroll-student".
- Remover alunos de cursos "/cancel-registration/id_da_matricula".

## Tecnologias utilizadas

- Java
- Spring Web
- Maven
- MySQL

## Como Executar o Projeto

1. Clone o repositório e instale todas as dependências com Maven.

2. Baixe e importe o dump do banco de dados MySQL [aqui](https://drive.google.com/file/d/1lhSXqAohiWN4lOciYCyNUsqkn7D57yhj/view?usp=sharing) e configure seu ambiente de desenvolvimento para conectá-lo corretamente.
  
3. Abra o arquivo application.properties e configure as variáveis do seu banco de dados.
