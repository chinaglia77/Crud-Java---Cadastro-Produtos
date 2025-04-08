# 🛍️ Sistema de Cadastro de Produtos - Java Swing

Este é um sistema desktop desenvolvido em **Java Swing** utilizando o padrão de arquitetura **DAO/DTO**. A aplicação permite **cadastrar, listar, pesquisar, alterar e excluir produtos** em uma interface gráfica amigável.

## 📦 Funcionalidades

- ✅ Cadastro de produtos
- 🔍 Pesquisa de produtos por ID
- 📋 Listagem de todos os produtos
- ✏️ Alteração de produtos
- ❌ Exclusão de produtos selecionados
- 🧹 Limpeza dos campos do formulário

---

## 🧱 Tecnologias Utilizadas

- Java SE
- Swing (Interface gráfica)
- JDBC (Conexão com banco de dados)
- Padrão DAO/DTO

---


---

## ⚙️ Pré-requisitos

- JDK 8 ou superior
- NetBeans ou outro IDE Java
- Banco de dados (MySQL ou outro compatível)
- Driver JDBC correspondente ao banco

---

## 🔧 Configuração do Banco de Dados

Crie uma tabela chamada `produtos` com a seguinte estrutura:

```sql
CREATE TABLE produto (
    id_produto INT PRIMARY KEY,
    nome_produto VARCHAR(100),
    categoria_produto VARCHAR(50),
    qtd_estoque INT,
    preco DECIMAL(10, 2)
);

