package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;


import ventanas.Principal;

public class InsertarBD {
	public static Connection conexion=null;
	public static Statement s = null;
	public static ResultSet rs=null;


	public static Statement conectar(){
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Se obtiene una conexión con la base de datos.
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/imprenta?useSSL=false", Principal.usuario,Principal.contraseña);
			// Se crea un Statement, para realizar el query
			s = conexion.createStatement();
			conexion.setAutoCommit(false);
		} catch (SQLException e) {
			//no conecta, o la consulta esta mal
			JOptionPane.showMessageDialog(null, "Soy un error algo a salido mal"+e);
		} catch (ClassNotFoundException e) {
			//ecepcion de driver
			JOptionPane.showMessageDialog(null, "Soy un error algo a salido mal"+e);
		}
		return s;
	}
	
	
public static void registrarcliente ( int idcliente,String nombreCliente ,String DescripcionMaterial  , 
		String PrecioTotal ,String Importe, String FechaEntrega) {
	try {
		conectar().executeUpdate("insert into clientes values("+idcliente+",'"+nombreCliente+"',"
				+ "'"+DescripcionMaterial+"','"+PrecioTotal+"','"+Importe+"','"+FechaEntrega+"')");
		
		int ax = JOptionPane.showConfirmDialog(null, "Quieres guardar los cambios para continuar?");
        if(ax == JOptionPane.YES_OPTION) {
        	JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
			conexion.commit();
			
        }
        else if(ax == JOptionPane.NO_OPTION) {
        	JOptionPane.showMessageDialog(null, "Transaccion cancelada");
			conexion.rollback();
        }
	}
	catch(Exception e) {
		
	}
	finally{
		try {
			if(conexion !=null) {
				conexion.close();
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "No podemos guardar los datos en la BD");
		}
	}
}

										//call putDatos('juan','1978/11/22', '12p','vinil blue',12,112,(SELECT @@identity));

public static void RegistrarProveedor(int id,String NombreP,
		 String NoSerie,String NombreMat,String CantidadCompra,String precio, String fecha ) {
	try {
		conectar().executeUpdate("insert into proveedor values ("+id+",'"+NombreP+"','"+NoSerie+"','"+NombreMat+"','"+CantidadCompra+"','"+precio+"','"+fecha+"')");
		
		int ax = JOptionPane.showConfirmDialog(null, "Quieres guardar los cambios para continuar?");
        if(ax == JOptionPane.YES_OPTION) 
        {
        	JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
			conexion.commit();
			
        }
        else if(ax == JOptionPane.NO_OPTION) {
        	JOptionPane.showMessageDialog(null, "Transaccion cancelada");
			conexion.rollback();
        }
	}
	catch(Exception e) {
		
	}
	finally{
		try {
			if(conexion !=null) {
				conexion.close();
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "No podemos guardar los datos en la BD");
		}
	}
}


public static void RegistrarDineroExtra() {
	// TODO Auto-generated method stub
	
}


}