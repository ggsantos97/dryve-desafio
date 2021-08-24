
## Este Projeto conta com o docker compose para subir suas dependencias (Postgres e RabbitMq), portanto é importando que você esteja com docker instalado e configurado em sua máquina!!

## 1º Dentro da pasta do projeto, execute o comando docker-compose up para  subir o Banco e o rabbitmq.
## 2º execute o comando mvn  clean install 
## 3º execute o comando java -jar target/dryve-carros-0.0.1-SNAPSHOT.jar

# http://localhost:8080/api/swagger-ui/ Para acessar  os endpoints pelo swagger 
## Tecnologias Utilizadas (Java8, Spring boot, Docker, RabbitMq, MapperStruct, Gson, ApiDocs, Jpa, Lombok, Jacoco,  Junit,  Mockito )

## Melhorias a fazer: Adicionar camada  de segurança com SpringSecurity, melhorar encaminhamento de mensagens para filas.