To-Do List — Back-end (Spring Boot)

API REST para gerenciamento de tarefas, desenvolvida com Spring Boot. Este projeto é o back-end de uma aplicação To-Do List full-stack — o front-end (React) está em um repositório separado.

Funcionalidades
Criar, listar, atualizar e excluir tarefas (CRUD completo)
Marcar tarefas como concluídas
Definir prioridade da tarefa (Baixa, Média, Alta)
CORS configurado para consumo por front-end externo
Tecnologias
Java 21+
Spring Boot 4 (Web, Data JPA)
H2 Database (banco de dados em memória)
Maven (via Maven Wrapper, sem necessidade de instalação)
Arquitetura

O projeto segue uma arquitetura em camadas:

Controller  →  Service  →  Repository  →  Banco de Dados
src/main/java/com/example/todolist/
├── config/         # Configurações (CORS)
├── controller/      # Endpoints REST
├── model/            # Entidades (Task, Priority)
├── repository/        # Acesso a dados (Spring Data JPA)
└── service/             # Regras de negócio
Endpoints
Método	Rota	Descrição
GET	/api/tasks	Lista todas as tarefas
POST	/api/tasks	Cria uma nova tarefa
PUT	/api/tasks/{id}	Atualiza uma tarefa existente
DELETE	/api/tasks/{id}	Remove uma tarefa

Exemplo de corpo de requisição (POST/PUT):

json
{
  "title": "Estudar Spring Boot",
  "description": "Terminar o módulo de testes",
  "completed": false,
  "priority": "HIGH"
}

priority aceita: "LOW", "MEDIUM", "HIGH".

Como rodar o projeto

Pré-requisitos: Java 17 ou superior instalado.

Clone o repositório:
   git clone https://github.com/lagasselorena/todolists_springboot.git
   cd todolists_springboot/todolist
Rode o projeto (o Maven Wrapper cuida de baixar as dependências):
Windows:
     ./mvnw spring-boot:run
Linux/Mac:
     ./mvnw spring-boot:run
Ou, se estiver usando uma IDE (IntelliJ, Eclipse), abra o projeto e rode a classe TodolistApplication.
O servidor sobe em http://localhost:8080.
Teste rapidamente acessando http://localhost:8080/api/tasks no navegador — deve retornar [].

Nota: o banco H2 roda em memória — os dados são reiniciados toda vez que o servidor é reiniciado. Para inspecionar o banco visualmente, acesse http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:tododb).

Próximos passos (ideias de evolução)
Persistência em banco relacional real (PostgreSQL/MySQL)
Autenticação de usuários
Testes automatizados (JUnit)
Paginação de resultados

Projeto desenvolvido como estudo de Spring Boot + arquitetura REST.
