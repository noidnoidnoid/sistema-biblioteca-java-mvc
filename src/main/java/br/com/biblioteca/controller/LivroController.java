/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;

/**
 *
 * @author leons
 */
import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.model.Livro;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LivroController", urlPatterns = {"/LivroController"})
public class LivroController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        LivroDAO dao = new LivroDAO();

        try {
            if ("listar".equals(acao)) {
                List<Livro> lista = dao.listarTodos();
                request.setAttribute("listaLivros", lista);
                request.getRequestDispatcher("listar_livros.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Cadastro de livro
        try {
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            String isbn = request.getParameter("isbn");
            int qtd = Integer.parseInt(request.getParameter("quantidade"));

            Livro livro = new Livro(0, titulo, autor, isbn, qtd);
            LivroDAO dao = new LivroDAO();
            dao.salvar(livro);

            // Redireciona para listar
            response.sendRedirect("LivroController?acao=listar");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

