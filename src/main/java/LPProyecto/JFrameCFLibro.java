package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import LDProyecto.BaseDatos;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

import LNProyecto.ClsDVD;
import LNProyecto.ClsLibro;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.MiExcepcion;

public class JFrameCFLibro extends JFrame implements ActionListener {
	private static final long serialVersionUID = -8378025102860809175L;
	private PanelConImagen contentPane;
	private JLabel lblPginas;
	private int saberSiBusc;
	private int ordenacion;
	private String busqueda;
	private JButton jbGuardar;
	private JButton jbVolver;
	private JTextField txtLibNom;
	private JTextField txtLibAutor;
	private JTextField txtLibPag;
	private static final Logger log = Logger.getLogger(JFrameCFLibro.class.getName());

	public JFrameCFLibro(int saberSiBusc, int ordenacion, String busqueda) {

		this.saberSiBusc = saberSiBusc;
		this.ordenacion = ordenacion;
		this.busqueda = busqueda;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 352);
		contentPane = new PanelConImagen();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameMenuPrincipal.class
				.getResource("/images/book.png")));
		lblNewLabel.setBounds(40, 47, 118, 120);
		contentPane.add(lblNewLabel);

		jbGuardar = new JButton(new ImageIcon(getClass().getResource(
				"/images/save.png")));
		jbGuardar.setBounds(274, 239, 64, 64);
		jbGuardar.setOpaque(false);
		jbGuardar.setContentAreaFilled(false);
		jbGuardar.setBorderPainted(false);
		jbGuardar.addActionListener(this);
		contentPane.add(jbGuardar);

		jbVolver = new JButton(new ImageIcon(getClass().getResource(
				"/images/back.png")));
		jbVolver.setBounds(22, 259, 48, 48);
		jbVolver.setOpaque(false);
		jbVolver.setContentAreaFilled(false);
		jbVolver.setBorderPainted(false);
		jbVolver.addActionListener(this);
		contentPane.add(jbVolver);

		txtLibNom = new JTextField();
		txtLibNom.setColumns(10);
		txtLibNom.setBounds(211, 24, 185, 27);
		contentPane.add(txtLibNom);

		txtLibAutor = new JTextField();
		txtLibAutor.setColumns(10);
		txtLibAutor.setBounds(211, 100, 185, 27);
		contentPane.add(txtLibAutor);

		JLabel NomLib = new JLabel("Nombre");
		NomLib.setFont(new Font("Tahoma", Font.BOLD, 18));
		NomLib.setBounds(260, -2, 78, 27);
		contentPane.add(NomLib);

		JLabel AutLib = new JLabel("Autor");
		AutLib.setFont(new Font("Tahoma", Font.BOLD, 18));
		AutLib.setBounds(274, 73, 57, 27);
		contentPane.add(AutLib);

		lblPginas = new JLabel("P\u00E1ginas");
		lblPginas.setForeground(Color.BLACK);
		lblPginas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPginas.setBackground(Color.YELLOW);
		lblPginas.setBounds(262, 151, 76, 27);
		contentPane.add(lblPginas);

		txtLibPag = new JTextField();
		txtLibPag.setColumns(10);
		txtLibPag.setBounds(211, 177, 185, 27);
		contentPane.add(txtLibPag);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == jbVolver) {
			JFrameVerArticulos objVerArticulos = new JFrameVerArticulos(
					saberSiBusc, busqueda, ordenacion, 0);
			objVerArticulos.setVisible(true);
			this.dispose();
		}

		if (botonPulsado == jbGuardar) {
			log.info("Mensaje de informacion: El libro ha sido alquilado/devuelto correctamente en la base de datos");
			
			int numero = 1;

			double nota = 0;
			int estado = 0, contador = 0, numVotos = 0;
			String web = "";

			int paginas = Integer.parseInt(txtLibPag.getText());
			String nombre = txtLibNom.getText();
			String autor = txtLibAutor.getText();
			String imagen = "";

			ClsLibro libronuevo = new ClsLibro(nombre, numero, autor, nota,
					estado, contador, paginas, numVotos, 2, web, imagen);

			BaseDatos.initBD("eLibrary.db");
			BaseDatos.crearTablaBDLibro();
			try {
				BaseDatos.crearLibro(BaseDatos.getStatement(), libronuevo);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			BaseDatos.close();

			JFrameVerArticulos objVerArticulos = new JFrameVerArticulos(
					saberSiBusc, busqueda, ordenacion, 0);
			objVerArticulos.setVisible(true);
			this.dispose();
		}

	}
}
