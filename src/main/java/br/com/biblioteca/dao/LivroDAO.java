/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.dao;

/**
 *
 * @author leons
 */
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void salvar(Livro livro) throws Exception {
        String sql = "INSERT INTO livro (titulo, autor, isbn, quantidade) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getIsbn());
            stmt.setInt(4, livro.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public List<Livro> listarTodos() throws Exception {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Livro l = new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("isbn"),
                    rs.getInt("quantidade")
                );
                livros.add(l);
            }
        }
        return livros;
    }
}

