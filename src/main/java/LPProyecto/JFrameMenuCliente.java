package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import org.apache.log4j.Logger;

public class JFrameMenuCliente extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -3984191500257201350L;
	private PanelConImagen contentPane1;
	private JButton btnVerArticulos;
	private JButton btnQueja;
	private JButton btnEstadisticas;
	private JButton btnSugerencia;
	private JButton jbVolver;
	private static final Logger log = Logger.getLogger(JFrameMenuCliente.class.getName());

	public JFrameMenuCliente() 
	{
		//Diseñar ventana cliente.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane1 = new PanelConImagen();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		contentPane1.setBackgroundImage(contentPane1.createImage("/images/cliente.jpg").getImage());
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		jbVolver = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		jbVolver.setBounds(10, 203, 48, 48);
		jbVolver.setOpaque(false);
		jbVolver.setContentAreaFilled(false);
		jbVolver.setBorderPainted(false);
		jbVolver.addActionListener(this);
		contentPane1.add(jbVolver);
		
		btnVerArticulos = new JButton("Ver Articulos");
		btnVerArticulos.setBounds(47, 145, 145, 30);
		contentPane1.add(btnVerArticulos);
		btnVerArticulos.addActionListener(this);
		
		btnEstadisticas = new JButton("Ver Estad\u00EDsticas");
		btnEstadisticas.setBounds(263, 145, 145, 30);
		btnEstadisticas.setToolTipText("");
		contentPane1.add(btnEstadisticas);
		btnEstadisticas.addActionListener(this);
		
		btnQueja = new JButton("Enviar Queja");
		btnQueja.setBounds(47, 32, 145, 30);
		contentPane1.add(btnQueja);
		btnQueja.addActionListener(this);
		
		btnSugerencia = new JButton("Sugerir Articulo");
		btnSugerencia.setBounds(263, 32, 145, 30);
		contentPane1.add(btnSugerencia);
		btnSugerencia.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton botonPulsado = (JButton)e.getSource();
		
		
		if (botonPulsado == btnVerArticulos)
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(0,"",0,1);
			objVerArticulos.setVisible(true);
			
			this.dispose();
		}
		
		if (botonPulsado == btnEstadisticas)
		{
			JFrameEstadisticas objEstadisticas = new JFrameEstadisticas(0);
			objEstadisticas.setVisible(true);
			
			this.dispose();
		}
		
		if (botonPulsado == jbVolver)
		{
			JFrameMenuPrincipal objPrincipal = new JFrameMenuPrincipal();
			objPrincipal.setVisible(true);
			
			this.dispose();
		}
		
		if (botonPulsado == btnSugerencia)
		{
			JFrameSugerencia objSugerencia= new JFrameSugerencia();
			objSugerencia.setVisible(true);
			
			this.dispose();
		}
		
		if (botonPulsado == btnQueja)
		{
			JFrameQueja objQueja= new JFrameQueja();
			objQueja.setVisible(true);
			
			this.dispose();
		}
		
	}

}
