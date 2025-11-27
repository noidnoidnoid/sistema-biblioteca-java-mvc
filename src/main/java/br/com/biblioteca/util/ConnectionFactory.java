/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.biblioteca.util;

/**
 *
 * @author leons
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    // Configurações do Java DB (Derby)
    private static final String URL = "jdbc:derby://localhost:1527/biblioteca_db";
    private static final String USER = "app";
    private static final String PASS = "123";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Carrega o driver explicitamente (necessário em versões antigas ou específicas do Glassfish)
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}