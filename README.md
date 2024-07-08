# PetShop Project

Este projeto é uma aplicação web para gerenciar clientes, pets, serviços e produtos de um pet shop. Foi desenvolvido utilizando Java com Spring Boot, integrando JPA para persistência de dados e Thymeleaf para as views HTML.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

'''
src
├── main
│   ├── java
│   │   └── com
│   │       └── seuapp
│   │           └── petshop
│   │               ├── PetshopApplication.java
│   │               ├── controller
│   │               │   ├── ClienteController.java
│   │               │   ├── PetController.java
│   │               │   ├── ServicoController.java
│   │               │   └── ProdutoController.java
│   │               ├── model
│   │               │   ├── Cliente.java
│   │               │   ├── Pet.java
│   │               │   ├── Servico.java
│   │               │   └── Produto.java
│   │               ├── repository
│   │               │   ├── ClienteRepository.java
│   │               │   ├── PetRepository.java
│   │               │   ├── ServicoRepository.java
│   │               │   └── ProdutoRepository.java
│   │               └── service
│   │                   ├── ClienteService.java
│   │                   ├── PetService.java
│   │                   ├── ServicoService.java
│   │                   └── ProdutoService.java
│   └── resources
│       ├── application.properties
│       └── static
│           ├── css
│           │   └── style.css
│           ├── js
│           │   └── script.js
│           └── templates
│               ├── cliente.html
│               ├── pet.html
│               ├── servico.html
│               └── produto.html
└── test
└── java
└── com
└── seuapp
└── petshop
├── controller
│   └── ClienteControllerTest.java
├── repository
│   └── ClienteRepositoryTest.java
└── service
└── ClienteServiceTest.java
'''

## Tecnologias Utilizadas

- Java 21
- Spring Boot 2.5.1
- Thymeleaf
- MySQL (ou PostgreSQL, conforme configurado)

## Configuração e Execução

Para executar o projeto localmente, siga estas etapas:

1. Clone este repositório.
2. Configure o arquivo `application.properties` com as suas credenciais de banco de dados.
3. Execute o arquivo `PetshopApplication.java` para iniciar a aplicação.
4. Acesse a aplicação em `http://localhost:8080`.

## Testes

Os testes unitários são fornecidos para os serviços e controladores. Para executá-los, utilize sua IDE preferida ou execute `mvn test` na linha de comando.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request ou reportar problemas através das issues.

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).


