<%-- 
    Document   : listar_livros
    Created on : 27 de nov. de 2025, 14:23:51
    Author     : leons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head><title>Livros</title></head>
    <body>
        <h2>Acervo da Biblioteca</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>ISBN</th>
                    <th>Qtd</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="livro" items="${listaLivros}">
                    <tr>
                        <td>${livro.id}</td>
                        <td>${livro.titulo}</td>
                        <td>${livro.autor}</td>
                        <td>${livro.isbn}</td>
                        <td>${livro.quantidade}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="index.jsp">Voltar ao Menu</a>
    </body>
</html>
