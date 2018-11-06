package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.apache.log4j.Logger;

import LNProyecto.ClsContrasena;
import LNProyecto.ClsUnificadorDClases;

import java.awt.Color;

public class JFrameCambiarContrasena extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JTextField txtFieldContrasena1;
	private JTextField textFieldContrasena2;
	private JLabel lblAmbasContraseasNo;
	private JButton jbGuardar;
	private JButton jbVolver;
	private static final Logger log = Logger.getLogger(JFrameCambiarContrasena.class.getName());
	
	public JFrameCambiarContrasena()  
	
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		contentPane.setBackgroundImage(contentPane.createImage("/images/administrador.png").getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFieldContrasena1 = new JTextField();
		txtFieldContrasena1.setBounds(263, 41, 143, 26);
		contentPane.add(txtFieldContrasena1);
		txtFieldContrasena1.setColumns(10);
		
		JLabel lblEscribaLaNueva = new JLabel("Escriba la nueva contrase\u00F1a");
		lblEscribaLaNueva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEscribaLaNueva.setBounds(229, 11, 195, 26);
		contentPane.add(lblEscribaLaNueva);
		
		jbGuardar = new JButton(new ImageIcon(getClass().getResource("/images/save.png")));
		jbGuardar.setBounds(304, 136, 64, 64);
		jbGuardar.setOpaque(false);
		jbGuardar.setContentAreaFilled(false);
		jbGuardar.setBorderPainted(false);
		jbGuardar.addActionListener(this);
		contentPane.add(jbGuardar);
		
		jbVolver = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		jbVolver.setBounds(0, 214, 48, 48);
		jbVolver.setOpaque(false);
		jbVolver.setContentAreaFilled(false);
		jbVolver.setBorderPainted(false);
		jbVolver.addActionListener(this);
		contentPane.add(jbVolver);
		
		JLabel lblRepitaLaNueva = new JLabel("Repita la nueva contrase\u00F1a");
		lblRepitaLaNueva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRepitaLaNueva.setBounds(229, 69, 195, 26);
		contentPane.add(lblRepitaLaNueva);
		
		textFieldContrasena2 = new JTextField();
		textFieldContrasena2.setColumns(10);
		textFieldContrasena2.setBounds(263, 102, 143, 26);
		contentPane.add(textFieldContrasena2);
		
	}

	public void actionPerformed(ActionEvent d) 
	{
		
		JButton botonPulsado = (JButton)d.getSource();
		
		if (botonPulsado == jbGuardar)
		{			
			String nuevacontr1 = txtFieldContrasena1.getText();
			String nuevacontr2 = textFieldContrasena2.getText();
			
			if (nuevacontr1.equals(nuevacontr2))
			{				
				ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
				Gestor.guardarContra(new ClsContrasena(nuevacontr1));				
				JFramePedirContra objPedirContra = new JFramePedirContra();
				objPedirContra.setVisible(true);
				
				this.dispose();
			}
			else
			{
				lblAmbasContraseasNo = new JLabel("Ambas contrase\u00F1as no coinciden");
				lblAmbasContraseasNo.setForeground(Color.RED);
				lblAmbasContraseasNo.setBounds(267, 237, 167, 14);
				contentPane.add(lblAmbasContraseasNo);
				
				setContentPane(contentPane);
			    contentPane.validate();
			    contentPane.repaint();
			    log.error("Contraseña erronea");
			    
			}
		}
		if (botonPulsado == jbVolver)
		{
			JFrameMenuAdministrador objMenuAdministrador = new JFrameMenuAdministrador();
			objMenuAdministrador.setVisible(true);
			this.dispose();
		}
	}
}
