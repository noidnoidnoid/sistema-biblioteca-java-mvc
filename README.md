# Sistema de Gerenciamento de Biblioteca (Java MVC)

Este projeto é um sistema web para gestão de bibliotecas desenvolvido em Java, utilizando a arquitetura MVC (Model-View-Controller) com Servlets, JSP e banco de dados Apache Derby.

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 21 recomendado)
* **Framework Web:** Jakarta EE 10 (Servlet & JSP)
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** Apache Derby (Java DB)
* **Servidor de Aplicação:** GlassFish 7+
* **IDE:** Apache NetBeans

---
## Pré-requisitos

Certifique-se de ter instalado:

1.  **NetBeans IDE** (com suporte a Jakarta EE).
2.  **JDK 21** configurado.
3.  **Servidor GlassFish** adicionado ao NetBeans.

---

## Configuração do Banco de Dados

O projeto conecta-se ao banco via JDBC na URL `jdbc:derby://localhost:1527/biblioteca_db`.

1.  No NetBeans, vá à aba **Services** > **Databases**.
2.  Inicie o servidor **Java DB** (Start Server).
3.  Crie um novo banco de dados:
    * **Database Name:** `biblioteca_db`
    * **User Name:** `app`
    * **Password:** `123`
4.  Conecte-se ao banco criado.
5.  Execute o script SQL localizado no ficheiro `comandos sql.txt` na raiz do projeto para criar as tabelas e inserir os dados iniciais.

---

## Como Executar

1.  Abra o projeto no NetBeans.
2.  Execute **Clean and Build** para baixar as dependências do Maven.
3.  Verifique se o servidor GlassFish está selecionado.
4.  Clique em **Run** (F6).
5.  O navegador abrirá na página de login.

---

## Acesso ao Sistema

O sistema já possui utilizadores pré-cadastrados:

### Administrador
* **Email:** `admin@biblioteca.com`
* **Senha:** `admin`
* *Funções:* Cadastro de livros, relatórios de multas e histórico.

### Usuário Comum (Aluno)
* **Email:** `aluno@teste.com`
* **Senha:** `123`
* *Funções:* Consultar acervo e realizar empréstimos.

---

## Funcionalidades Principais

* **Autenticação:** Login com sessões HTTP.
* **Empréstimos:** Registo de empréstimos com verificação de stock.
* **Devoluções:** Cálculo automático de multas por atraso (R$ 2,00/dia).
* **Relatórios:** Visualização de empréstimos ativos e histórico financeiro.