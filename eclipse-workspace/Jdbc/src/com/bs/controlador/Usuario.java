package com.bs.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bs.configuraciones.Conexion;

public class Usuario {
	
	private static int id;
	private String nombre;
	private String password;
	private int contador = 0; 
	
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
		Usuario.id = ++contador;
	}
	
	public static void selectUsuario() {
		
		Statement instruccion = Conexion.conexion();
		String sql = "Select * from usuario";
		try {
			ResultSet resultado = instruccion.executeQuery(sql);
			while(resultado.next()) {
				System.out.print("Id usuario :" + resultado.getInt(1));
				System.out.println("  Nombre de usuario :" + resultado.getString(2));
			}
			resultado.close();
			Conexion.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
	
	public static void crearUsuario() {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Ingresar nombre:");
		 String nombre = reader.nextLine();
		System.out.println("Ingresar contraseña:");
		String contraseña = reader.nextLine();
		Statement comando = Conexion.conexion();
		try {
			comando.executeUpdate("insert into usuario(nombre,password) values ('"+nombre+"','"+contraseña+"')");
	//		comando.executeUpdate("insert into usuario(nombre,password) values ('nombre','contraseña')");

			Conexion.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	public static void eliminarUsuario(int id) {
		// verificar que el id exista
		
		// eliminar id
		Statement instruccion = Conexion.conexion();
		String sql = "delete from usuario where id ="+id+"";
		try {
			 instruccion.execute(sql);
			 System.out.println("Registro eliminado con exito");
			Conexion.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	public static void updateUsuario() {
		Scanner reader = new Scanner(System.in);
		Scanner reader2 = new Scanner(System.in);
		
		System.out.println("Ingresar el id del usuario:");
		 int id = reader2.nextInt();
		 System.out.println("Ingresar nombre:");
		 String nombre = reader.nextLine();
		System.out.println("Ingresar contraseña:");
		String contraseña = reader.nextLine();
		Statement comando = Conexion.conexion();
		try {
			comando.executeUpdate("update usuario set nombre = '"+nombre+"'  , password = '"+contraseña+"' where id = '"+id+"' ");
			
			System.out.println("Usuario actualizado con exito.");
			comando.close();
			Conexion.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

}
