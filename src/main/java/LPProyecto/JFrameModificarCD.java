package LPProyecto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LDProyecto.BaseDatos;
import LNProyecto.ClsArticulo;
import LNProyecto.ClsCD;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.MiExcepcion;

public class JFrameModificarCD extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = -2045631554268977481L;
	private PanelConImagen contentPane;
	private JTextField txtCDNom;
	private JTextField txtCDAutor;
	private JTextField txtCDDuracion;
	private JTextField txtCDAno;
	private JLabel NomCD, AutCD, DuraCD, AnoCD;
	private JButton btnGuardar;	
	private ClsCD CDaModificar;
	private int saberSiBusc;
	private int ordenacion;
	private String busqueda;
	private JButton jbVolver;
	private ClsCD CD;
	public JFrameModificarCD(ClsArticulo Articulo, int saberSiBusc, int ordenacion, String busqueda) 
	{
		CDaModificar = (ClsCD)Articulo;
		this.CD = (ClsCD)Articulo;
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
		lblNewLabel.setIcon(new ImageIcon(JFrameMenuPrincipal.class.getResource("/images/CD.png")));
		lblNewLabel.setBounds(40, 47, 128, 128);
		contentPane.add(lblNewLabel);
		
		btnGuardar = new JButton(new ImageIcon(getClass().getResource("/images/save.png")));
		btnGuardar.setBounds(393, 208, 64, 64);
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		jbVolver = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		jbVolver.setBounds(22, 259, 48, 48);
		jbVolver.setOpaque(false);
		jbVolver.setContentAreaFilled(false);
		jbVolver.setBorderPainted(false);
		jbVolver.addActionListener(this);
		contentPane.add(jbVolver);
		
		txtCDNom = new JTextField();
		txtCDNom.setText(CDaModificar.getNombre());
		txtCDNom.setColumns(10);
		txtCDNom.setBounds(211, 47, 185, 27);
		contentPane.add(txtCDNom);
		
		txtCDAutor = new JTextField();
		txtCDAutor.setText(CDaModificar.getAutor());
		txtCDAutor.setColumns(10);
		txtCDAutor.setBounds(445, 47, 185, 27);
		contentPane.add(txtCDAutor);
		
		txtCDDuracion = new JTextField();
		txtCDDuracion.setText(Integer.toString(CDaModificar.getDuracion()));
		txtCDDuracion.setColumns(10);
		txtCDDuracion.setBounds(211, 148, 185, 27);
		contentPane.add(txtCDDuracion);
		
		txtCDAno = new JTextField();
		txtCDDuracion.setText(Integer.toString(CDaModificar.getAno()));
		txtCDAno.setColumns(10);
		txtCDAno.setBounds(445, 148, 185, 27);
		contentPane.add(txtCDAno);
		
		NomCD = new JLabel("Nombre");
		NomCD.setFont(new Font("Tahoma", Font.BOLD, 18));
		NomCD.setBounds(260, 11, 78, 27);
		contentPane.add(NomCD);
		
		AutCD = new JLabel("Autor");
		AutCD.setFont(new Font("Tahoma", Font.BOLD, 18));
		AutCD.setBounds(513, 11, 57, 27);
		contentPane.add(AutCD);
		
		DuraCD = new JLabel("Duraci\u00F3n");
		DuraCD.setFont(new Font("Tahoma", Font.BOLD, 18));
		DuraCD.setBounds(260, 110, 83, 27);
		contentPane.add(DuraCD);
		
		AnoCD = new JLabel("A\u00F1o");
		AnoCD.setFont(new Font("Tahoma", Font.BOLD, 18));
		AnoCD.setBounds(513, 110, 42, 27);
		contentPane.add(AnoCD);	
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == btnGuardar)
		{									
			ClsUnificadorDClases cambio = new ClsUnificadorDClases();
			cambio.comenzarModificacion(CDaModificar);
			
			CDaModificar.setAutor(txtCDAutor.getText());	
			CDaModificar.setNombre(txtCDNom.getText());	
			CDaModificar.setDuracion(Integer.parseInt(txtCDDuracion.getText()));
			CDaModificar.setAno(Integer.parseInt(txtCDAno.getText()));
			
			BaseDatos.initBD("eLibrary.db");
			try {
				BaseDatos.modificarCD(CDaModificar);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JFrameVerArticulos objVerArticulos = new JFrameVerArticulos(0,"",0,0);
			objVerArticulos.setVisible(true);
			this.dispose();	
			
		}
		
		if (botonPulsado == jbVolver)
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda,ordenacion,0);
			objVerArticulos.setVisible(true);
			this.dispose();
		}
		
	}
}
