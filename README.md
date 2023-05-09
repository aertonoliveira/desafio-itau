
## Documentação da API


#### POST /quantidade/parcelas
Request:
```http
  {
    "contrato": {
        "id_contrato": 37959,
        "ultimo_digito_contrato":9,
        "numero_cpf_cnpj_cliente": "66273815089",
        "data_contratacao": "2023-03-10",
        "ativo": true,
        "parcelas_em_atraso": false
    },
    "financeiro": [
        {
        "data_calculo": "2023-03-10",
        "tipo_calculo": "CONTRATACAO",
        "valor_total": 50000.00,
        "quantidade_parcelas": 54,
        "valor_parcelas": "1000.00",
        "dia_pagamento": 23,
        "percentual_taxa_juro": 1.99
        }
    ],
    "adiantamento": {
        "nova_quantidade_parcelas": 56
    }
}
```
Response:
```http
{
    "contrato": {
        "id_contrato": "37959",
        "ultimo_digito_contrato": "9",
        "numero_cpf_cnpj_cliente": "66273815089",
        "data_contratacao": "2023-03-10",
        "ativo": true,
        "parcelas_em_atraso": false
    },
    "financeiro": [
        {
            "data_calculo": "2023-03-10T00:00:00.000+00:00",
            "tipo_calculo": "CONTRATACAO",
            "valor_total": 50000.0,
            "quantidade_parcelas": 54,
            "valor_parcelas": 1000.0,
            "dia_pagamento": 23,
            "percentual_taxa_juro": 1.99
        },
        {
            "data_calculo": "2023-05-09T02:53:51.177+00:00",
            "tipo_calculo": "ADITAMENTO",
            "valor_total": 52000.0,
            "quantidade_parcelas": 23,
            "valor_parcelas": 928.5714285714286,
            "dia_pagamento": 1,
            "percentual_taxa_juro": 1.93
        }
    ],
    "adiantamento": {
        "nova_quantidade_parcelas": 56
    }
}
```



####  POST /alteracao/data
request:
```http
 {
    "contrato": {
        "id_contrato": 37959,
         "ultimo_digito_contrato":9,
        "numero_cpf_cnpj_cliente": "66273815089",
        "data_contratacao": "2023-03-10",
        "ativo": true,
        "parcelas_em_atraso": false
    },
    "financeiro": [
    {
        "data_calculo": "2023-05-18",
        "tipo_calculo": "CONTRATACAO",
        "valor_total": 50000.00,
        "quantidade_parcelas": 50,
        "valor_parcelas": "1000.00",
        "dia_pagamento": 23,
        "percentual_taxa_juro": 1.99
    }
    ],
    "adiantamento": {
        "nova_data_pagamento": 15
    }
}
```

response:
```http
    "contrato": {
        "id_contrato": "37959",
        "ultimo_digito_contrato": "9",
        "numero_cpf_cnpj_cliente": "66273815089",
        "data_contratacao": "2023-03-10",
        "ativo": true,
        "parcelas_em_atraso": false
    },
    "financeiro": [
        {
            "data_calculo": "2023-05-18T00:00:00.000+00:00",
            "tipo_calculo": "ADITAMENTO",
            "valor_total": 50000.0,
            "quantidade_parcelas": 50,
            "valor_parcelas": 1000.0,
            "dia_pagamento": 15,
            "percentual_taxa_juro": 1.99
        },
        {
            "data_calculo": "2023-05-18T00:00:00.000+00:00",
            "tipo_calculo": "ADITAMENTO",
            "valor_total": 50000.0,
            "quantidade_parcelas": 50,
            "valor_parcelas": 1000.0,
            "dia_pagamento": 15,
            "percentual_taxa_juro": 1.99
        }
    ]
}
```

