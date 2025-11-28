<%-- cadastrar_usuario.jsp --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Criar Conta</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <center>
            <h2>Crie sua conta</h2>
            <form action="UsuarioController" method="POST">
                <label>Nome Completo:</label>
                <input type="text" name="nome" required placeholder="Ex: João da Silva">
                
                <label>E-mail:</label>
                <input type="email" name="email" required placeholder="seu@email.com">
                
                <label>Senha:</label>
                <input type="password" name="senha" required>
                
                <button type="submit">Cadastrar</button>
            </form>
            <br>
            <a href="login.jsp" class="btn-voltar">Voltar para Login</a>
        </center>
    </body>
</html>