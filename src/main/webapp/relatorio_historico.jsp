<%-- 
    Document   : relatorio_historico
    Created on : 27 de nov. de 2025, 15:16:22
    Author     : leons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
    <head><title>Relatório Geral</title></head>
    <body>
        <h2>Histórico de Empréstimos e Relatório de Multas</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Livro</th>
                    <th>Usuário</th>
                    <th>Retirada</th>
                    <th>Devolução Real</th>
                    <th>Multa Paga</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="totalMultas" value="0" />
                <c:forEach var="h" items="${historico}">
                    <tr>
                        <td>${h.id}</td>
                        <td>${h.livro.titulo}</td>
                        <td>${h.usuario.nome}</td>
                        <td><fmt:formatDate value="${h.dataEmprestimo}" pattern="dd/MM/yyyy"/></td>
                        <td>
                            <c:if test="${h.dataDevolucao != null}">
                                <fmt:formatDate value="${h.dataDevolucao}" pattern="dd/MM/yyyy"/>
                            </c:if>
                            <c:if test="${h.dataDevolucao == null}">Pendente</c:if>
                        </td>
                        <td>
                            R$ ${h.multa}
                            <c:set var="totalMultas" value="${totalMultas + h.multa}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5" align="right"><b>Total Arrecadado em Multas:</b></td>
                    <td><b>R$ ${totalMultas}</b></td>
                </tr>
            </tfoot>
        </table>
        <br><a href="index.jsp">Voltar</a>
    </body>
</html>