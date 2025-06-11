# 💸 Finanças Express - Controle de Gastos com Spring Boot

Este projeto é uma API REST simples, construída com **Spring Boot**, com foco em ensinar conceitos como:

- Estrutura de projeto com camadas (Controller, UseCase, Repository)
- Paginação
- Cache com `@Cacheable`
- Medição de performance com `StopWatch`
- Uso de banco em memória (H2)
- Boas práticas com tratamento de erros e filtros

---

## 🚀 Funcionalidades

- ✅ Cadastro de despesa (`POST /gestao/create`)
- ✅ Busca de despesas por email, com filtro opcional por data (`GET /gestao/{email}?data=YYYY-MM-DD`)
- ✅ Listagem de todas as despesas sem paginação (`GET /gestao/performance/sem-paginacao`)
- ✅ Listagem com paginação (`GET /gestao/performance/com-paginacao`)
- ✅ Listagem por email com paginação e medição de tempo (`GET /gestao/performance/por-emails/{email}`)
- ✅ Listagem por email com paginação **e cache** (`GET /gestao/performance/por-email/{email}`)

---

## 🧪 Teste de performance

A aplicação utiliza um `CommandLineRunner` para gerar automaticamente **5000 registros de teste** no banco H2, permitindo testar cenários reais de:

- Listagem com e sem paginação
- Requisições com e sem cache
- Medição de tempo com `StopWatch` e `System.currentTimeMillis()`

---

## 📋 Exemplos de Requisições

### 📌 Criar despesa

```http
POST /gestao/create
Content-Type: application/json
```

```json
{
  "descricao": "Almoço",
  "valor": 35.90,
  "data": "2025-06-08",
  "categoria": "ALIMENTACAO",
  "email": "danielelae@gmail.com"
}
```

---

### 📌 Buscar despesas por email com data opcional

```http
GET /gestao/danielelae@gmail.com?data=2025-06-08
```

---

### 📌 Listar todas as despesas (sem paginação)

```http
GET /gestao/performance/sem-paginacao
```

---

### 📌 Listar com paginação

```http
GET /gestao/performance/com-paginacao?page=0&size=10
```

---

### 📌 Listar por email com paginação (sem cache)

```http
GET /gestao/performance/por-emails/danielelae@gmail.com?page=0&size=10
```

---

### 📌 Listar por email com paginação e cache

```http
GET /gestao/performance/por-email/danielelae@gmail.com?page=0&size=10
```

🔁 Essa rota utiliza:
```java
@Cacheable(
  value = "gastosPorEmailCache",
  key = "#email + '-' + #pageable.pageNumber + '-' + #pageable.pageSize + '-' + #pageable.sort.toString()"
)
```

---

## 🧠 Conceitos demonstrados

### 🔹 `@Cacheable`
Evita consultar o banco novamente quando os mesmos parâmetros forem usados — melhora performance em páginas acessadas com frequência.

### 🔹 `StopWatch` e `System.currentTimeMillis()`
Permitem medir o tempo real de execução da operação e visualizar o impacto do uso de cache.

### 🔹 `Pageable` e `@PageableDefault`
Facilitam a paginação de dados grandes sem precisar codificar lógica extra.

---

## 🛠️ Tecnologias usadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Cache
- H2 Database
- Bean Validation

---

## 🧠 Objetivo pedagógico

Mostrar na prática como um simples CRUD pode ser usado para ensinar:

- Performance com cache e paginação
- Design limpo com separação em camadas
- Medição real com logs e métricas simples
- Mentalidade de especialista pensando em escalabilidade

---

## ✨ Criado por

Daniele Leão — Professora de Java e Spring Boot, com foco em ensinar de forma prática, acessível e com base em problemas reais do dia a dia de quem desenvolve software.
