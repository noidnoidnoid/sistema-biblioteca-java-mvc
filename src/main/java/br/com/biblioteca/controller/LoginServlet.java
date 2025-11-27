/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;

/**
 *
 * @author leons
 */
import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.autenticar(email, senha);
        
        if (usuario != null) {
            // Cria sessão para o usuário (Aula 4)
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);
            response.sendRedirect("index.jsp"); // Vai para o Dashboard
        } else {
            request.setAttribute("erro", "Email ou senha inválidos!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

