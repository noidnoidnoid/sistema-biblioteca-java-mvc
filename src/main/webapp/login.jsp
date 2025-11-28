<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - Biblioteca</title>
        <style>body { font-family: sans-serif; padding: 20px; }</style>
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <h2>Acesso ao Sistema</h2>
        <h3 style="color:red">${erro}</h3>
        
        <form action="LoginServlet" method="POST">
            Email: <input type="email" name="email" required><br><br>
            Senha: <input type="password" name="senha" required><br><br>
            <button type="submit">Entrar</button>
            <br><br>
            <a href="cadastrar_usuario.jsp">Não tem conta? Cadastre-se aqui.</a>
        </form>
    </body>
</html>
