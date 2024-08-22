# Usando uma imagem base do OpenJDK
FROM openjdk:22-jre-slim

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo JAR gerado pela sua aplicação para o contêiner
COPY target/cadastroDeAlunos.jar /app/app.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/app.jar"]