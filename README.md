Nome da aplicação: InovaTech

Integrantes e Responsabilidade:

2TDSPJ - Lucas dos Santos Lopes - RM550790 - Java,Advanced,Compliance,Banco de dados

2TDSPJ - Gustavo Catelan - RM551823 - Java,Advanced,Compliance,Banco de dados

2TDSPJ - Murilo Machado - RM550718 - Banco de Dados,Advanced,Compliance

2TDSPJ - Victor Taborda Rodrigues - RM97900 - Disruptive Architectures,DevOps,Compliance

2TDSPW - Allan Percario - RM99903 - Mobile app development, banco de dados, Compliance

Instrução de como rodar a aplicação:
- Clone o repositório do projeto InovaTech.
- Abra o IntelliJ IDEA.
- Importe o projeto InovaTech no IntelliJ.
- Execute o aplicativo no IntelliJ.
- Abra um navegador da web.
- Acesse a aplicação digitando o URL correspondente.
Para inserir dados:
- Você pode inserir dados diretamente no banco de dados ou, utilize o Postman para fazer requisições aos endpoints fornecidos, inserindo a URL e os valores correspondentes.





Diagrama de Entidade e Relacionamento
![image](https://github.com/GustavoCatelan/JavaChallenge/assets/127765306/9b27c6f8-56f5-4ae9-971e-8c44dc2cb1a0)

Diagrama de Classe das Entidades
![image](https://github.com/GustavoCatelan/JavaChallenge/assets/127765306/ab5a381b-a173-461c-b02d-14c16ac143c9)

Link do video:
https://www.youtube.com/watch?v=pQHLYtz-2F0

Listagem de todos os endpoints:

TODOS OS POST:

POST http://localhost:80/analiseDados
Content-Type: application/json
{
  "avaliacoes": "Otimo",
  "numeroCompra": "04845654",
  "recomendacoes": "Nenhuma",
  "tipo": "Custo beneficio",
  "data": "21/02/2005"
}

POST http://localhost:80/analiseDados/{{id}}/produto
Content-Type: application/json

{
  "nome": "airfryer",
  "descricao": "A Air Fryer eos 4 Litros é uma opção prática e eficiente para cozinhar.
Com capacidade interna de 4 litros, é ideal para porções generosas.
Possui tecnologia Turbo Twist AirFryer para um cozimento mais rápido, sistema antiaderente MaxxiClean para facilitar a limpeza e frita sem óleo, promovendo uma opção saudável.
Conta com sistema de proteção para evitar a queda acidental do cesto interno, timer programável e temperatura ajustável de até 200°C.
Com potência de 1.500W, é compacta e possui um cesto de 3,5 litros de capacidade útil e 4 litros de capacidade total.",
  "preco": 227.74,
  "quantidade": 15
}

POST http://localhost:80/analiseDados/{{id}}/servico
Content-Type: application/json

{
  "nome": "Limpeza de dados",
  "descricao": "Serviço de limpeza e organização de dados para análise",
  "preco": 500.00,
 }

 POST http://localhost:80/distribuidor
Content-Type: application/json

{
  "nome": "Roberto Alvarez",
  "areaCobertura": "Zona Leste",
  "localizacao": "Vila Formosa",
  "tipo": "Consultoria"
}

POST http://localhost:80/distribuidor/{{id}}/endereco
Content-Type: application/json

{
  "cep":  12345678,
  "logradouro": "Rua das Flores",
  "numero": 100,
  "complemento": "Apto 101",
  "bairro": "Centro",
  "cidade": "São Paulo",
  "estado": "SP"
}

POST http://localhost:80/distribuidor/{{id}}/produto
Content-Type: application/json

{
  "nome": "Iphone 14",
  "descricao": "O mais novo celular da Apple",
  "preco": 5500,
  "quantidade": 3
}

POST http://localhost:80/distribuidor/{{id}}/servico
Content-Type: application/json

{
  "nome": "Convenio NotreDame",
  "descricao": "Um convenio para uso do serviço da NotreDame",
  "preco": 2500.90
}

POST http://localhost/distribuidor/{{id}}/telefone
Content-Type: application/json

{
  "ddi": 55,
  "ddd": 11,
  "numero": 987654321
}

POST http://localhost/usuario
Content-Type: application/json

{
  "nome": "Carlos Ferreira",
  "email": "carlosferreira@fastshop.com",
  "assinatura": "Plano Básico"
}

POST http://localhost/usuario/{{id}}/compra
Content-Type: application/json

{
  "valorTotal": 150,
  "status": "Concluida"
}

POST http://localhost/usuario/{{id}}/endereco
Content-Type: application/json

{
  "cep": 45678901,
  "logradouro": "Rua do Bosque",
  "numero": 400,
  "complemento": "Sala 302",
  "bairro": "Centro",
  "cidade": "Belo Horizonte",
  "estado": "MG"
}

POST http://localhost/usuario/{{id}}/pessoaFisica
Content-Type: application/json

{
  "cpf": 12345674300,
  "rg": "123456789"
}

POST http://localhost/usuario/{{id}}/pessoaJuridica
Content-Type: application/json

{
  "cnpj": 12345678901234,
  "nomeEmpresa": "Unimed",
  "nomeFantasia": "Unimed São Paulo",
  "naturezaJuridica": "Médicas",
  "situacao": "Ativa"
}

POST http://localhost/usuario/{{id}}/telefone
Content-Type: application/json

{
  "ddi": 55,
  "ddd": 11,
  "numero": 987654321
}

POST http://localhost/pagamento
Content-Type: application/json

{
  "metodo": "Cartão de Crédito",
  "status": "Concluído"
}

POST http://localhost/pagamento/{{id}}/compra
Content-Type: application/json

{
  "valorTotal": 70.00,
  "status": "Pendente"
}

POST http://localhost/pagamento/{{id}}/pagamentoCartao
Content-Type: application/json

{
  "tipo": "Debito",
  "bandeira": "Visa",
  "validade": "05/26",
  "numero": 1234567890123456,
  "cvv": 123
}

TODOS OS GETS:

GET http://localhost:80/analiseDados

GET http://localhost:80/analiseDados/{{id}}

GET http://localhost:80/analiseDados/{{id}}/produto

GET http://localhost:80/analiseDados/{{id}}/servico

GET http://localhost:80/distribuidor

GET http://localhost:80/distribuidor/{{id}}

GET http://localhost:80/distribuidor/{{id}}/endereco

GET http://localhost:80/distribuidor/{{id}}/produto

GET http://localhost:80/distribuidor/{{id}}/servico

GET http://localhost:80/distribuidor/{{id}}/telefone

GET http://localhost:80/usuario

GET http://localhost:80/usuario/{{id}}

GET http://localhost:80/usuario/{{id}}/PessoaFisica

GET http://localhost:80/usuario/{{id}}/PessoaJuridica

GET http://localhost:80/usuario/{{id}}/compra

GET http://localhost:80/usuario/{{id}}/endereco

GET http://localhost:80/usuario/{{id}}/telefone

GET http://localhost:80/pagamento

GET http://localhost:80/pagamento/{{id}}

GET http://localhost:80/pagamento/{{id}}/compra

GET http://localhost:80/pagamento/{{id}}/pagamentoCartao
