package conexiones;

import static javax.swing.JOptionPane.showMessageDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.table.DefaultTableModel;
import ventanas.*;

public class ConsultarBD {
	public static Connection conexion=null;
	///vincular con la BD
	public static Statement s = null;
	//rs Es el result
	public static ResultSet rs=null; 


	public static Statement conectar(){
		try {
		//drive para hecer la conexion
			Class.forName("com.mysql.jdbc.Driver");
			//conexion ala base de datos el que esta en el comentario
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/imprenta?useSSL=false", Principal.usuario, Principal.contraseña);
			s = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	public static void RellenarTabla(String nomTabla, String buscar){
		DefaultTableModel tablaModelo= new DefaultTableModel();
		String []titulos;
		String []Datos;
		switch (nomTabla){
		case "proveedor":
			titulos= new String[]{"id_proveedor","nombre_proveedor ","no_serie","nombre_material ","cantidad_proveedor ","precio","fecha_compra "};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [5];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM proveedor WHERE id_proveedor LIKE '"+buscar+"'");
				while(rs.next())
				{
					Datos[0]=rs.getString("id_proveedor");//rs result set leer fila por fila dentro de una BD
					Datos[1]=rs.getString("nombre_proveedor");
					Datos[1]=rs.getString("no_serie");
					Datos[2]=rs.getString("nombre_material");
					Datos[3]=rs.getString("cantidad_proveedor");  
					Datos[3]=rs.getString("precio");  
					Datos[4]=rs.getString("fecha_compra");  
					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}break;	
		case "cliente":
			titulos= new String[]{"id_cliente ","nombre_cliente ","descripcion_material","precio_total ","importe","fecha_enterege"};
			tablaModelo.setColumnIdentifiers(titulos);
			Consultas.tabla.setModel(tablaModelo);
			Datos= new String [3];
			try {
				ResultSet rs= conectar().executeQuery("SELECT * FROM bitacora WHERE id LIKE '"+buscar+"'");
				while(rs.next())
				{
					Datos[0]=rs.getString("IdRevista");
					Datos[1]=rs.getString("NombreRevista");
					Datos[2]=rs.getString("descripcion_material");
					Datos[3]=rs.getString("precio_total");
					Datos[4]=rs.getString("importe");
					Datos[5]=rs.getString("fecha_enterege");
					
					tablaModelo.addRow(Datos);
				}
			} catch (SQLException ex) {
				showMessageDialog(null, ex);
			}
		}
	}public static void consultaTotal(String nomTabla){
	DefaultTableModel tablaModelo= new DefaultTableModel();
	String []titulos;
	String []Datos;
	switch (nomTabla){case "proveedor":
		titulos= new String[]{"id_proveedor","nombre_proveedor ","cantidad_proveedor ","nombre_material ","fecha_compra "};
		tablaModelo.setColumnIdentifiers(titulos);
		Consultas.tabla.setModel(tablaModelo);
		Datos= new String [5];
		try {
			ResultSet rs= conectar().executeQuery("SELECT * FROM proveedor");
			while(rs.next())
			{
				Datos[0]=rs.getString("id_proveedor");//rs result set leer fila por fila dentro de una BD
				Datos[1]=rs.getString("nombre_proveedor");
				Datos[2]=rs.getString("cantidad_proveedor");
				Datos[3]=rs.getString("nombre_material");  
				Datos[4]=rs.getString("fecha_compra");  
				tablaModelo.addRow(Datos);
			}
		} catch (SQLException ex) {
			showMessageDialog(null, ex);
		}break;	
	case "cliente":
		titulos= new String[]{"id_cliente ","nombre_cliente ","descripcion_material","precio_total ","importe","fecha_enterege"};
		tablaModelo.setColumnIdentifiers(titulos);
		Consultas.tabla.setModel(tablaModelo);
		Datos= new String [3];
		try {
			ResultSet rs= conectar().executeQuery("SELECT * FROM cliente");
			while(rs.next())
			{
				Datos[0]=rs.getString("IdRevista");
				Datos[1]=rs.getString("NombreRevista");
				Datos[2]=rs.getString("descripcion_material");
				Datos[3]=rs.getString("precio_total");
				Datos[4]=rs.getString("importe");
				Datos[5]=rs.getString("fecha_enterege");
				
				tablaModelo.addRow(Datos);
			}
		} catch (SQLException ex) {
			showMessageDialog(null, ex);
		}
	}
	
	}
	}