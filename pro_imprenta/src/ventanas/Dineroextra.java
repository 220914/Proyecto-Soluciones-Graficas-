package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexiones.InsertarBD;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Dineroextra extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dineroextra frame = new Dineroextra();
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
	public Dineroextra() {
		setClosable(true);
		
		setTitle("Dinero extra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertarCantidad = new JLabel("Insertar cantidad:");
		lblInsertarCantidad.setBounds(27, 45, 100, 14);
		contentPane.add(lblInsertarCantidad);
		
		textField = new JTextField();
		textField.setBounds(137, 42, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del dep\u00F3sito:");
		lblDescripcin.setBounds(27, 87, 145, 14);
		contentPane.add(lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textArea.setBounds(27, 112, 331, 34);
		contentPane.add(textArea);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertarBD.RegistrarDineroExtra();
			}
		});
		btnRegistrar.setBounds(154, 157, 89, 23);
		contentPane.add(btnRegistrar);
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Ingresar", "Retiro"}));
		cbTipo.setBounds(137, 9, 86, 22);
		contentPane.add(cbTipo);
		
		JLabel lblTipoDeTransaccin = new JLabel("tipo de transacci\u00F3n");
		lblTipoDeTransaccin.setBounds(27, 13, 100, 14);
		contentPane.add(lblTipoDeTransaccin);
	}
}
