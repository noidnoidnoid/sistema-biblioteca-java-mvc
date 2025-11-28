<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Novo Empréstimo</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <h2>Registrar Empréstimo</h2>
        <form action="EmprestimoController" method="POST">
            <input type="hidden" name="acao" value="salvar">
            
            <label>Usuário:</label><br>
            
            <c:choose>
                <c:when test="${sessionScope.usuarioLogado.tipo == 'ADMIN'}">
                    <select name="usuario">
                        <c:forEach var="u" items="${usuarios}">
                            <option value="${u.id}">${u.nome} (${u.email})</option>
                        </c:forEach>
                    </select>
                </c:when>
                
                <c:otherwise>
                    <input type="text" value="${sessionScope.usuarioLogado.nome}" disabled style="background-color: #e9ecef;">
                    
                    <input type="hidden" name="usuario" value="${sessionScope.usuarioLogado.id}">
                </c:otherwise>
            </c:choose>
            <br><br>
            
            <label>Selecione o Livro:</label><br>
            <select name="livro">
                <c:forEach var="l" items="${livros}">
                    <c:if test="${l.quantidade > 0}">
                        <option value="${l.id}">${l.titulo} (Disp: ${l.quantidade})</option>
                    </c:if>
                </c:forEach>
            </select>
            <br><br>
            
            <button type="submit">Confirmar Empréstimo</button>
        </form>
        <br>
        <a href="index.jsp" class="btn-voltar">Cancelar</a>
    </body>
</html>