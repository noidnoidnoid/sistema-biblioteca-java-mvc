<%-- 
    Document   : novo_emprestimo
    Created on : 27 de nov. de 2025, 15:15:25
    Author     : leons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head><title>Novo Empréstimo</title></head>
    <body>
        <h2>Registrar Empréstimo</h2>
        <form action="EmprestimoController" method="POST">
            <input type="hidden" name="acao" value="salvar">
            
            <label>Selecione o Usuário:</label><br>
            <select name="usuario">
                <c:forEach var="u" items="${usuarios}">
                    <option value="${u.id}">${u.nome}</option>
                </c:forEach>
            </select>
            <br><br>
            
            <label>Selecione o Livro:</label><br>
            <select name="livro">
                <c:forEach var="l" items="${livros}">
                    <option value="${l.id}">${l.titulo} (Disp: ${l.quantidade})</option>
                </c:forEach>
            </select>
            <br><br>
            
            <button type="submit">Confirmar Empréstimo</button>
        </form>
        <br>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>
