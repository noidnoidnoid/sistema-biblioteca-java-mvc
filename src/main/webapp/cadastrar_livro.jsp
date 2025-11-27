<%-- 
    Document   : cadastrar_livro
    Created on : 27 de nov. de 2025, 14:19:51
    Author     : leons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>Novo Livro</title></head>
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
