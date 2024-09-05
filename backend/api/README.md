# Invest-Pulse API

## Descrição da API: User

A minha a api foi construida com o proposito de ser usada em um site de investimento chamado InvestPulse na area de cadastro e login

### Tecnologias utilizadas

Tecnologia utizatas | Verção
---|---
Java | 17
String Boot | 3.3.2
Maven | 3.6.3

## Setap do projeto

### 1. Clone do repositório

Clone o repositóro para a sua máquina usando o seguinte comando:

``` bash
 git clone https://github.com/Manomafo/Invest-Pulse.git
 cd ./invest-Pulse/backend/api
```

### 2. Instalação de dependência

Execute o segunte comando para instalar as dependências:

``` bash
 mvn clean package
```

### 3. Execute o projeto

Depois de configurado e instalar as depandências, você podera usar o seguinte comando:

``` bash
 mvn spring-boot:run
```

## Estrutura de user no banco de dados

`email` | `cpf` | `fullName` | `phoneNumber` | `password` | `createAt` | `updateAt`
--- | --- | --- | --- | --- | --- | ---
VARCHAR(255) | VARCHAR(255) | VARCHAR(255) | VARCHAR(255) | VARCHAR(255) | TIMESTAMP | TIMESTAMP

## endpoints

metodo | url | descrição | especificação
--- | --- | --- | ---
`POST` | `/api/user` | Registrar um novo user no banco de dados | [especificação](#post-apiuser)
`GET` | `/api/user/{email}` | Obtenha os dados de um user no banco de dados | [especificação](#get-api-user)
`GET` | `/api/user` | Obtenha todos os users registrados no banco de dados | [especificação](#get-apiuser)
`PATCH` | `/api/user/{email}` | Atualizar parcialmente um user no banco de dados | [especificação](#pacth-api-user)
`PUT` | `/api/user/{email}` | Atualizar os dados de um user no banco de dados | [especificação](#put-api-user)
`DELETE` | `/api/user/{email}` | Deleta um user no banco de dados | [especificação](#delete-api-user)

### Toda as especificaçães de endpoints

#### POST /api/user

Registrar um novo user no banco de dados

**Formato:**

* Método: `POST`
* **URL:** <http://localhost:8080/api/user>
* Parâmetros do caminho: nenhum
* Corpo: Nenhum
  
**Exemplo:**

**Pedido:**

* Método: `POST`
* **URL:** <http://localhost:8080/api/user>

**Requisição:**

``` json
{
  "email": "elaine-darocha81@gmail.com",
  "phoneNumber": "79984489684",
  "cpf": "45495085825",
  "fullName": "Elaine Aparecida da Rocha",
  "password": "Aq6eSL5QtI"
}
```

**Resposta:**

* Status do HTTP: `201 Created`

``` json
{
  "email": "elaine-darocha81@gmail.com",
  "cpf": "45495085825",
  "fullName": "Elaine Aparecida da Rocha",
  "phoneNumber": "79984489684",
  "createdAt": "2024-08-30T13:16:51.688121018Z",
  "updatedAt": "2024-08-30T13:16:51.688123129Z"
}
```
<!-- markdownlint-disable-next-line MD033 -->
<h4 id="get-api-user">GET /api/user/{email}</h4>

Obtenha os dados de um user no banco de dados

**Formato:**

* Método: `GET`
* **URL:** <http://localhost:8080/api/user/{email}>
* Parâmetros do caminho: email
* Corpo: Nenhum
  
**Exemplo:**

**Pedido:**

* Método: `GET`
* **URL:** <http://localhost:8080/api/user/{email}>

**Resposta:**

* Status: `200 OK`

``` json
{
  "email": "elaine-darocha81@gmail.com",
  "cpf": "45495085825",
  "fullName": "Elaine Aparecida da Rocha",
  "phoneNumber": "79984489684",
  "createdAt": "2024-08-30T13:16:51.688121Z",
  "updatedAt": "2024-08-30T1"
}
```

#### GET /api/user/

Obtenha todos os users registrados no banco de dados

**Formato:**

* Método: `GET`
* **URL:** <http://localhost:8080/api/user>
* Parâmetros do caminho: nenhum
* Corpo: Nenhum
  
**Exemplo:**

**Pedido:**

* Método: `GET`
* **URL:** <http://localhost:8080/api/user>

**Resposta:**

* Status: `200 OK`

``` json
[
    {
        "email": "elaine-darocha81@gmail.com",
        "cpf": "45495085825",
        "fullName": "Elaine Aparecida da Rocha",
        "phoneNumber": "79984489684",
        "createdAt": "2024-08-30T13:16:51.688121Z",
        "updatedAt": "2024-08-30T1"
    },
    {
        "email": "isabella_barros@gmail.com",
        "cpf": "02868669190",
        "fullName": "Isabella Isabel Clarice Barros",
        "phoneNumber": "27989586132",
        "createdAt": "2024-08-30T13:16:51.688121Z",
        "updatedAt": "2024-08-30T1"
    }
    
    //etc...
]
```
<!-- markdownlint-disable-next-line MD033 -->
<h4 id="pacth-api-user">PACTH /api/user/{email}</h4>

Atualizar parcialmente um user no banco de dados

**Formato:**

* Método: `PACTH`
* **URL:** <http://localhost:8080/api/user/{email}>
* Parâmetros do caminho: email
* Corpo: Nenhum
  
**Exemplo:**

**Pedido:**

* Método: `PATCH`
* **URL:** <http://localhost:8080/api/user/{email}>

**Requisição:**

``` json
{
  "fullName": "Maria da Silva",
  "password": "Aq6eSL5QtI"
}
```

**Resposta:**

* Status do HTTP: `200 OK`

``` json
{
  "email": "elaine-darocha81@gmail.com",
  "cpf": "45495085825",
  "fullName": "Maria da Silva",
  "phoneNumber": "79984489684",
  "createdAt": "2024-08-30T13:16:51.688121018Z",
  "updatedAt": "2024-08-30T13:16:51.688123129Z"
}
```
<!-- markdownlint-disable-next-line MD033 -->
<h4 id="put-api-user">PUT /api/user/{email}</h4>

Atualizar os dados de um user no banco de dados

**Formato:**

* Método: `PUT`
* **URL:** <http://localhost:8080/api/user/{email}>
* Parâmetros do caminho: email
* Corpo: Nenhum
  
**Exemplo:**

**Pedido:**

* Método: `PUT`
* **URL:** <http://localhost:8080/api/user/{email}>

**Requisição:**

``` json
{
  "fullName": "Maria da Silva",
  "password": "PuU0pP8ySD"
}
```

**Resposta:**

* Status do HTTP: `200 OK`

``` json
{
  "email": "elaine-darocha81@gmail.com",
  "cpf": "454.950.858-25",
  "fullName": "Maria da Silva",
  "phoneNumber": "79984489684",
  "createdAt": "2024-08-30T13:16:51.688121018Z",
  "updatedAt": "2024-08-30T13:16:51.688123129Z"
}
```
<!-- markdownlint-disable-next-line MD033 -->
<h4 id="delete-api-user">DELETE /api/user/{email}</h4>

Deleta um user no banco de dados

**Formato:**

* Método: `DELETE`
* **URL:** <http://localhost:8080/api/user/{email}>
* Parâmetros do caminho: email
* Corpo: Nenhum
  
**Exemplo:**

**Pedido:**

* Método: `DELETE`
* **URL:** <http://localhost:8080/api/user/{email}>

**Resposta:**

* Status do HTTP: `204 NO CONTENT`

[ERROS.md](https://github.com/Manomafo/Invest-Pulse/blob/api/backend/api/erros.md)