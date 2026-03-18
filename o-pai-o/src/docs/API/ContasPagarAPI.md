💰 API de Contas a Pagar
Esta API gerencia as obrigações financeiras do bar "O Pai Ó", permitindo o controle de gastos por fornecedor e data de vencimento.

🟢 1. Cadastrar Conta (POST)
Cria um novo registro de despesa vinculado a um fornecedor.

URL: /api/contas-pagar

Método: POST

Autenticação: Requer Bearer Token (Perfil: ADMIN ou GERENTE)

Estrutura do JSON (Request):

JSON
{
"fornecedorId": 6020,
"descricao": "Compra de engradados de cerveja",
"valor": 1500.00,
"dataVencimento": "2026-04-20",
"categoria": "ESTOQUE"
}
🔵 2. Listar Contas (GET)
Retorna todas as contas ou filtra por um fornecedor específico.

URL: /api/contas-pagar

Método: GET

Parâmetros Opcionais (Query Params):

fornecedorId: Filtra as contas de um fornecedor específico (Ex: ?fornecedorId=6020).

Exemplo de Resposta (200 OK):

JSON
[
{
"id": 1,
"descricao": "Compra de engradados de cerveja",
"valor": 1500.00,
"fornecedorNome": "Allyson Ramos Distribuidora",
"status": "PENDENTE"
}
]
🟡 3. Atualizar Conta (PUT)
Altera dados de uma conta existente.

URL: /api/contas-pagar/{id}

Método: PUT

🔴 4. Excluir Conta (DELETE)
Remove uma conta do sistema.

URL: /api/contas-pagar/{id}

Método: DELETE

Autenticação: Apenas perfil ADMIN.