package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import LDProyecto.BaseDatos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import LNProyecto.ClsCD;
import LNProyecto.ClsDVD;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.MiExcepcion;

public class JFrameCFDVD extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private PanelConImagen contentPane;
	private JTextField txtNomDVD;
	private JTextField txtDuracionDVD;
	private JTextField txtOscarDVD;
	private JTextField txtAutorDVD;
	private JTextField txtAnoDVD;
	private int saberSiBusc;
	private int ordenacion;
	private String busqueda;
	private JButton jbGuardar;
	private JButton jbVolver;

	public JFrameCFDVD(int saberSiBusc, int ordenacion, String busqueda) 
	{
		
		this.saberSiBusc = saberSiBusc;
		this.ordenacion = ordenacion;
		this.busqueda = busqueda;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 352);
		contentPane = new PanelConImagen();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameMenuPrincipal.class.getResource("/images/DVD.png")));
		lblNewLabel.setBounds(40, 47, 128, 128);
		contentPane.add(lblNewLabel);
		
		jbGuardar = new JButton(new ImageIcon(getClass().getResource("/images/save.png")));
		jbGuardar.setBounds(513, 226, 64, 64);
		jbGuardar.setOpaque(false);
		jbGuardar.setContentAreaFilled(false);
		jbGuardar.setBorderPainted(false);
		jbGuardar.addActionListener(this);
		contentPane.add(jbGuardar);
		
		jbVolver = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		jbVolver.setBounds(22, 259, 48, 48);
		jbVolver.setOpaque(false);
		jbVolver.setContentAreaFilled(false);
		jbVolver.setBorderPainted(false);
		jbVolver.addActionListener(this);
		contentPane.add(jbVolver);
		
		txtNomDVD = new JTextField();
		txtNomDVD.setColumns(10);
		txtNomDVD.setBounds(211, 47, 185, 27);
		contentPane.add(txtNomDVD);
		
		txtAutorDVD = new JTextField();
		txtAutorDVD.setColumns(10);
		txtAutorDVD.setBounds(445, 47, 185, 27);
		contentPane.add(txtAutorDVD);
		
		txtDuracionDVD = new JTextField();
		txtDuracionDVD.setColumns(10);
		txtDuracionDVD.setBounds(211, 148, 185, 27);
		contentPane.add(txtDuracionDVD);
		
		txtAnoDVD = new JTextField();
		txtAnoDVD.setColumns(10);
		txtAnoDVD.setBounds(445, 148, 185, 27);
		contentPane.add(txtAnoDVD);
		
		JLabel NomDVD = new JLabel("Nombre");
		NomDVD.setFont(new Font("Tahoma", Font.BOLD, 18));
		NomDVD.setBounds(260, 11, 78, 27);
		contentPane.add(NomDVD);
		
		JLabel AutDVD = new JLabel("Autor");
		AutDVD.setFont(new Font("Tahoma", Font.BOLD, 18));
		AutDVD.setBounds(513, 11, 57, 27);
		contentPane.add(AutDVD);
		
		JLabel DuraDVD = new JLabel("Duraci\u00F3n");
		DuraDVD.setFont(new Font("Tahoma", Font.BOLD, 18));
		DuraDVD.setBounds(260, 110, 83, 27);
		contentPane.add(DuraDVD);
		
		JLabel AnoDVD = new JLabel("A\u00F1o");
		AnoDVD.setFont(new Font("Tahoma", Font.BOLD, 18));
		AnoDVD.setBounds(513, 110, 42, 27);
		contentPane.add(AnoDVD);
		
		txtOscarDVD = new JTextField();
		txtOscarDVD.setColumns(10);
		txtOscarDVD.setBounds(211, 244, 185, 27);
		contentPane.add(txtOscarDVD);
		
		JLabel Os = new JLabel("Oscars");
		Os.setFont(new Font("Tahoma", Font.BOLD, 18));
		Os.setBounds(272, 205, 64, 27);
		contentPane.add(Os);
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == jbVolver)
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda,ordenacion,0);
			objVerArticulos.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == jbGuardar)
		{
			int numero = 1;
											
			double nota = 0;
			int estado = 0, contador= 0, numVotos = 0;
			String nombre = txtNomDVD.getText();
			String autor = txtAutorDVD.getText();
			int duracion = Integer.parseInt(txtDuracionDVD.getText());
			int ano = Integer.parseInt(txtAnoDVD.getText());
			int oscar = Integer.parseInt(txtOscarDVD.getText());
			String web = "";
			String imagen = "";
				
			ClsDVD dvdnuevo = new ClsDVD(nombre, numero, autor, duracion, ano, nota, estado, contador, oscar, numVotos, 1, web, imagen);
			
			BaseDatos.initBD("eLibrary.db");
			BaseDatos.crearTablaBDDVD();			
			try 
			{
				BaseDatos.crearDVD(BaseDatos.getStatement(), dvdnuevo);
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}			
			BaseDatos.close();
				
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda,ordenacion,0);
			objVerArticulos.setVisible(true);
			this.dispose();
		}
	}

}
