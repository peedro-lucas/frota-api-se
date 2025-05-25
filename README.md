# 🚗 Sistema de Gerenciamento de Frota

Este é um sistema web para cadastro, consulta, atualização e remoção de veículos (carros e motos), com suporte a filtros por tipo e fabricante. A aplicação backend é desenvolvida em **Java com Spring Boot**, conectada a um banco de dados **PostgreSQL**, e possui interface web separada no frontend (veja seção abaixo).

---

## 🗂️ Sumário

- [Tecnologias](#tecnologias)
- [Modelagem do Banco de Dados](#modelagem-do-banco-de-dados)
- [Regras de Negócio](#regras-de-negócio)
- [Como Executar](#como-executar)
- [Rotas da API](#rotas-da-api)
- [Frontend](#frontend)
- [To-Do](#to-do)

---

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.x
- PostgreSQL
- Maven
- JPA/Hibernate
- RESTful API
- HTML/CSS/JS (frontend separado)

- LINK PARA O FRONTEND: https://github.com/peedro-lucas/front-end

---

| Método | Rota               | Descrição                                    |
| ------ | ------------------ | ---------------------------------------------|
| GET    | `/veiculos`        | Lista todos os veículos                      |
| GET    | `/veiculos/{id}`   | Busca veículo por ID                         |
| GET    | `/veiculos/filtro` | Filtra por `tipo`,`fabricante` ,`cor`, `ano` |
| POST   | `/veiculos`        | Cria um novo veículo                         |
| PUT    | `/veiculos/{id}`   | Atualiza um veículo existente                |
| DELETE | `/veiculos/{id}`   | Remove um veículo                            |


## 🧩 Modelagem do Banco de Dados

```sql
CREATE TABLE veiculo (
  id SERIAL PRIMARY KEY,
  modelo VARCHAR(100) NOT NULL,
  fabricante VARCHAR(100) NOT NULL,
  ano INTEGER NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  cor VARCHAR(50) NOT NULL,
  tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('carro', 'moto'))
);

CREATE TABLE carro (
  veiculo_id INTEGER PRIMARY KEY REFERENCES veiculo(id) ON DELETE CASCADE,
  quantidade_portas INTEGER NOT NULL,
  tipo_combustivel VARCHAR(20) NOT NULL CHECK (tipo_combustivel IN ('gasolina', 'etanol', 'diesel', 'flex'))
);

CREATE TABLE moto (
  veiculo_id INTEGER PRIMARY KEY REFERENCES veiculo(id) ON DELETE CASCADE,
  cilindrada INTEGER NOT NULL
);
```

