package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import ventanas.Principal;


public class EliminarBD {
	public static Connection conexion=null;
	public static Statement s = null;


	public static Statement conectar(){
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Se obtiene una conexión con la base de datos.
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/imprenta?useSSL=false", Principal.usuario, Principal.contraseña);
			// Se crea un Statement, para realizar el query
			s = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	public static void eliminarDatos(String tabla, String buscar) {
		switch (tabla){
		case "proveedor":
			try {
				conectar().executeUpdate("DELETE FROM objetoarte WHERE idObjeto = '"+buscar+"'");
				JOptionPane.showMessageDialog(null, "Los datos se borraron correctamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "cliente":
			try {
				conectar().executeUpdate("DELETE FROM Exhibicion WHERE idExhib = '"+buscar+"'");
				JOptionPane.showMessageDialog(null, "Los datos se borraron correctamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
}
