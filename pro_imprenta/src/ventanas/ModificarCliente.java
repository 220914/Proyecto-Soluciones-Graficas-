package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import conexiones.InsertarBD;
import conexiones.ModificarBD;
import net.miginfocom.swing.MigLayout;

public class ModificarCliente extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textPrecioT;
	private JTextField textImporte;
	private JTextField textid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCliente frame = new ModificarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarCliente() {
		setBounds(100, 100, 450, 300);
		setTitle("Actualizar registros");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombre:");
		lblNombres.setBounds(32, 14, 62, 14);
		getContentPane().add(lblNombres);
		
		JLabel lblDescripcinDelMaterial = new JLabel("Descripci\u00F3n del material a utilizar:");
		lblDescripcinDelMaterial.setBounds(32, 39, 192, 14);
		getContentPane().add(lblDescripcinDelMaterial);
		
		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(42, 133, 79, 14);
		getContentPane().add(lblPrecioTotal);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(155, 133, 69, 14);
		getContentPane().add(lblImporte);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega:");
		lblFechaDeEntrega.setBounds(257, 133, 106, 14);
		getContentPane().add(lblFechaDeEntrega);
		
		textNombre = new JTextField();
		textNombre.setBounds(104, 11, 259, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textPrecioT = new JTextField();
		textPrecioT.setBounds(32, 158, 86, 20);
		getContentPane().add(textPrecioT);
		textPrecioT.setColumns(10);
		
		textImporte = new JTextField();
		textImporte.setBounds(138, 158, 86, 20);
		getContentPane().add(textImporte);
		textImporte.setColumns(10);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(257, 158, 96, 20);
		getContentPane().add(dateChooser);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDescripcion.setBounds(32, 64, 331, 58);
		getContentPane().add(textDescripcion);
		
	
		JButton btnAgregar = new JButton("actualizar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*InsertarBD.registrarcliente(Integer.parseInt(textid.getName()),textNombre.getText(), 
						textPrecioT.getText(),textImporte.getText(),textDescripcion.getText(),
						dateChooser.getDateFormatString());*/
				
				/*ModificarBD.rellenarcliente(Integer.parseInt(textid.getName()),textNombre.getText(),textDescripcion.getText() ,
						textPrecioT.getText(),textImporte.getText(),
						dateChooser.getDateFormatString());*/
			}	
		});
		btnAgregar.setBounds(447, 7, 79, 23);
		getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarBD.registrarCliente(Integer.parseInt(textid.getText()),textNombre.getText(),textDescripcion.getText() ,
						textPrecioT.getText(),textImporte.getText(),dateChooser.getDateFormatString());
			}
		});
		btnActualizar.setBounds(157, 209, 89, 23);
		getContentPane().add(btnActualizar);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(10, 245, 46, 14);
		getContentPane().add(lblId);
		
		textid = new JTextField();
		textid.setBounds(66, 242, 86, 20);
		getContentPane().add(textid);
		textid.setColumns(10);

}

public static void rellenarcliente(String id, String NomLibro, String Autor, String ISBN, int i, String string) {
	// TODO Auto-generated method stub
	
}
}

