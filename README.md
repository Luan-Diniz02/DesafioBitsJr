# Duelistas API

API RESTful para gerenciamento de duelistas desenvolvida com Spring Boot.

## 🚀 Tecnologias Utilizadas
- Java 20
- Spring Boot 3.3.4
- Maven
- Spring Validation

## 📋 Pré-requisitos
- JDK 20+
- Maven 3.6+
- Cliente HTTP (Postman/cURL)

## 🔧 Instalação e Execução

1. Clone o repositório  
```bash
git clone https://github.com/Luan-Diniz02/DesafioBitsJr.git
cd DesafioBitsJr
```
2. Configure o Projeto  
O projeto usa Maven para gerenciar dependências. Certifique-se de que o arquivo pom.xml contém as dependências necessárias. Se o projeto foi importado corretamente pode pular esse passo.
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.1.14</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.3.4</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
        <version>3.3.4</version>
    </dependency>

</dependencies>
```
3. Compile o Projeto  
Compile o projeto utilizando uma IDE de sua preferência (IntelliJ, Eclipse, etc.) ou pela linha de comando.  
Caso obte pela linha de comando, execute o seguinte comando no diretório raiz do projeto:
```bash
mvn clean install
```
4. Execute a API  
Para iniciar a API, rode a classe Main.java ou use o comando Maven:
```bash
mvn spring-boot:run
```
A API será iniciada na porta padrão 8080.
Você verá uma saída no console indicando que o servidor Tomcat foi iniciado: 
```text
Tomcat started on port 8080 (http) with context path '/'
```
A API estará disponível em http://localhost:8080.    

5. Teste os Endpoints  
Use um cliente HTTP como Postman ou cURL para testar os endpoints. Veja os exemplos abaixo.

## 📌 Endpoints da API
A API gerencia duelistas com os seguintes campos:

- id (String, gerado automaticamente)
- nome (String, obrigatório)
- vitorias (Integer, obrigatório)
- derrotas (Integer, obrigatório)
- empates (Integer, obrigatório)
- pontos (Integer, calculado como vitorias * 3 + empates)

1. Listar todos os duelistas
- Método: GET
- URL: http://localhost:8080/duelistas

Exemplo de requisição:
```bash
curl -X GET http://localhost:8080/duelistas
```
Exemplo de Resposta (Status: 200 OK)
```json
[
    {
        "id": "1",
        "nome": "Yugi",
        "vitorias": 5,
        "derrotas": 2,
        "empates": 1,
        "pontos": 16
    },
    {
        "id": "2",
        "nome": "Kaiba",
        "vitorias": 4,
        "derrotas": 3,
        "empates": 0,
        "pontos": 12
    }
]
```
2. Buscar um duelista por ID
- Método: GET
- URL: http://localhost:8080/duelistas/{id}

Exemplo de Requisição:
```bash
curl -X GET http://localhost:8080/duelistas/1
```
Exemplo de Resposta (Status: 200 OK):
```json
{
    "id": "1",
    "nome": "Yugi",
    "vitorias": 5,
    "derrotas": 2,
    "empates": 1,
    "pontos": 16
}
```
Erro (Status: 404 Not Found):
```json
"Duelista com ID 999 não encontrado"
```
3. Adicionar um novo duelista
- Método: POST
- URL: http://localhost:8080/duelistas
- Cabeçalho: Content-Type: application/json  

Corpo da Requisição:
```json
{
    "nome": "Yugi",
    "vitorias": 5,
    "derrotas": 2,
    "empates": 1
}
```
Exemplo de Requisição:
```bash
curl -X POST http://localhost:8080/duelistas \
     -H "Content-Type: application/json" \
     -d '{"nome": "Yugi", "vitorias": 5, "derrotas": 2, "empates": 1}'
 ```
Exemplo de Resposta (Status: 201 Created):
```json
{
    "id": "1",
    "nome": "Yugi",
    "vitorias": 5,
    "derrotas": 2,
    "empates": 1,
    "pontos": 16
}
```
Erro (Status: 400 Bad Request):
```json
"Nome é obrigatório"
```
4. Atualizar um duelista
- Método: PUT
- URL: http://localhost:8080/duelistas/{id}
- Cabeçalho: Content-Type: application/json  

Corpo da Requisição:
```json
{
    "nome": "Yugi Muto",
    "vitorias": 6,
    "derrotas": 1,
    "empates": 2
}
```
Exemplo de Requisição:
```bash
curl -X PUT http://localhost:8080/duelistas/1 \
     -H "Content-Type: application/json" \
     -d '{"nome": "Yugi Muto", "vitorias": 6, "derrotas": 1, "empates": 2}'
```
Exemplo de Resposta (Status: 204 No Content):  
(Sem corpo de resposta)  

Erro (Status: 404 Not Found)
```json
"Duelista com ID 999 não encontrado"
```
5. Remover um duelista
- Método: DELETE
- URL: http://localhost:8080/duelistas/{id}  

Exemplo de Requisição:
```bash
curl -X DELETE http://localhost:8080/duelistas/1
```
Exemplo de Resposta (Status: 204 No Content):  
(Sem corpo de resposta)  

Erro (Status: 404 Not Found)
```json
"Duelista com ID 999 não encontrado"
```

## 🛠️ Testando com Postman
1. Abra o Postman
2. Crie uma nova requisição para cada endpoint (GET, POST, PUT, DELETE).
3. Configure a URL, método, cabeçalhos e corpo conforme os exemplos acima.
4. Envie a requisição e verifique a resposta.
