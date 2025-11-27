/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.controller;

/**
 *
 * @author leons
 */
import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EmprestimoController", urlPatterns = {"/EmprestimoController"})
public class EmprestimoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        EmprestimoDAO dao = new EmprestimoDAO();

        try {
            if ("novo".equals(acao)) {
                // Carrega usuários e livros para preencher o formulário (ComboBox)
                UsuarioDAO uDao = new UsuarioDAO();
                LivroDAO lDao = new LivroDAO();
                request.setAttribute("usuarios", uDao.listarTodos());
                request.setAttribute("livros", lDao.listarTodos());
                request.getRequestDispatcher("novo_emprestimo.jsp").forward(request, response);
                
            } else if ("listar".equals(acao)) {
                // Lista apenas os pendentes de devolução
                List<Emprestimo> lista = dao.listar(true);
                // Verifica atrasos para exibição
                LocalDate hoje = LocalDate.now();
                for(Emprestimo e : lista) {
                    if(e.getDataPrevistaDevolucao().toLocalDate().isBefore(hoje)) {
                        e.setStatus("ATRASADO");
                    } else {
                        e.setStatus("EM DIA");
                    }
                }
                request.setAttribute("listaEmprestimos", lista);
                request.getRequestDispatcher("gerenciar_emprestimos.jsp").forward(request, response);
                
            } else if ("historico".equals(acao)) {
                // Lista tudo (Relatório Administrativo)
                List<Emprestimo> lista = dao.listar(false);
                request.setAttribute("historico", lista);
                request.getRequestDispatcher("relatorio_historico.jsp").forward(request, response);
            }
        } catch (Exception e) { throw new ServletException(e); }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        EmprestimoDAO dao = new EmprestimoDAO();

        try {
            if ("salvar".equals(acao)) {
                int idUsuario = Integer.parseInt(request.getParameter("usuario"));
                int idLivro = Integer.parseInt(request.getParameter("livro"));
                
                Emprestimo emp = new Emprestimo();
                Usuario u = new Usuario(); u.setId(idUsuario);
                Livro l = new Livro(); l.setId(idLivro);
                emp.setUsuario(u);
                emp.setLivro(l);
                
                // Define data atual e data prevista (ex: +7 dias)
                LocalDate hoje = LocalDate.now();
                emp.setDataEmprestimo(java.sql.Date.valueOf(hoje));
                emp.setDataPrevistaDevolucao(java.sql.Date.valueOf(hoje.plusDays(7)));
                
                dao.registrar(emp);
                response.sendRedirect("EmprestimoController?acao=listar");
                
            } else if ("devolver".equals(acao)) {
                int idEmprestimo = Integer.parseInt(request.getParameter("idEmprestimo"));
                int idLivro = Integer.parseInt(request.getParameter("idLivro"));
                String dataPrevistaStr = request.getParameter("dataPrevista");
                
                LocalDate dataPrevista = LocalDate.parse(dataPrevistaStr);
                LocalDate dataDevolucao = LocalDate.now();
                
                // Cálculo de Multa (Ex: R$ 2,00 por dia de atraso)
                double multa = 0.0;
                if (dataDevolucao.isAfter(dataPrevista)) {
                    long diasAtraso = ChronoUnit.DAYS.between(dataPrevista, dataDevolucao);
                    multa = diasAtraso * 2.00;
                }
                
                dao.devolver(idEmprestimo, java.sql.Date.valueOf(dataDevolucao), multa, idLivro);
                response.sendRedirect("EmprestimoController?acao=listar");
            }
        } catch (Exception e) { throw new ServletException(e); }
    }
}
