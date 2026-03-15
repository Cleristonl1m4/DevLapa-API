Perfeito, um arquivo `README.md` ou `API_DOCUMENTATION.md` bem estruturado é essencial para que o seu "eu do futuro" ou outros desenvolvedores saibam como interagir com o sistema.

Como você já tem o **Spring Security** e o **JWT** rodando, a documentação precisa deixar claro onde o token é necessário.

Aqui está um modelo completo em Markdown para você copiar e adaptar:

---

# 📖 Documentação da API - Módulo de Usuários

Esta API gerencia a autenticação e o cadastro de usuários para o ecossistema **O-Pai-Ó**.

## 🔐 Autenticação

A maioria dos endpoints requer um **JSON Web Token (JWT)** enviado no cabeçalho da requisição.

**Cabeçalho esperado:**

```http
Authorization: Bearer <seu_token_aqui>

```

---

## 🚀 Endpoints de Usuários

### 1. Autenticação (Login)

Realiza o login e retorna o token de acesso.

* **URL:** `/auth/login`
* **Método:** `POST`
* **Autenticação Requerida:** Não

**Corpo da Requisição (JSON):**

```json
{
  "login": "seu_usuario",
  "senha": "sua_senha"
}

```

**Resposta de Sucesso (200 OK):**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "nome": "Allyson Lapa"
}

```

---

### 2. Cadastro de Usuário

Cria um novo usuário no sistema.

* **URL:** `/auth/register` (ou `/api/usuarios`)
* **Método:** `POST`
* **Autenticação Requerida:** Depende da sua config (geralmente `permitAll`)

**Corpo da Requisição:**

```json
{
  "login": "joao_silva",
  "senha": "senha123",
  "nome": "João Silva",
  "role": "USER"
}

```

---

### 3. Listar Usuários

Retorna a lista de todos os usuários cadastrados.

* **URL:** `/api/usuarios`
* **Método:** `GET`
* **Autenticação Requerida:** **Sim (Bearer Token)**

**Resposta de Sucesso (200 OK):**

```json
[
  {
    "id": 1,
    "login": "admin",
    "nome": "Administrador"
  },
  {
    "id": 2,
    "login": "joao_silva",
    "nome": "João Silva"
  }
]

```

---

## ⚠️ Códigos de Resposta (Status Codes)

| Código | Descrição | Motivo Comum |
| --- | --- | --- |
| **200** | OK | Requisição realizada com sucesso. |
| **201** | Created | Recurso criado com sucesso (POST). |
| **400** | Bad Request | Dados inválidos no corpo da requisição. |
| **403** | Forbidden | Token ausente, inválido ou expirado. |
| **404** | Not Found | Usuário ou endpoint não encontrado. |

---

## 🛠️ Como testar no Postman/Insomnia

1. Chame o endpoint `/auth/login`.
2. Copie o campo `token` da resposta.
3. Nas próximas chamadas, vá na aba **Authorization**, selecione **Bearer Token** e cole o valor.

---

