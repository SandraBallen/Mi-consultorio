/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sanba
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/mi_consultorio?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";
    
    public static Connection obtenerConexion() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage()); 
        } catch (SQLException e) {
            System.out.println("Error al conecta a la BD" + e.getMessage());
        }
        return con;
    }
}
