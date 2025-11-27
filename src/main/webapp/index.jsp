<%-- 
    Document   : index
    Created on : 27 de nov. de 2025, 14:19:02
    Author     : leons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:if test="${sessionScope.usuarioLogado == null}">
    <c:redirect url="login.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
    <head> <title>Dashboard</title> </head>
    <body>
        <h1>Bem-vindo, ${sessionScope.usuarioLogado.nome}!</h1>
        <hr>
        <h3>Livros</h3>
        <ul>
            <li><a href="cadastrar_livro.jsp">Cadastrar Novo Livro</a></li>
            <li><a href="LivroController?acao=listar">Listar Livros</a></li>
        </ul>
        <h3>Empréstimos</h3>
        <ul>
            <li><a href="EmprestimoController?acao=novo">Novo Empréstimo</a></li>
            <li><a href="EmprestimoController?acao=listar">Devoluções / Empréstimos Ativos</a></li>
        </ul>
        <h3>Administrativo</h3>
        <ul>
            <li><a href="EmprestimoController?acao=historico">Histórico e Relatórios</a></li>
        </ul>
        <hr>
        <a href="logout.jsp">Sair</a>
    </body>
</html>

