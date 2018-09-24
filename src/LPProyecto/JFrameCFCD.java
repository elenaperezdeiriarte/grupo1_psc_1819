package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import LNProyecto.ClsUnificadorDClases;
import LNProyecto.MiExcepcion;

public class JFrameCFCD extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 673804301286420686L;
	private PanelConImagen contentPane;
	private JTextField txtCDNom;
	private JTextField txtCDAutor;
	private JTextField txtCDDuracion;
	private JTextField txtCDAno;
	private JLabel NomCD, AutCD, DuraCD, AnoCD;
	private int saberSiBusc;
	private int ordenacion;
	private String busqueda;
	private JButton jbGuardar;
	private JButton jbVolver;	

	public JFrameCFCD(int saberSiBusc, int ordenacion, String busqueda) 
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
		lblNewLabel.setIcon(new ImageIcon(JFrameMenuPrincipal.class.getResource("/images/CD.png")));
		lblNewLabel.setBounds(40, 47, 128, 128);
		contentPane.add(lblNewLabel);
		
		jbGuardar = new JButton(new ImageIcon(getClass().getResource("/images/save.png")));
		jbGuardar.setBounds(393, 208, 64, 64);
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
		
		txtCDNom = new JTextField();
		txtCDNom.setColumns(10);
		txtCDNom.setBounds(211, 47, 185, 27);
		contentPane.add(txtCDNom);
		
		txtCDAutor = new JTextField();
		txtCDAutor.setColumns(10);
		txtCDAutor.setBounds(445, 47, 185, 27);
		contentPane.add(txtCDAutor);
		
		txtCDDuracion = new JTextField();
		txtCDDuracion.setColumns(10);
		txtCDDuracion.setBounds(211, 148, 185, 27);
		contentPane.add(txtCDDuracion);
		
		txtCDAno = new JTextField();
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
		
		if (botonPulsado == jbVolver)
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda,ordenacion,0);
			objVerArticulos.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == jbGuardar)
		{
			ClsUnificadorDClases cambio = new ClsUnificadorDClases();
			int numero = cambio.leerNumerador();
											
			double nota = 0;
			int estado = 0, contador= 0, numVotos = 0;
			String nombre = txtCDNom.getText();
			String autor = txtCDAutor.getText();
			int duracion = Integer.parseInt(txtCDDuracion.getText());
			int ano = Integer.parseInt(txtCDAno.getText());
			String web = "";
			String imagen = "";
				
			
			boolean rep=false;
			try 
			{
				cambio.NuevoCD(nombre, numero, autor, duracion, ano, nota, estado, contador, numVotos, 0, web, imagen);
			} 
			catch (MiExcepcion e1) 
			{
				rep=true;
				JOptionPane.showMessageDialog(this, e1.toString());
			}	
			
			if (rep!=true)
			{
				cambio.sumarNumerador();
				
				JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda,ordenacion,0);
				objVerArticulos.setVisible(true);
				this.dispose();
			}
		}
	}
}
