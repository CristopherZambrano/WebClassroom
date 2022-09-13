/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Crisito
 */
public class Conection implements Serializable {
    public Connection connection;
    private Statement statement;
    private ResultSet result;
    private boolean estado;
    private String mensaje;
    private boolean transaccionIniciada;

    //Credenciales para la conexion
    private String url = "ec2-44-198-82-71.compute-1.amazonaws.com";
    private String usuario = "qqfnihspryfsnd";
    private String clave = "ca9339a8a29c364b4576a67b2312e21d5c519cf66cb1782aa743a600188d48ab";
    private String classForName = "org.postgresql.Driver";

    public Conection() {
        
    }
    
    public boolean conectar() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, usuario, clave);
                statement = connection.createStatement();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("No hay conexion a la base de datos: " + e.getMessage());
        }
        return false;
    }


   //  MÉTODO DESCONECTAR PARA CERRAR UNA CONEXIÓN A LA BASE DE DATOS
    public boolean desconectar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                statement.close();
                return true;
            } else {
                System.out.println("No hay una conexion para desconectar");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al desconectar la conexion");
        }
        return false;
    }

    //  EJECUTAR CONSULTAS SQL
    public ResultSet ejecutarSql(String sql) {
        try {
            conectar();
            result = statement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error: No se ejecuto la consulta: " + ex.getMessage());
        } 
        return result;
    }
}
