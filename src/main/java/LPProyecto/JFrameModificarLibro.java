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

import LNProyecto.ClsArticulo;
import LNProyecto.ClsLibro;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.MiExcepcion;

public class JFrameModificarLibro extends JFrame implements ActionListener {
	private static final long serialVersionUID = -8378025102860809175L;
	private PanelConImagen contentPane;
	private JTextField txtLibNombre;
	private JTextField txtLibAutor;
	private JTextField txtLibPaginas;
	private JButton btnGuardar;
	private ClsLibro LibroaModificar;
	private int saberSiBusc;
	private int ordenacion;
	private String busqueda;
	private JButton jbVolver;
	private ClsLibro Libro;
	private ClsArticulo Articulo;

	public JFrameModificarLibro(ClsArticulo Articulo, int saberSiBusc,
			int ordenacion, String busqueda) {
		LibroaModificar = (ClsLibro) Articulo;
		this.Articulo = Articulo;
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

		btnGuardar = new JButton(new ImageIcon(getClass().getResource(
				"/images/save.png")));
		btnGuardar.setBounds(260, 239, 64, 64);
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);

		jbVolver = new JButton(new ImageIcon(getClass().getResource(
				"/images/back.png")));
		jbVolver.setBounds(22, 259, 48, 48);
		jbVolver.setOpaque(false);
		jbVolver.setContentAreaFilled(false);
		jbVolver.setBorderPainted(false);
		jbVolver.addActionListener(this);
		contentPane.add(jbVolver);

		txtLibNombre = new JTextField();
		txtLibNombre.setText(LibroaModificar.getNombre());
		txtLibNombre.setColumns(10);
		txtLibNombre.setBounds(211, 24, 185, 27);
		contentPane.add(txtLibNombre);

		txtLibAutor = new JTextField();
		txtLibAutor.setText(LibroaModificar.getAutor());
		txtLibAutor.setColumns(10);
		txtLibAutor.setBounds(211, 100, 185, 27);
		contentPane.add(txtLibAutor);

		txtLibPaginas = new JTextField();
		txtLibPaginas.setText(String.valueOf(LibroaModificar.getpaginas()));
		txtLibPaginas.setColumns(10);
		txtLibPaginas.setBounds(211, 177, 185, 27);
		contentPane.add(txtLibPaginas);

		JLabel NomLib = new JLabel("Nombre");
		NomLib.setFont(new Font("Tahoma", Font.BOLD, 18));
		NomLib.setBounds(260, -2, 78, 27);
		contentPane.add(NomLib);

		JLabel AutLib = new JLabel("Autor");
		AutLib.setFont(new Font("Tahoma", Font.BOLD, 18));
		AutLib.setBounds(274, 73, 57, 27);
		contentPane.add(AutLib);

		JLabel lblPginas = new JLabel("P\u00E1ginas");
		lblPginas.setForeground(Color.BLACK);
		lblPginas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPginas.setBackground(Color.YELLOW);
		lblPginas.setBounds(262, 151, 76, 27);
		contentPane.add(lblPginas);
	}

	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnGuardar) {
			ClsUnificadorDClases cambio = new ClsUnificadorDClases();
			cambio.comenzarModificacion(LibroaModificar);

			Libro = LibroaModificar;

			LibroaModificar.setAutor(txtLibAutor.getText());
			LibroaModificar.setNombre(txtLibNombre.getText());
			LibroaModificar.setpaginas(Integer.parseInt(txtLibPaginas.getText()));
			
			BaseDatos.initBD("eLibrary.db");
			try {
				BaseDatos.modificarLibro(LibroaModificar);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			JFrameVerArticulos objVerArticulos = new JFrameVerArticulos(0, "", 0, 0);
			objVerArticulos.setVisible(true);
			this.dispose();

		}

		if (botonPulsado == jbVolver) {
			JFrameVerArticulos objVerArticulos = new JFrameVerArticulos(
					saberSiBusc, busqueda, ordenacion, 0);
			objVerArticulos.setVisible(true);
			this.dispose();
		}

	}
}
