<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Empréstimos Ativos</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <h2>Empréstimos Pendentes</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Livro</th>
                    <th>Usuário</th>
                    <th>Data Empréstimo</th>
                    <th>Prevista Devolução</th>
                    <th>Status</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="emp" items="${listaEmprestimos}">
                    <tr>
                        <td>${emp.livro.titulo}</td>
                        <td>${emp.usuario.nome}</td>
                        <td><fmt:formatDate value="${emp.dataEmprestimo}" pattern="dd/MM/yyyy"/></td>
                        <td><fmt:formatDate value="${emp.dataPrevistaDevolucao}" pattern="dd/MM/yyyy"/></td>
                        <td style="color: ${emp.status == 'ATRASADO' ? 'red' : 'green'}">
                            <b>${emp.status}</b>
                        </td>
                        <td>
                            <form action="EmprestimoController" method="POST">
                                <input type="hidden" name="acao" value="devolver">
                                <input type="hidden" name="idEmprestimo" value="${emp.id}">
                                <input type="hidden" name="idLivro" value="${emp.livro.id}">
                                <input type="hidden" name="dataPrevista" value="${emp.dataPrevistaDevolucao}">
                                <button type="submit">Devolver</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br><a href="index.jsp">Voltar</a>
    </body>
</html>
