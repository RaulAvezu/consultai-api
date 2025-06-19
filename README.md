
# 🩺 ConsultAI API

Sistema de agendamento de consultas para médicos, psicólogos e outros profissionais da saúde.  
API desenvolvida em Java com Spring Boot, PostgreSQL, Docker e Flyway.

## 📚 Tecnologias utilizadas

- Java 21
- Spring Boot 3
- PostgreSQL
- Docker
- Flyway
- JUnit 5 + Mockito
- Lombok

## 🚀 Como rodar o projeto

### 📦 Pré-requisitos:
- Java 17
- Maven
- Docker

### 📦 Rodar banco via Docker

```
docker run --name consultai-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=consultai_db -p 5432:5432 -d postgres
```

### 📦 Rodar aplicação

```
./mvnw spring-boot:run
```

Acesse: `http://localhost:8080`

## 📃 Licença

MIT License
