package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4147798555455704344L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtContraseña;
	private JProgressBar barra;
	private int ss;
	private JLabel  lbMonos, lbIngresar;
	private boolean vanderilla;
 
	

	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				// seleccione Look and Feel 

				  JFrame.setDefaultLookAndFeelDecorated(true);
				  JDialog.setDefaultLookAndFeelDecorated(true);
				//NO  //UIManager.setLookAndFeel("com.SeaGlassLookAndFeel.siteskin");
				  //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				 // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
				  UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				  //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				  //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				  //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
				// iniciar la aplicación 
				//new Login();
			}			catch (Exception ex) {
				ex.printStackTrace ();
			}
			try {
				Login frame = new Login();
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
	public Login() {
		setTitle("Iniciar sesi\u00F3n");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/user.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 460, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		lblNombre.setBounds(47, 36, 84, 42);
		panel.add(lblNombre);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		lblContrasea.setBounds(47, 107, 112, 32);
		panel.add(lblContrasea);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNombre.setBounds(178, 44, 220, 32);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtContraseña.setBounds(178, 107, 220, 31);
		panel.add(txtContraseña);

		barra = new JProgressBar();
		barra.setEnabled(false);
		barra.setOpaque(true);
		barra.setStringPainted(true);
		barra.setBorderPainted(false);
		barra.setVisible(false);
		barra.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				barraStateChanged(evt);
			} 
		});
		barra.setForeground(Color.BLUE);
		barra.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 20));
		barra.setBackground(Color.WHITE);
		barra.setBounds(10, 209, 413, 42);
		panel.add(barra);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (txtNombre.getText()==null) {
					JOptionPane.showMessageDialog(null, "Usuario", "Usuario incorrecto", JOptionPane.WARNING_MESSAGE);
				}
				if(txtNombre.getText().equals("soluciones")) {
					if(txtContraseña.getText().equals("yury")){
						Principal.usuario=txtNombre.getText();
						Principal.contraseña=txtContraseña.getText();
						barra.setVisible(true);
						iniciarCarga();
						mostrarCarga();
						txtContraseña.setVisible(false);
						txtNombre.setVisible(false);
						lblContrasea.setVisible(false);
						lblNombre.setVisible(false);
						btnNewButton.setVisible(false);
						lbMonos.setVisible(false);
						lbIngresar.setVisible(true);
						vanderilla=true;	
					}
					else 
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Contraseña incorrectos", JOptionPane.WARNING_MESSAGE);
				}else 
				if(txtNombre.getText().equals("Invitado")) {
					if(txtContraseña.getText().equals("invitado")){
						Principal.usuario="Invitado";
						Principal.contraseña="invitado";
						barra.setVisible(true);
						iniciarCarga();
						mostrarCarga();
						txtContraseña.setVisible(false);
						txtNombre.setVisible(false);
						lblContrasea.setVisible(false);
						lblNombre.setVisible(false);
						btnNewButton.setVisible(false);
						lbMonos.setVisible(false);
						lbIngresar.setVisible(true);
						vanderilla=false;
					}
					else 
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario incorrecto", "Usuario incorrecto", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(198, 192, 112, 42);
		panel.add(btnNewButton);
				
				lbMonos = new JLabel("");
				lbMonos.setIcon(null);
				lbMonos.setHorizontalAlignment(SwingConstants.CENTER);
				lbMonos.setBounds(159, 0, 316, 211);
				panel.add(lbMonos);
				
						lbIngresar = new JLabel("");
						lbIngresar.setVisible(false);
						lbIngresar.setBounds(0, 0, 444, 211);
						panel.add(lbIngresar);
						lbIngresar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/logo.jpg")));
						lbIngresar.setHorizontalAlignment(SwingConstants.CENTER);

	}
	private void iniciarCarga() {
		new  Thread(){
			public void run() {
				int x=0;
				double y=0;
				while(x<=100 && y<=100){
					y+=0.20;
					x+=y;
					barra.setValue(x);
					try {
						sleep(104);
					} catch (Exception e) {

						e.printStackTrace();
					}
				}setSs(barra.getValue());
			}

		}.start();}


private void mostrarCarga() {
	progreso().setForeground(Color.BLUE);
}
public JProgressBar progreso(){
	return barra; 
}
private void barraStateChanged(ChangeEvent evt) {//GEN-FIRST:event_barraStateChanged
	if(barra.getValue()==100){
		for (double num=.0000001; num<=99; num=num+.0000001) {
		}
		Principal p=new Principal();
		p.setVisible(true);
		//AJUSTA EL TAMAÑO DEL FRAME AL TAMAÑO DE LA PANTALLA 
		p.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.dispose();
		Principal.mnPrincipal.setEnabled(vanderilla);
	}

	// TODO add your handling code here:
}

public int getSs() {
	return ss;
}

public void setSs(int ss) {
	this.ss = ss;
}
}
