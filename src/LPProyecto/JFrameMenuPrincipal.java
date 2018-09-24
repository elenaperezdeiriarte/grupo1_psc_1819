package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import LDProyecto.ClsDatos;
import LNProyecto.ClsBloqueo;
import LNProyecto.ClsConstantes.enFicDatos;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class JFrameMenuPrincipal extends JFrame implements ActionListener 
{
	
	private static final long serialVersionUID = 3665870126631298732L;
	private JPanel contentPane;
	private JButton btnAdmin;
	private JButton btnClien;
	private JButton btnSalir;
	private ClsBloqueo bloqueo;
	private ClsDatos datos;

	
	public JFrameMenuPrincipal() {
		
		
		bloqueo = new ClsBloqueo();
		this.datos = new ClsDatos();
		enFicDatos constantebloq = enFicDatos.FICHERO_DATOS_BLOQUEO;
		
		datos.ComenzarSave(constantebloq); 	
		datos.Save((Serializable) bloqueo); 						
		datos.TerminarSave();
		
		setTitle("Administrador de articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setExtendedState(6);
		
		btnAdmin = new JButton("Administrador");
		btnAdmin.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		btnAdmin.setBounds(121, 109, 450, 209);
		btnAdmin.addActionListener(this);
		contentPane.add(btnAdmin);
		
		btnClien = new JButton("Cliente");
		btnClien.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		btnClien.setBounds(790, 109, 458, 206);
		btnClien.addActionListener(this);
		contentPane.add(btnClien);
		
		btnSalir = new JButton(new ImageIcon(getClass().getResource("/images/exit.png")));
		btnSalir.setBounds(598, 456, 128, 128);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
	
			JButton botonPulsado = (JButton)e.getSource();
			
			if (botonPulsado == btnAdmin)
			{
				JFramePedirContra objPedirContra = new JFramePedirContra();
				objPedirContra.setVisible(true);
				
				this.dispose();
				
			}
			if (botonPulsado == btnClien)
			{
				JFrameMenuCliente objCliente = new JFrameMenuCliente();
				
				objCliente.setVisible(true);
				
				this.dispose();
			}
			if (botonPulsado == btnSalir)
			{				this.dispose();
			}
		}
}
