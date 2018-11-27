package ventanas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import conexiones.InsertarBD;


import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.util.Date;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class proveedor extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNombreP;
	private JTextField textNmbreMat;
	private JTextField txtPrecio;
	private JTextField textNoSerie;
	private JTextField textid;
	private JTextField txtCantidad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proveedor frame = new proveedor();
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
	public proveedor() {
		setFrameIcon(null);
		setTitle("Datos del proveedor");
		setClosable(true);
		setIconifiable(true);
		setResizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 49, 78, 14);
		getContentPane().add(lblNombre);
		
		textNombreP = new JTextField();
		textNombreP.setBounds(114, 46, 266, 20);
		getContentPane().add(textNombreP);
		textNombreP.setColumns(10);
		
		JLabel lblNombrematerial = new JLabel("Material:");
		lblNombrematerial.setBounds(22, 74, 57, 14);
		getContentPane().add(lblNombrematerial);
		
		textNmbreMat = new JTextField();
		textNmbreMat.setBounds(114, 71, 193, 20);
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
		
		JDateChooser fechaCompra = new JDateChooser();
		fechaCompra.setBounds(269, 152, 89, 20);
		getContentPane().add(fechaCompra);
		JLabel lblId = new JLabel("id");
		lblId.setBounds(10, 245, 46, 14);
		getContentPane().add(lblId);
		
		textid = new JTextField();
		textid.setBounds(66, 242, 86, 20);
		getContentPane().add(textid);
		textid.setColumns(10);
		

		
		JButton button = new JButton("Agregar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
													//call putDatos('juan','1978/11/22', '12p',					'vinil blue',			12,							112,					(SELECT @@identity));
			//	InsertarBD.RegistrarProveedor(textNombreP.getText(), fechaCompra.getDateFormatString(),textNoSerie.getText(),textNmbreMat.getText(),contador.getComponentCount(),Integer.parseInt(txtPrecio.getText()));
				InsertarBD.RegistrarProveedor(Integer.parseInt(textid.getText()),textNombreP.getText(),
						textNoSerie.getText(),textNmbreMat.getText(),
						txtCantidad.getText(),txtPrecio.getText(),
						fechaCompra.getDateFormatString());
			
			}	
		});
		button.setBounds(196, 203, 89, 23);
		getContentPane().add(button);
		
		JLabel lblNo_serie = new JLabel("No. serie");
		lblNo_serie.setBounds(22, 24, 57, 14);
		getContentPane().add(lblNo_serie);
		
		textNoSerie = new JTextField();
		textNoSerie.setBounds(114, 15, 86, 20);
		getContentPane().add(textNoSerie);
		textNoSerie.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(144, 111, 86, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		
	}
}
