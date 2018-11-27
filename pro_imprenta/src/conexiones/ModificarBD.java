package conexiones;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JOptionPane;

import ventanas.ModificarCliente;
import ventanas.ModificarProveedor;
//import com.mysql.jdbc.ResultSetMetaData;
import ventanas.Principal;


public class ModificarBD {
	public static Connection conexion=null;
	public static Statement s = null;
	public static boolean bandera=true;
	public static ResultSet tipo=null;
	public static String mensaje="";

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



	
	public static void DatosExhibicion(String id, String nom, String inicio, String fin) {
		try {
			conectar().executeUpdate(
					"UPDATE exhibicion SET "
							+ " idExhib ='"+id+"', "
							+ " nomExhib ='"+nom+"',"
							+ " fecIni ='"+inicio+"',"
							+ " fecFin ='"+fin+"'"
							+ "WHERE idExhib ='"+id+"'");	

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algo a salido mal con los datos");
		} finally { 
			try {
				if (conexion != null) {
					conexion.close();
					JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				}
		}

	}

	public static void objetoArte(String id, String pais, String año, String titulo,
			String epoca, String descripcion, String estiloOBJ,
			String material, String altura, String peso, String desTipo) {
		try {
			conectar().executeUpdate(
					"UPDATE objetoarte SET "
							+ " idObjeto ='"+id+"', "
							+ " pais ='"+pais+"',"
							+ " año ='"+año+"',"
							+ " titulo ='"+titulo+"',"
							+ " epoca ='"+epoca+"',"
							+ " descripcion ='"+descripcion+"'"
							+ "WHERE idObjeto ='"+id+"'");	
			switch (desTipo){
			//pintura
			case "PINTURA":
				conectar().executeUpdate(
						"UPDATE pintura SET "
								+ " idObjeto ='"+id+"', "
								+ " tipo ='"+altura+"',"
								+ " estilo ='"+estiloOBJ+"',"
								+ " material ='"+material+"'"
								+ "WHERE idObjeto ='"+id+"'");
				break;
			case "OTRO":
				conectar().executeUpdate(
						"UPDATE otro SET "
								+ " idObjeto ='"+id+"', "
								+ " estilo ='"+estiloOBJ+"',"
								+ " tipo ='"+altura+"'"
								+ "WHERE idObjeto ='"+id+"'");
				break;
			case "ESCULTURA":
				conectar().executeUpdate(
						"UPDATE escultura SET "
								+ " idObjeto ='"+id+"',"
								+ " estilo ='"+estiloOBJ+"',"
								+ " altura ='"+altura+"',"
								+ " material ='"+material+"',"
								+ " peso = '"+peso+"'"
								+ "WHERE idObjeto ='"+id+"'");
				break;
			case "ESTATUA":
				conectar().executeUpdate(
						"UPDATE estatua SET "
								+ " idObjeto ='"+id+"', "
								+ " material ='"+material+"'"
								+ "WHERE idObjeto ='"+id+"'");
				break;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		} finally { 
			try {
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}JOptionPane.showMessageDialog(null, "Los datos se modificaro exitosamente");
		}

	}

	public static void registrarCliente(int id, String nombred, String descripcion,String precio, String importe, String fecha) {
		// TODO Auto-generated method stub

		try {
			conectar().executeUpdate(
					"UPDATE provedor SET "
							+ "IdDisco="+id+", "
							+ "NombreDisco='"+nombred+"',"
							+ "NumCopias='"+descripcion+"',"
							+ "NombreDisco='"+precio+"',"
							+ "NumCopias='"+importe+"',"
							+ "fecha='"+importe+"',"							
							+ "WHERE id_proveedor="+id+"");	
		} catch (SQLException e) {
			//bandera=false;
			JOptionPane.showMessageDialog(null, e);
		} finally { 
			try {
				if (conexion != null) {
					conexion.close();
					conexiones.ConsultarBD.consultaTotal("Discos");
					mensaje = (bandera=true) ? "Datos guardados correctamente":"Algo salio mal";
					JOptionPane.showMessageDialog(null, mensaje);
					
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}


	}
	
	//=====================================================================================================================


	public static void rellenarcliente(String id_proveedor) throws ParseException {
		ResultSet tipo = null;
		try {
			tipo = conectar().executeQuery("SELECT * FROM libro WHERE Id_Libro="+id_proveedor);

			while(tipo.next())
			{
				ModificarCliente.rellenarcliente(
				tipo.getString("id_proveedor"), 
				tipo.getString("nombre_cliente "), 
				tipo.getString("descripcion_material "),
				tipo.getString("precio_total"),
				tipo.getInt("importe"),
				tipo.getString("fec"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rellenarproveedor(String id_proveedor) throws ParseException {
		ResultSet tipo = null;
		try {
			tipo = conectar().executeQuery("SELECT * FROM proveedor WHERE Id_Libro="+id_proveedor);//procedimiento creado en la base de datos
			while(tipo.next())
			{
				ModificarProveedor.rellenarproveedor(
						tipo.getString("id_proveedor"), 
						tipo.getString("nombre_cliente "), 
						tipo.getString("descripcion_material "),
						tipo.getString("precio_total"),
						tipo.getInt("importe"),
						tipo.getString("fec"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public static void Registrarproveedor(String text, String text2, int parseInt, int parseInt2,
			String dateFormatString) {
		// TODO Auto-generated method stub
		
	}
}