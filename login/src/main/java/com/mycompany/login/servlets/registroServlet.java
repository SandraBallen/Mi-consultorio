/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.login.servlets;
import com.mycompany.login.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanba
 */
@WebServlet("/registro") //Comunica a Tomcat el ingreso al registro
public class registroServlet extends HttpServlet { //Creación de la clase registroServlet
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
    //Obtener los datos del formulario del HTML  
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
         String telefono = request.getParameter("telefono");
         String cedula = request.getParameter("cedula");
    
    //variables para la conexión con la BD
        Connection con = null; //nul ya que no hay conexión al inicio
        PreparedStatement ps = null;
        
        
    //Try - Catch para los posibles errores    
     try {
         con = Conexion.obtenerConexion();
         String sql = "INSERT INTO usuarios (nombre, email, password, rol, telefono, cedula) VALUES (?,?,?,?,?,?)";
         ps = con.prepareStatement(sql);
         
         ps.setString(1, nombre);
         ps.setString(2, email);
         ps.setString(3, password);
         ps.setString(4, rol);
         ps.setString(5, telefono);
         ps.setString(6, cedula);
         ps.executeUpdate();
         //Al terminar el registro se redirige a iniciar sesión
         response.sendRedirect("index.html?mensaje=registrado");

         
         //Mensaje de error en el registro
     } catch (SQLException e) {
         System.out.println("Error" + e.getMessage());
         response.getWriter().println("Error al registrar usuario" + e.getMessage());
     } finally {
         try {
             if (ps != null) ps.close();
             if (con != null) con.close();
         }catch (SQLException e) {
             System.out.println("Error al cerrar: " + e.getMessage());
    }
     }
    }
}
