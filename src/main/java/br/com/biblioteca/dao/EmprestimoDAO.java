/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.dao;

/**
 *
 * @author leons
 */
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

    public void registrar(Emprestimo emp) throws Exception {
        String sql = "INSERT INTO emprestimo (id_usuario, id_livro, data_emprestimo, data_prevista_devolucao) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp.getUsuario().getId());
            stmt.setInt(2, emp.getLivro().getId());
            stmt.setDate(3, emp.getDataEmprestimo());
            stmt.setDate(4, emp.getDataPrevistaDevolucao());
            stmt.executeUpdate();
            
            // Diminuir estoque do livro
            decrementarEstoque(emp.getLivro().getId(), conn);
        }
    }
    
    public void devolver(int idEmprestimo, Date dataDevolucao, double multa, int idLivro) throws Exception {
        String sql = "UPDATE emprestimo SET data_devolucao = ?, multa = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, dataDevolucao);
            stmt.setDouble(2, multa);
            stmt.setInt(3, idEmprestimo);
            stmt.executeUpdate();
            
            // Repor estoque
            incrementarEstoque(idLivro, conn);
        }
    }

    // Lista empréstimos pendentes ou histórico completo
    public List<Emprestimo> listar(boolean apenasPendentes) throws Exception {
        List<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT e.*, u.nome, l.titulo FROM emprestimo e " +
                     "JOIN usuario u ON e.id_usuario = u.id " +
                     "JOIN livro l ON e.id_livro = l.id";
        
        if (apenasPendentes) {
            sql += " WHERE e.data_devolucao IS NULL";
        }
        
        sql += " ORDER BY e.data_emprestimo DESC";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Emprestimo e = new Emprestimo();
                e.setId(rs.getInt("id"));
                e.setDataEmprestimo(rs.getDate("data_emprestimo"));
                e.setDataPrevistaDevolucao(rs.getDate("data_prevista_devolucao"));
                e.setDataDevolucao(rs.getDate("data_devolucao"));
                e.setMulta(rs.getDouble("multa"));
                
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                e.setUsuario(u);
                
                Livro l = new Livro();
                l.setId(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                e.setLivro(l);
                
                lista.add(e);
            }
        }
        return lista;
    }
    
    // Métodos auxiliares de controle de estoque
    private void decrementarEstoque(int idLivro, Connection conn) throws SQLException {
        String sql = "UPDATE livro SET quantidade = quantidade - 1 WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, idLivro);
            stmt.executeUpdate();
        }
    }
    
    private void incrementarEstoque(int idLivro, Connection conn) throws SQLException {
        String sql = "UPDATE livro SET quantidade = quantidade + 1 WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, idLivro);
            stmt.executeUpdate();
        }
    }
}

