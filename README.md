# Study • TDD - API
Desenvolvimento de endpoints REST utilizando a metodologia TDD (Test-Driven Development).

## 🚀 Tecnologias Utilizadas
- Java 21
- Spring Boot
- Maven
- JPA / Hibernate
- H2 Database


## 🎯 Objetivo do Projeto
Projeto desenvolvido com foco na aplicação da metodologia TDD (Test-Driven Development), implementando endpoints REST para gerenciamento de cidades e eventos, incluindo tratamento global de exceções e testes automatizados de integração.

## 🧪 Metodologia TDD

O desenvolvimento seguiu o ciclo clássico do TDD:

1. Criação do teste
2. Implementação mínima para passar no teste
3. Refatoração

Os testes de integração garantem o comportamento correto dos endpoints e o tratamento adequado de exceções.

## 📁 Estrutura do Projeto

```
src/
└── main/
|  └── java/
|  | └── com.devsuperior.bds02/
|  |   └── controller/
|  |      └── CityController
|  |      └── EventController
|  |   └── dto/
|  |      └── error/
|  |         └── CustomErrorDto
|  |      └── CityDto
|  |      └── EventDto      
|  |   └── entities
|  |   └── handlers
|  |      └── ControllerExceptionHandler
|  |   └── repository
|  |      └── CityRepository
|  |      └── EventRepository
|  |   └── service/
|  |      └── CityService
|  |      └── EventService
|  |   └── Bds02Application.java
|  |
|  └── resources/
|
└── test/
   └── java/
      └── Controller
         └── CityControllerIT
         └── EventControllerIT
         
```

## ⚙️ Como Executar

1. Clonar o repositório 
```
git clone https://github.com/romulomotadev/study-spring-06-tdd-event-city-api
```
2. Abra o projeto em sua IDE favorita (IntelliJ recomendado)
3. Execute a aplicação pela classe:
```
Bds02Application.java
```
4. Faça as requisições usando:
   
   - Postman
   - Insomnia
   - ThunderClient (VS Code)

5. Execute testes pelas classes:
```
CityControllerIT
EventControllerIT
```

O banco H2 é carregado automaticamente e um script import.sql popula os dados iniciais.

## 📌 Endpoints Principais

### City
```
GET  /cities
POST /cities
DELETE /cities/{id}
```
### Event
```
GET  /events/{id}
```

## 📄 Licença
Este projeto é apenas para fins de estudo e não possui fins comerciais.








