<%-- 
    Document   : login
    Created on : 27 de nov. de 2025, 14:18:19
    Author     : leons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - Biblioteca</title>
        <style>body { font-family: sans-serif; padding: 20px; }</style>
    </head>
    <body>
        <h2>Acesso ao Sistema</h2>
        <h3 style="color:red">${erro}</h3>
        
        <form action="LoginServlet" method="POST">
            Email: <input type="email" name="email" required><br><br>
            Senha: <input type="password" name="senha" required><br><br>
            <button type="submit">Entrar</button>
        </form>
    </body>
</html>
