/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.model;

/**
 *
 * @author leons
 */

import java.sql.Date;

public class Emprestimo {
    private int id;
    private Usuario usuario; // Associação
    private Livro livro;     // Associação
    private Date dataEmprestimo;
    private Date dataPrevistaDevolucao;
    private Date dataDevolucao;
    private double multa;
    private String status;

    public Emprestimo() {
        this.usuario = new Usuario();
        this.livro = new Livro();
    }
    
    // Getters e Setters omitidos para brevidade (Gere-os na IDE: Alt+Insert -> Getters and Setters)
    // Importante: Crie todos os getters e setters para funcionar com JSP EL
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    
    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }
    
    public Date getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(Date dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    
    public Date getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) { this.dataPrevistaDevolucao = dataPrevistaDevolucao; }
    
    public Date getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(Date dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    
    public double getMulta() { return multa; }
    public void setMulta(double multa) { this.multa = multa; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}