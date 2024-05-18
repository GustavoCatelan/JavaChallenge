Nome da aplicação: InovaTech

Prazo: 15/04/2024 ate dia 20/05/2024

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
![Imagem do WhatsApp de 2024-05-17 à(s) 17 30 48_86755407](https://github.com/GustavoCatelan/JavaChallenge/assets/127765306/696001b0-f929-4384-b91c-a50611f9759b)


Diagrama de Classe das Entidades
![image](https://github.com/GustavoCatelan/JavaChallenge/assets/127765306/74b62abd-41ad-4430-8611-e07883ab3bf8)

![image](https://github.com/GustavoCatelan/JavaChallenge/assets/127765306/2352908f-4c19-4b36-aae2-e751e441d19a)

![image](https://github.com/GustavoCatelan/JavaChallenge/assets/127765306/04cf84d1-d9c4-4492-81c4-1ecabc616195)


Link do video:
https://www.youtube.com/watch?v=pQHLYtz-2F0

Listagem de todos os endpoints:
{
			"name": "localhost/negociavel",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"nome\": \"Iphone 11\",\n    \"descricao\": \"Celular seminovo\",\n    \"preco\": 2000\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/negociavel",
					"host": [
						"localhost"
					],
					"path": [
						"negociavel"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/negociavel",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"nome\": \"Iphone 11\",\n    \"descricao\": \"Celular seminovo\",\n    \"preco\": 2000\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/negociavel",
					"host": [
						"localhost"
					],
					"path": [
						"negociavel"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/avaliacao",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"texto\": \"promoçâo\",\n    \"data\": \"2024-05-15\",\n    \"negociavel\": {\n        \"id\": 1\n    }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/avaliacao",
					"host": [
						"localhost"
					],
					"path": [
						"avaliacao"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/avaliacao",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"texto\": \"promoçâo\",\n    \"data\": \"2024-05-15\",\n    \"negociavel\": {\n        \"id\": 7\n    }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/avaliacao",
					"host": [
						"localhost"
					],
					"path": [
						"avaliacao"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"nome\": \"Gustavo\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/pessoa",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/pessoa",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/pessoaFisica",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"cpf\": \"73674738994\",\n  \"rg\": \"46738993\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/pessoa/pessoaFisica",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"pessoaFisica"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/pessoaFisica",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/pessoa/pessoaFisica",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"pessoaFisica"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/pessoaJuridica",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"cnpj\": \"3739939333\",\n  \"nomeFantasia\": \"Gugu LTDA\",\n  \"naturezaJuridica\": \"aprovada\",\n  \"situacao\": \"intenso\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/pessoa/pessoaJuridica",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"pessoaJuridica"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/pessoaJuridica",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/pessoa/pessoaJuridica",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"pessoaJuridica"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/1/telefone",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"ddi\": \"55\",\n  \"ddd\": \"11\",\n  \"numero\": \"962902444\",\n  \"pessoa\": {\n    \"id\": 1\n  }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/pessoa/1/telefone",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"1",
						"telefone"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/1/telefone",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/pessoa/1/telefone",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"1",
						"telefone"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/1/endereco",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"cep\": \"03361010\",\n  \"logradouro\": \"Av. Cipriano Rodrigues\",\n  \"numero\": \"340\",\n  \"complemento\": \"Travessa João XVIII\",\n  \"bairro\": \"Vila Formosa\",\n  \"cidade\": \"São Paulo\",\n  \"estado\": \"São Paulo\",\n  \"pessoa\": {\n    \"id\": 1\n  }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/pessoa/1/endereco",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"1",
						"endereco"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/pessoa/1/endereco",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/pessoa/1/endereco",
					"host": [
						"localhost"
					],
					"path": [
						"pessoa",
						"1",
						"endereco"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/distribuidor",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"areaCobertura\": \"Zona Leste\",\n  \"localizacao\": \"Av. Paulista\",\n  \"tipo\": \"Varejo\",\n  \"pessoa\": {\n    \"id\": 1\n  }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/distribuidor",
					"host": [
						"localhost"
					],
					"path": [
						"distribuidor"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/distribuidor",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/distribuidor",
					"host": [
						"localhost"
					],
					"path": [
						"distribuidor"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/usuario",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"userName\": \"XxGu\",\n  \"password\": \"Corinthians2000\",\n  \"pessoa\": {\n    \"id\": 1\n  }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/usuario",
					"host": [
						"localhost"
					],
					"path": [
						"usuario"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/usuario",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/usuario",
					"host": [
						"localhost"
					],
					"path": [
						"usuario"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/negociavel/produto",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"quantidade\": 5,\n  \"avaliacao\": {\n    \"id\": 4\n  }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/negociavel/produto",
					"host": [
						"localhost"
					],
					"path": [
						"negociavel",
						"produto"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/negociavel/produto",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/negociavel/produto",
					"host": [
						"localhost"
					],
					"path": [
						"negociavel",
						"produto"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/negociavel/servico",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"avaliacao\": {\n    \"id\": 1\n  }\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost/negociavel/servico",
					"host": [
						"localhost"
					],
					"path": [
						"negociavel",
						"servico"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost/negociavel/servico",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost/negociavel/servico",
					"host": [
						"localhost"
					],
					"path": [
						"negociavel",
						"servico"
					]
				}
			},
			"response": []
		}
