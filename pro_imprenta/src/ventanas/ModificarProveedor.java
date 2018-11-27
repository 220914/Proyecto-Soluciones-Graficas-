package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


import conexiones.ModificarBD;
import java.awt.BorderLayout;

public class ModificarProveedor extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombreP;
	private JTextField textNmbreMat;
	private JTextField txtPrecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProveedor frame = new ModificarProveedor();
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
	public ModificarProveedor() {
		{setTitle("Actualizar registros proveedor");
		setMaximizable(false);
		setIconifiable(true);
		setClosable(true);

		setBounds(100, 100, 450, 300);
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 34, 78, 14);
		getContentPane().add(lblNombre);
		
		textNombreP = new JTextField();
		textNombreP.setBounds(92, 31, 266, 20);
		getContentPane().add(textNombreP);
		textNombreP.setColumns(10);
		
		JLabel lblNombrematerial = new JLabel("Material:");
		lblNombrematerial.setBounds(25, 74, 116, 14);
		getContentPane().add(lblNombrematerial);
		
		textNmbreMat = new JTextField();
		textNmbreMat.setBounds(92, 74, 193, 20);
		getContentPane().add(textNmbreMat);
		textNmbreMat.setColumns(10);
		
		JLabel lblCantidadQueSe = new JLabel("Cantidad que se compro:");
		lblCantidadQueSe.setBounds(25, 114, 146, 14);
		getContentPane().add(lblCantidadQueSe);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(25, 155, 52, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(69, 152, 72, 20);
		txtPrecio.setText("");
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(225, 155, 52, 14);
		getContentPane().add(lblFecha);
		
		JDateChooser dateCompra = new JDateChooser();
		dateCompra.setBounds(269, 152, 89, 20);
		getContentPane().add(dateCompra);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(166, 111, 41, 20);
		getContentPane().add(spinner);
		
		JButton button = new JButton("Actualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarBD.Registrarproveedor(textNombreP.getText(), textNmbreMat.getText(),Integer.parseInt(txtPrecio.getText()),Integer.parseInt(spinner.toString()),dateCompra.getDateFormatString());
			
			}	
		});
		button.setBounds(87, 210, 89, 23);
		getContentPane().add(button);
		
		}
		
		JButton btnActualizar = new JButton("Actualizar");
		getContentPane().add(btnActualizar, BorderLayout.SOUTH);
			
		}
	public static void rellenarproveedor(String id, String NomLibro, String Autor, String ISBN, int i, String string) {
			// TODO Auto-generated method stub
	
}
	}


