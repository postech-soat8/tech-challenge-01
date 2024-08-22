# Usando uma imagem base do Maven para compilar o projeto
FROM maven:3.8.4-openjdk-17 AS build

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixa as dependências do Maven para o cache
RUN mvn dependency:go-offline -B

# Copia o restante dos arquivos do projeto para o container
COPY src ./src

# Executa o comando Maven para construir o projeto
RUN mvn clean package -DskipTests

# Usando uma imagem base do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado na fase anterior para o container
COPY --from=build /app/target/techchallenge-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080 para o container
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","/app/app.jar"]
