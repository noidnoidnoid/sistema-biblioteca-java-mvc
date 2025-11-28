<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${sessionScope.usuarioLogado == null || sessionScope.usuarioLogado.tipo != 'ADMIN'}">
    <c:redirect url="index.jsp"/>
</c:if>
<html>
    <head>
        <title>Novo Livro</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <h2>Cadastro de Livro</h2>
        <form action="LivroController" method="POST">
            Título: <input type="text" name="titulo" required><br>
            Autor: <input type="text" name="autor" required><br>
            ISBN: <input type="text" name="isbn"><br>
            Quantidade: <input type="number" name="quantidade" value="1"><br><br>
            <button type="submit">Salvar</button>
        </form>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
