package LPProyecto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import LNProyecto.ClsBloqueo;
import LNProyecto.ClsUnificadorDClases;

import java.awt.Color;

//Menu donde se pedirá la contraseña
public class JFramePedirContra extends JFrame implements ActionListener{

	private static final long serialVersionUID = 7512657161608326625L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnVerificar;
	private JLabel lblFaltan;
	private ClsUnificadorDClases Gestor;
	private JButton btnVolver;
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
		lblFaltan.setBounds(82, 110, 257, 14);
		contentPane.add(lblFaltan);
		
		btnVolver = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		btnVolver.setBounds(10, 205, 59, 57);
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		Gestor = new ClsUnificadorDClases();
		
		new ClsBloqueo();
	}
	
	
	
	public void actionPerformed(ActionEvent e) 
	{	
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == btnVolver)
		{
			JFrameMenuPrincipal objPrin = new JFrameMenuPrincipal();
			objPrin.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == btnVerificar)
		{			
			int semaforo = 0;
			int candado = 0;
			//Gestion de bloqueos
			if(Gestor.intentosBloqueo()>=3)
			{
				semaforo = Gestor.semaforoBloqueo();
			}
			
			if (semaforo==0)
			{
				candado = 1;
				
				Gestor.sumarIntento();
				String contrasena1 = Gestor.leerContra();
				char[] contraescrita = passwordField.getPassword();
				
				if (contrasena1.equals(String.valueOf(contraescrita)))
				{
					Gestor.reiniciarIntentos();			
					JFrameMenuAdministrador objMenuAdministrador = new JFrameMenuAdministrador();
					objMenuAdministrador.setVisible(true);
					this.dispose();
				}
				else
				{
					lblFaltan.setText("                  Error en la contrasena");
					setContentPane(contentPane);
				    contentPane.validate();
				    contentPane.repaint();
										
					if(candado==1)
					{
						Gestor.sacarMinutos();
					}
						
					if(Gestor.getIntentos()>=3)
					{
						lblFaltan.setText("Espere " + (Gestor.getIntentos())  + " minuto(s) para poder acceder");
						setContentPane(contentPane);
					    contentPane.validate();
					    contentPane.repaint();
					}	
				}
					
				if(candado==1)
				{
					Gestor.sacarMinutos();
				}
			}
			else
			{
				long falta = Gestor.sacarFalta();
				if (falta<0)
				{
					TimerTask timerTask = new TimerTask()
				     {
						ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
				         public void run() 
				         {
				        	lblFaltan.setText("Falta(n) " + (-Gestor.sacarFalta()) + " segundo(s) para poder acceder");
			        		
							setContentPane(contentPane);
							contentPane.validate();
							contentPane.repaint();
				         }
				     };
				      // Aqun se pone en marcha el timer cada segundo.
				     Timer timer = new Timer();
				     // Dentro de 0 milisegundos avnsame cada 1000 milisegundos
				     timer.scheduleAtFixedRate(timerTask, 0, 1000); 
				}
				else
				{
					lblFaltan.setText(null);
					
					setContentPane(contentPane);
				    contentPane.validate();
				    contentPane.repaint();
				}
			}
		}
	}
}
