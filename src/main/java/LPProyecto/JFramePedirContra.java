package LPProyecto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LDProyecto.BaseDatos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import org.apache.log4j.Logger;

import java.awt.Color;

//Menu donde se pedir� la contrase�a
public class JFramePedirContra extends JFrame implements ActionListener{

	private static final long serialVersionUID = 7512657161608326625L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnVerificar;
	private JLabel lblFaltan;
	private JButton btnVolver;
	private int intento = 0;
	private long milisegs = 0;
	private static final Logger log = Logger.getLogger(JFramePedirContra.class.getName());
	public JFramePedirContra() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 104, 233, 39);
		contentPane.add(passwordField);
		
		JLabel lblInserteLaContrasea = new JLabel("Inserte la contrase\u00F1a");
		lblInserteLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInserteLaContrasea.setBounds(91, 40, 233, 59);
		contentPane.add(lblInserteLaContrasea);
		
		btnVerificar = new JButton(new ImageIcon(getClass().getResource("/images/verify.png")));
		btnVerificar.setBounds(170, 154, 64, 64);
		btnVerificar.setOpaque(false);
		btnVerificar.setContentAreaFilled(false);
		btnVerificar.setBorderPainted(false);
		btnVerificar.addActionListener(this);
		contentPane.add(btnVerificar);
		
		lblFaltan = new JLabel();
		lblFaltan.setForeground(Color.RED);
		lblFaltan.setBounds(82, 30, 257, 14);
		contentPane.add(lblFaltan);
		
		btnVolver = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		btnVolver.setBounds(10, 205, 59, 57);
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		BaseDatos.initBD("eLibrary.db");
		BaseDatos.crearTablaBDB();
		try 
		{
			BaseDatos.devolverBloqueo();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}		
		intento = BaseDatos.getIntentos();
		System.out.println("Intento: " + intento);
		milisegs = BaseDatos.getMilisegundos();
		System.out.println("Milis: " + milisegs);
		System.out.println("---------------------");
		if (intento == 0)
		{
			try 
			{
				BaseDatos.crearBloqueo(BaseDatos.getStatement());
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		BaseDatos.close();
		
		
		if(intento >= 4)
		{
			long diferencia = (milisegs - System.currentTimeMillis())/1000;
			if(0 >= diferencia)
			{
				lblFaltan.setText("Ya puede introducir la contrase�a");
			}
			else
			{
				lblFaltan.setText("Espere " + diferencia  + " segundo(s) para poder acceder");
			}
			
		}
		
		contentPane.add(lblFaltan);
	}
	
	
	
	public void actionPerformed(ActionEvent e) 
	{	
		//accedemos a la base de datos cuando el administrador haga el login
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == btnVolver)
		{
			JFrameMenuPrincipal objPrin = new JFrameMenuPrincipal();
			objPrin.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == btnVerificar)
		{	
			if(milisegs < System.currentTimeMillis())
			{
				BaseDatos.initBD("eLibrary.db");
	
				BaseDatos.crearTablaBDU();
				
				String savedContra = "";
				
				try 
				{
					BaseDatos.devolverContra();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				
				savedContra = BaseDatos.getContra();
				BaseDatos.close();
				
				if(savedContra.equals("")) {savedContra="a";}
				
				String writtenContra = new String(passwordField.getPassword());
				Boolean comparation = false;
				
				
				if(writtenContra.equals(savedContra)) {comparation = true;}
				
				System.out.println("Written: " + writtenContra + "\n" + "Saved: " + savedContra + "\n" + "Comparation: " + comparation);
				
				if(comparation==true)
				{
					BaseDatos.initBD("eLibrary.db");
					BaseDatos.eliminarTablaBDB();
					BaseDatos.close();
					JFrameMenuAdministrador objMenuAdministrador = new JFrameMenuAdministrador();
					objMenuAdministrador.setVisible(true);
					this.dispose();
				}
				else
				{
					BaseDatos.initBD("eLibrary.db");
					log.warn("Mensaje de aviso: Contrase�a erronea");
					if(4 < intento) { BaseDatos.eliminarTablaBDB();}
					BaseDatos.crearTablaBDB();
					try 
					{
						BaseDatos.updateBloqueo(BaseDatos.getStatement());
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					BaseDatos.close();
					JOptionPane.showMessageDialog(null, "Contrase�a Erronea");
					
					JFramePedirContra objPedirContra = new JFramePedirContra();
					objPedirContra.setVisible(true);				
					this.dispose();
				}
			}
			else
			{
					JOptionPane.showMessageDialog(null, "Espera a que pase el bloqueo");
					
					JFramePedirContra objPedirContra = new JFramePedirContra();
					objPedirContra.setVisible(true);				
					this.dispose();
			}	
		}
	}
}
