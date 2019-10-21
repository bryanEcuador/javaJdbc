/**
 * 
 */
package com.bs.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bs.controlador.Usuario;

/**
 * @author bryan
 *
 */
public class IntroduccionJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int opcion = 0;
		Scanner reader = new Scanner(System.in);
		
		
		
		 
		
		do {
			System.out.println("Bienvenido al sistema de registro de usuarios");
			System.out.println("1. Ver usuarios registrados");
			System.out.println("2. Crear nuevo usuario");
			System.out.println("3. Actualizar usuario");
			System.out.println("4. Eliminar usuario ");
			System.out.println("5. Salir");
			System.out.println("\n Ingrese su opción:");
			
			 opcion = reader.nextInt();
			
			switch(opcion) {
			 case 1 :
					System.out.println("**Lista de usuarios**");
					Usuario.selectUsuario();
					System.out.println("");
			 break;	
			 case 2 :
					System.out.println("**Crear usuario**");
					Usuario.crearUsuario();
			 break;	
			 case 3 :
					System.out.println("**Actualizar usuario**");
					Usuario.updateUsuario();
			 break;	
			 case 4 :
					System.out.println("**Eliminar usuario**");
					System.out.println("Ingrese el id del usuario a eliminar: ");
					int id = opcion = reader.nextInt();
					Usuario.eliminarUsuario(id);
			 break;	
			 case 5 :
					opcion = 9;
			 break;	
			 default :
				 System.out.println("Opcion invalida");
			 break;	 
			}
			
		}while(opcion != 9);

	}

}
