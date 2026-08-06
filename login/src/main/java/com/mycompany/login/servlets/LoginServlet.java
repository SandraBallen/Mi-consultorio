/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.login.servlets;
import com.mycompany.login.Conexion; //importa la clase conexion creada para la conectar a la BD
import java.io.IOException;
import java.sql.Connection;
//para realizar consultas y obtener resultados
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet("/login") 
public class LoginServlet extends HttpServlet { //creación de la clase LoginServlet
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //leyendo los datos para el login
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //crear las variables para la conexión
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try { //try - catch para los posibles errores
            con = Conexion.obtenerConexion();
            String sql = "SELECT * FROM usuarios WHERE email = ? AND password = ?";
            
            ps = con.prepareStatement(sql); //los parámetros para la consulta
            ps.setString(1, email);
            ps.setString(2, password);
            
            rs = ps.executeQuery(); 
        
        if (rs.next()) { //si la autenticación es correcta entonces redirigir a gestión de citas
          response.sendRedirect("citas.html");
        } else { //sino mensaje de error
            System.out.println("Datos erroneos");
            response.sendRedirect("index.html?error=1");
        }
    } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            response.sendRedirect("index.html?error=1");
} finally {
     try {//cerrar el resultSet, el preparedStatement y la conexión
    if (rs != null) rs.close();
    if (ps != null) ps.close();
    if (con != null) con.close();
} catch (SQLException e) {
    System.out.println("Error al cerrar conexión" + e.getMessage());
}
}
}
}


