package LPProyecto;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class Inicio extends JFrame {

	private static final long serialVersionUID = -1515105495374550920L;
	private JPanel contentPane;
	private static final Logger log = Logger.getLogger(Inicio.class.getName());

	public Inicio() 
	{
		setTitle("Administrador de articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setExtendedState(6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameMenuPrincipal.class.getResource("/images/Sulli.png")));
		lblNewLabel.setBounds(0, 450, 256, 256);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon(JFrameMenuPrincipal.class.getResource("/images/Mike.png")));
		lblNewLabel1.setBounds(141, 578, 128, 128);
		contentPane.add(lblNewLabel1);
		
		JLabel lblNewLabel11 = new JLabel("");
		lblNewLabel11.setIcon(new ImageIcon(Inicio.class.getResource("/images/melendi.jpg")));
		lblNewLabel11.setBounds(285, 495, 200, 224);
		contentPane.add(lblNewLabel11);
		
		JLabel lblNewLabel111 = new JLabel("");
		lblNewLabel111.setIcon(new ImageIcon(Inicio.class.getResource("/images/Sabina.png")));
		lblNewLabel111.setBounds(495, 495, 222, 200);
		contentPane.add(lblNewLabel111);
	}

}
