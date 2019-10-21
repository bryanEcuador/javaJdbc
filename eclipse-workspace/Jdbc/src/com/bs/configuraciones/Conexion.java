package com.bs.configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	static Statement instruccion = null;
	static Connection conexion  = null;
	public static Statement conexion() {
		String url = "jdbc:mysql://localhost:33066/java?useSSL=false&serverTimezone=UTC";
		
	    try {
	        //Paso 2. Creamos el objeto de conexion a la base de datos
	        conexion = DriverManager.getConnection(url, "root", "");
	        //Paso 3. Creamos un objeto Statement
	         instruccion = conexion.createStatement();
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace(System.out);
	    }
	    
	    return instruccion;
	}
	
	public static void close () {
		try {
			instruccion.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
       
	}
	
	

}
