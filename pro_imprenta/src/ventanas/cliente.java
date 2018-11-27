package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import conexiones.InsertarBD;

import java.awt.Font;

public class cliente extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textPrecioT;
	private JTextField textImporte;
	private JTextField textid;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cliente frame = new cliente();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public cliente() {
		setFrameIcon(null);
		setResizable(true);
		setTitle("Datos del cliente");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(32, 14, 62, 14);
		getContentPane().add(lblNombre);
		
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
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(10, 245, 46, 14);
		getContentPane().add(lblId);
		
		textid = new JTextField();
		textid.setBounds(66, 242, 86, 20);
		getContentPane().add(textid);
		textid.setColumns(10);
		

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertarBD.registrarcliente(Integer.parseInt(textid.getText()),textNombre.getText(),textDescripcion.getText() ,
						textPrecioT.getText(),textImporte.getText(),dateChooser.getDateFormatString());
			}
			
		});
		btnAgregar.setBounds(161, 205, 89, 23);
		getContentPane().add(btnAgregar);
		
		
	}
}
