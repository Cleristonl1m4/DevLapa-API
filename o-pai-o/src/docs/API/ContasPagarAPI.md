# API - Gestão de Contas a Pagar

API REST desenvolvida com Spring Boot para gerenciamento financeiro, lançamentos de despesas e controle de pagamentos.

## Base URL
```
http://localhost:8080/api/contas
```

---

## Autenticação no Postman

Para acessar os endpoints protegidos, é necessário configurar o Bearer Token:

1. Realize o login no endpoint `/auth/login`.
2. Copie o valor do campo `token` da resposta.
3. No Postman, vá em **Authorization** -> **Type: Bearer Token** e cole o código.

---

## Endpoints

### Lançar nova conta

**POST** \
`http://localhost:8080/api/contas`

Registra uma nova conta a pagar vinculada a um usuário específico.

### Body
```json
{
  "descricao": "Aluguel Escritório",
  "valor": 1500.00,
  "dataVencimento": "2026-04-05",
  "usuarioId": 1
}
```

### Resposta
```json
{
    "id": 102,
    "descricao": "Aluguel Escritório",
    "valor": 1500.0,
    "dataVencimento": "2026-04-05",
    "status": "PENDENTE",
    "nomeUsuario": "Allyson"
}
```

---

### Listar todas as contas

**GET** \
`http://localhost:8080/api/contas`

Retorna o histórico completo de lançamentos financeiros cadastrados.

---

### Baixar conta (Pagar)

**PATCH** \
`http://localhost:8080/api/contas/{id}/pagar`

Altera o status da conta de **PENDENTE** para **PAGO**.

---

### Atualizar conta

**PUT** \
`http://localhost:8080/api/contas/{id}`

Atualiza todos os dados de uma conta específica (descrição, valor ou vencimento).

---

### Excluir lançamento

**DELETE** \
`http://localhost:8080/api/contas/{id}`

Remove permanentemente o registro da conta do banco de dados.

---

