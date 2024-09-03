# Erros

Metodos de requisição | Link de erros
--- | ---
`POST` | [especificação](#erros-que-podem-acontecer-no-metodo-post)
`GET` | [especificação](#erros-que-podem-acontecer-no-metodo-get)
`PATCH`, `PUT` | [especificação](#erros-que-podem-acontecer-no-metodo-patch-e-no-put)
`DELETE` | [especificação](#erros-que-podem-acontecer-no-metodo-delete)

## Erros que podem acontecer no metodo `POST`

### Erros de email no metodo `POST`

**Requisição:**

``` json
{
    "email":"fulanohotmail.com"
}
```

O email do fulano está dando erro porque tem que implementar o "@"

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "email": "O e-mail deve ser valido"
  }
}
```

### Erros do número de telefone no metodo `POST`

**Requisição:**

``` json
{
    "phoneNumber": "799844896"
}
```

* O número de telefone deve ter de 10 ou 11 caracteres

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "phoneNumber": "O numero de telefone deve ter de 10 ou 11 caracteres"
  }
}
```
<!-- TODO
**Requisição:**

``` json
{
    "phoneNumber": "7998448w6"
}
```

* O número de telefone não pode ter letras

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "phoneNumber": "O numero de telefone não pode ter lertas"
  }
}
``` -->

### Erros do cpf no metodo `POST`

**Requisição:**

``` json
{
    "cpf": "4549508582"
}
```

* O CPF deve ter exatamente 11 caracteres

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "cpf": "O CPF deve ter exatamente 11 caracteres"
  }
}
```
<!-- TODO
**Requisição:**

``` json
{
    "cpf": "454950858w5"
}
```

* O CPF não pode ter letras

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "cpf": "O CPF não pode ter letras"
  }
}
``` -->

### Erros do fullName no metodo `POST`

**Requisição:**

``` json
{
    "fullName": "Elai"
}
```

* O nome completo deve ter entre 5 a 50 caracteres

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "fullName": "O nome completo deve ter entre 5 a 50 caracteres"
  }
}
```

**Requisição:**

``` json
{
    "fullName": "Elaine % Aparecida # da 32 Rocha"
}
```

* O fullName não pode ter números ou caracteres especiais

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "fullName": "O fullName não pode ter numeros ou caracteres especiais"
  }
}
```

### Erros do password no metodo `POST`

**Requisição:**

``` json
{
    "password": "Aq6e5"
}
```

* A senha deve ter entre 6 a 50 caracteres

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "password": "A senha deve ter entre 6 a 50 caracteres"
  }
}
```

## Erros que podem acontecer no metodo `GET`

### Erros de requisição

* Erro na url da requisição
* User não foi criado

``` json
{
  "statusCode": 404,
  "message": "Usuário não encontrado",
  "description": "Não foi possivel encontrar ou recuperar o usuário"
}
```

## Erros que podem acontecer no metodo `PATCH` e no `PUT`

* Erro na url da requisição
* User não foi criado

``` json
{
  "statusCode": 404,
  "message": "Usuário não encontrado",
  "description": "Não foi possivel encontrar ou recuperar o usuário"
}
```

### Erros do fullName no metodo `PATCH` e no `PUT`

**Requisição:**

``` json
{
    "fullName": "Elai"
}
```

* O nome completo deve ter entre 5 a 50 caracteres

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "fullName": "O nome completo deve ter entre 5 a 50 caracteres"
  }
}
```

**Requisição:**

``` json
{
    "fullName": "Elaine % Aparecida # da 32 Rocha"
}
```

* O fullName não pode ter números ou caracteres especiais

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "fullName": "O fullName não pode ter numeros e caracteres especiais"
  }
}
```

### Erros do password no metodo `PATCH` e no `PUT`

**Requisição:**

``` json
{
    "password": "Aq6e5"
}
```

* A senha deve ter entre 6 a 50 caracteres

**Resposta:**

``` json
{
  "statusCode": 400,
  "message": "Erro de validação",
  "errors": {
    "password": "A senha deve ter entre 6 a 50 caracteres"
  }
}
```

## Erros que podem acontecer no metodo `DELETE`

* Erro na url da requisição
* User não foi criado

``` json
{
  "statusCode": 404,
  "message": "Usuário não encontrado",
  "description": "Não foi possivel encontrar ou recuperar o usuário"
}
```
