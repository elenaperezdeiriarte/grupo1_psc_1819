package LPProyecto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import LNProyecto.ClsArticulo;
import LNProyecto.ClsCD;
import LNProyecto.ClsDVD;
import LNProyecto.ClsLibro;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.CompararPorNota;
import LNProyecto.CompararPorVecesAlquilado;
import LNProyecto.TableCDs;
import LNProyecto.TableDVDs;
import LNProyecto.TableLibros;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import org.apache.log4j.Logger;

public class JFrameEstadisticas extends JFrame implements ActionListener

{
	private static final long serialVersionUID = 1483541409470235114L;
	private JPanel contentPane;
	private ArrayList<ClsArticulo> ArticuloList;
	private TableCDs tacd;
	private TableDVDs tadvd;
	private TableLibros talib;
	private JTable tableCD;
	private JTable tableDVD;
	private JTable tableLibro;
	private JButton btnNota;
	private JButton btnVecesPrestado;
	private JButton btnVolver;
	private static final Logger log = Logger.getLogger(JFrameEstadisticas.class.getName());

	public JFrameEstadisticas(int x) {
		setTitle("Administrador de articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setExtendedState(6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 150, 400, 450);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameMenuPrincipal.class
				.getResource("/images/CD.png")));
		lblNewLabel.setBounds(183, 11, 128, 128);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon(JFrameMenuPrincipal.class
				.getResource("/images/DVD.png")));
		lblNewLabel1.setBounds(619, 11, 128, 128);
		contentPane.add(lblNewLabel1);

		JLabel lblNewLabel11 = new JLabel("");
		lblNewLabel11.setIcon(new ImageIcon(JFrameMenuPrincipal.class
				.getResource("/images/book.png")));
		lblNewLabel11.setBounds(1071, 11, 118, 120);
		contentPane.add(lblNewLabel11);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(484, 150, 400, 450);
		contentPane.add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(918, 150, 400, 450);
		contentPane.add(scrollPane_2);

		if (x == 1) {
			btnNota = new JButton("Nota");
			btnNota.setBounds(616, 648, 89, 23);
			btnNota.addActionListener(this);
			contentPane.add(btnNota);
		}

		if (x == 0) {
			btnVecesPrestado = new JButton("Veces Prestado");
			btnVecesPrestado.setBounds(616, 648, 136, 23);
			btnVecesPrestado.addActionListener(this);
			contentPane.add(btnVecesPrestado);
		}

		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setFont(new Font("Verdana", Font.BOLD, 18));
		lblOrdenarPor.setForeground(Color.WHITE);
		lblOrdenarPor.setBounds(451, 647, 155, 23);
		contentPane.add(lblOrdenarPor);

		btnVolver = new JButton(new ImageIcon(getClass().getResource(
				"/images/back.png")));
		btnVolver.setBounds(32, 638, 81, 57);
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);

		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ArticuloList = Gestor
				.HashToArr(Gestor.ArrToHash(Gestor.leerArticulos()));

		ArrayList<ClsCD> ListaCDs = new ArrayList<ClsCD>();
		ArrayList<ClsDVD> ListaDVDs = new ArrayList<ClsDVD>();
		ArrayList<ClsLibro> ListaLibros = new ArrayList<ClsLibro>();

		for (ClsArticulo s : ArticuloList) {
			try {
				ListaCDs.add((ClsCD) s);
			} catch (ClassCastException e) {
				try {
					ListaDVDs.add((ClsDVD) s);
				} catch (ClassCastException e1) {
					ListaLibros.add((ClsLibro) s);
				}
			}
		}

		if (x == 0) {
			Collections.sort(ListaCDs, new CompararPorNota());
			Collections.sort(ListaDVDs, new CompararPorNota());
			Collections.sort(ListaLibros, new CompararPorNota());
		}

		if (x == 1) {
			Collections.sort(ListaCDs, new CompararPorVecesAlquilado());
			Collections.sort(ListaDVDs, new CompararPorVecesAlquilado());
			Collections.sort(ListaLibros, new CompararPorVecesAlquilado());
		}

		if (ListaCDs != null) {
			tacd = new TableCDs(ListaCDs);
			tableCD = new JTable(tacd);
			scrollPane.setViewportView(tableCD);
			tableCD.setToolTipText("");
			tableCD.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
			tableCD.setFillsViewportHeight(true);
			tableCD.setEnabled(true);
			tableCD.setRowSelectionAllowed(true);
		}

		if (ListaDVDs != null) {
			tadvd = new TableDVDs(ListaDVDs);
			tableDVD = new JTable(tadvd);
			scrollPane_1.setViewportView(tableDVD);
			tableDVD.setToolTipText("");
			tableDVD.setBorder(UIManager
					.getBorder("FileChooser.listViewBorder"));
			tableDVD.setFillsViewportHeight(true);
			tableDVD.setEnabled(true);
			tableDVD.setRowSelectionAllowed(true);
		}

		if (ListaDVDs != null) {
			talib = new TableLibros(ListaLibros);
			tableLibro = new JTable(talib);
			scrollPane_2.setViewportView(tableLibro);
			tableLibro.setToolTipText("");
			tableLibro.setBorder(UIManager
					.getBorder("FileChooser.listViewBorder"));
			tableLibro.setFillsViewportHeight(true);
			tableLibro.setEnabled(true);
			tableLibro.setRowSelectionAllowed(true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnNota) {
			JFrameEstadisticas objEstadisticas = new JFrameEstadisticas(0);
			objEstadisticas.setVisible(true);

			this.dispose();
		}

		if (botonPulsado == btnVecesPrestado) {
			JFrameEstadisticas objEstadisticas = new JFrameEstadisticas(1);
			objEstadisticas.setVisible(true);

			this.dispose();
		}

		if (botonPulsado == btnVolver) {
			JFrameMenuCliente objCliente = new JFrameMenuCliente();

			objCliente.setVisible(true);

			this.dispose();
		}

	}
}
