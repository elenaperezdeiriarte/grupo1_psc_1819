package LPProyecto;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import LNProyecto.ClsArticulo;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.CompararPorNombre;
import LNProyecto.MiExcepcion;
import LNProyecto.TableArticulos;

import java.awt.Font;

//Ventana que diseña la pantalla de ver artículos del sistema

public class JFrameVerArticulos extends JFrame implements ActionListener, MouseListener
{
	private static final long serialVersionUID = -4874552086093483595L;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnInsertarCD;
	private JButton btnInsertarDVD;
	private JButton btnInsertarLibro;
	private JButton btnBorrarDatos;
	private JButton btnModificar;
	private JTable tableArticulos;
	private TableArticulos tart;
	private ArrayList<ClsArticulo> ArticuloList;
	private JTextField textBusqueda;
	private JButton btnBuscar ;
	private JButton btnVerTodos;
	private JButton btnNumero;
	private JButton btnNombre;
	private JButton btnAlquilardevolver ;
	private int ordenacion;
	private int saberSiBusc;
	private int adminOusu;
	private String busqueda;
	private JButton btnInsertarCD1;
	private JButton btnInsertarDVD1;
	private JButton btnInsertarLibro1;
	private JLabel label_3;
	private JButton btnWeb;
	private JLabel label_4;
	private JButton btestrella1;
	private JButton btestrella2;
	private JButton btestrella3;
	private JButton btestrella4;
	private JButton btestrella5;
	private JButton btestrella6;
	private JButton btestrella7;
	private JButton btestrella8;
	private JButton btestrella9;
	private JButton btestrella10;
	private JLabel lblPuntuar;
	private JLabel label_5;
	private JTextField txtWeb;
	private JButton btnVerFichaDel;
	

	@SuppressWarnings("unchecked")
	public JFrameVerArticulos(int a, String Busc, int x, int adminOusu) 
	{					
		this.adminOusu=adminOusu;
		this.busqueda= Busc;
		ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
		ArticuloList = Gestor.HashToArr(Gestor.ArrToHash(Gestor.leerArticulos()));
		
		saberSiBusc = a;
		ordenacion = x;
		
		if(x==0)
		{
			Collections.sort(ArticuloList);
		}
		
		if(x==1)
		{
			Collections.sort(ArticuloList, new CompararPorNombre());
		}
					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBounds(5, 5, 5, 5);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		if(adminOusu==0)
		{
			label_3 = new JLabel("---------------------------------------------------------------------------------------------------------------");
			label_3.setForeground(Color.WHITE);
			label_3.setBounds(845, 441, 473, 14);
			contentPane.add(label_3);
			
			label_4 = new JLabel("---------------------------------------------------------------------------------------------------------------");
			label_4.setForeground(Color.WHITE);
			label_4.setBounds(845, 587, 473, 14);
			contentPane.add(label_4);
			
			btnWeb = new JButton("Aï¿½adir Web");
			btnWeb.setBounds(1151, 532, 134, 44);
			btnWeb.setOpaque(false);
			btnWeb.addActionListener(this);
			contentPane.add(btnWeb);
			
			btnInsertarCD = new JButton(new ImageIcon(getClass().getResource("/images/CD.png")));
			btnInsertarCD.setBounds(1169, 270, 128, 128);
			btnInsertarCD.setOpaque(false);
			btnInsertarCD.setContentAreaFilled(false);
			btnInsertarCD.setBorderPainted(false);
			btnInsertarCD.addActionListener(this);
			contentPane.add(btnInsertarCD);
			
			btnInsertarCD1 = new JButton(new ImageIcon(getClass().getResource("/images/Add.png")));
			btnInsertarCD1.setBounds(1219, 398, 32, 32);
			btnInsertarCD1.setOpaque(false);
			btnInsertarCD1.setContentAreaFilled(false);
			btnInsertarCD1.setBorderPainted(false);
			btnInsertarCD1.addActionListener(this);
			contentPane.add(btnInsertarCD1);
			
			btnInsertarDVD = new JButton(new ImageIcon(getClass().getResource("/images/DVD.png")));
			btnInsertarDVD.setBounds(1019, 270, 128, 128);
			btnInsertarDVD.setOpaque(false);
			btnInsertarDVD.setContentAreaFilled(false);
			btnInsertarDVD.setBorderPainted(false);
			btnInsertarDVD.addActionListener(this);
			contentPane.add(btnInsertarDVD);
			
			btnInsertarDVD1 = new JButton(new ImageIcon(getClass().getResource("/images/Add.png")));
			btnInsertarDVD1.setBounds(1068, 398, 32, 32);
			btnInsertarDVD1.setOpaque(false);
			btnInsertarDVD1.setContentAreaFilled(false);
			btnInsertarDVD1.setBorderPainted(false);
			btnInsertarDVD1.addActionListener(this);
			contentPane.add(btnInsertarDVD1);
			
			btnInsertarLibro = new JButton(new ImageIcon(getClass().getResource("/images/book.png")));
			btnInsertarLibro.setBounds(865, 278, 118, 120);
			btnInsertarLibro.setOpaque(false);
			btnInsertarLibro.setContentAreaFilled(false);
			btnInsertarLibro.setBorderPainted(false);
			btnInsertarLibro.addActionListener(this);
			contentPane.add(btnInsertarLibro);
			
			btnInsertarLibro1 = new JButton(new ImageIcon(getClass().getResource("/images/Add.png")));
			btnInsertarLibro1.setBounds(909, 398, 32, 32);
			btnInsertarLibro1.setOpaque(false);
			btnInsertarLibro1.setContentAreaFilled(false);
			btnInsertarLibro1.setBorderPainted(false);
			btnInsertarLibro1.addActionListener(this);
			contentPane.add(btnInsertarLibro1);
			
			btnBorrarDatos = new JButton("Borrar Articulo");
			btnBorrarDatos.setActionCommand("Borrar Articulo");
			btnBorrarDatos.setBounds(1151, 466, 134, 44);
			contentPane.add(btnBorrarDatos);
			btnBorrarDatos.addActionListener(this);
			
			btnModificar = new JButton("Modificar Articulo");
			btnModificar.setActionCommand("Modificar Articulo");
			btnModificar.setBounds(999, 466, 134, 44);
			contentPane.add(btnModificar);
			btnModificar.addActionListener(this);
			
			btnAlquilardevolver = new JButton("Alquilar/Devolver");
			btnAlquilardevolver.setBounds(845, 466, 134, 44);
			btnAlquilardevolver.addActionListener(this);
			contentPane.add(btnAlquilardevolver);
			
			txtWeb = new JTextField();
			txtWeb.setFont(new Font("Tahoma", Font.BOLD, 19));
			txtWeb.setText("www.");
			txtWeb.setBounds(925, 532, 216, 44);
			contentPane.add(txtWeb);
			txtWeb.setColumns(10);
			
			JLabel lblHttp = new JLabel("https://");
			lblHttp.setForeground(Color.WHITE);
			lblHttp.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblHttp.setBounds(845, 532, 84, 44);
			contentPane.add(lblHttp);
		}
		else
		{
			lblPuntuar = new JLabel("Puntuar:");
			lblPuntuar.setForeground(Color.WHITE);
			lblPuntuar.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPuntuar.setBounds(899, 270, 67, 35);
			contentPane.add(lblPuntuar);
			
			label_5 = new JLabel("---------------------------------------------------------------------------------------------------------------");
			label_5.setForeground(Color.WHITE);
			label_5.setBounds(845, 314, 473, 14);
			contentPane.add(label_5);
			
			btestrella1 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella1.setOpaque(false);
			btestrella1.setContentAreaFilled(false);
			btestrella1.setBorderPainted(false);
			btestrella1.setBounds(983, 272, 32, 33);
			contentPane.add(btestrella1);
			btestrella1.addActionListener(this);
			btestrella1.addMouseListener(this);
			
			btestrella2 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella2.setOpaque(false);
			btestrella2.setContentAreaFilled(false);
			btestrella2.setBorderPainted(false);
			btestrella2.setBounds(1013, 272, 32, 33);
			contentPane.add(btestrella2);
			btestrella2.addActionListener(this);
			btestrella2.addMouseListener(this);
			
			btestrella3 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella3.setOpaque(false);
			btestrella3.setContentAreaFilled(false);
			btestrella3.setBorderPainted(false);
			btestrella3.setBounds(1043, 272, 32, 33);
			contentPane.add(btestrella3);
			btestrella3.addActionListener(this);
			btestrella3.addMouseListener(this);
			
			btestrella4 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella4.setOpaque(false);
			btestrella4.setContentAreaFilled(false);
			btestrella4.setBorderPainted(false);
			btestrella4.setBounds(1073, 272, 32, 33);
			contentPane.add(btestrella4);
			btestrella4.addActionListener(this);
			btestrella4.addMouseListener(this);
			
			btestrella5 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella5.setOpaque(false);
			btestrella5.setContentAreaFilled(false);
			btestrella5.setBorderPainted(false);
			btestrella5.setBounds(1103, 272, 32, 33);
			contentPane.add(btestrella5);
			btestrella5.addActionListener(this);
			btestrella5.addMouseListener(this);
			
			btestrella6 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella6.setOpaque(false);
			btestrella6.setContentAreaFilled(false);
			btestrella6.setBorderPainted(false);
			btestrella6.setBounds(1133, 272, 32, 33);
			contentPane.add(btestrella6);
			btestrella6.addActionListener(this);
			btestrella6.addMouseListener(this);
			
			btestrella7 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella7.setOpaque(false);
			btestrella7.setContentAreaFilled(false);
			btestrella7.setBorderPainted(false);
			btestrella7.setBounds(1163, 272, 32, 33);
			contentPane.add(btestrella7);
			btestrella7.addActionListener(this);
			btestrella7.addMouseListener(this);
			
			btestrella8 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella8.setOpaque(false);
			btestrella8.setContentAreaFilled(false);
			btestrella8.setBorderPainted(false);
			btestrella8.setBounds(1193, 272, 32, 33);
			contentPane.add(btestrella8);
			btestrella8.addActionListener(this);
			btestrella8.addMouseListener(this);
			
			btestrella9 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella9.setOpaque(false);
			btestrella9.setContentAreaFilled(false);
			btestrella9.setBorderPainted(false);
			btestrella9.setBounds(1223, 272, 32, 33);
			contentPane.add(btestrella9);
			btestrella9.addActionListener(this);
			btestrella9.addMouseListener(this);
			
			btestrella10 = new JButton(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella10.setOpaque(false);
			btestrella10.setContentAreaFilled(false);
			btestrella10.setBorderPainted(false);
			btestrella10.setBounds(1253, 272, 32, 33);
			contentPane.add(btestrella10);
			btestrella10.addActionListener(this);
			btestrella10.addMouseListener(this);
		}
		
		btnAtras = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		btnAtras.setBounds(21, 647, 57, 48);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 27, 800, 613);
		contentPane.add(scrollPane);
		
		textBusqueda = new JTextField();
		textBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textBusqueda.setBounds(884, 117, 243, 48);
		contentPane.add(textBusqueda);
		textBusqueda.setColumns(10);
		
		btnBuscar = new JButton(new ImageIcon(getClass().getResource("/images/Search.png")));
		btnBuscar.setBounds(1137, 117, 48, 48);
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
		
		btnNombre = new JButton("Nombre");
		btnNombre.setBounds(1019, 204, 134, 35);
		btnNombre.addActionListener(this);
		contentPane.add(btnNombre);
		
		btnNumero = new JButton("Numero");
		btnNumero.setBounds(1162, 204, 135, 35);
		btnNumero.addActionListener(this);
		contentPane.add(btnNumero);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setForeground(Color.WHITE);
		lblOrdenarPor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrdenarPor.setBounds(865, 204, 101, 35);
		contentPane.add(lblOrdenarPor);
		
		JLabel label = new JLabel("---------------------------------------------------------------------------------------------------------------");
		label.setForeground(Color.WHITE);
		label.setBounds(845, 176, 473, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("---------------------------------------------------------------------------------------------------------------");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(845, 251, 473, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("---------------------------------------------------------------------------------------------------------------");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(845, 92, 473, 14);
		contentPane.add(label_2);
		
		btnVerFichaDel = new JButton(new ImageIcon(getClass().getResource("/images/detalles.png")));
		btnVerFichaDel.setBounds(1084, 27, 80, 71);
		btnVerFichaDel.setOpaque(false);
		btnVerFichaDel.setContentAreaFilled(false);
		btnVerFichaDel.setBorderPainted(false);
		btnVerFichaDel.addActionListener(this);
		contentPane.add(btnVerFichaDel);
		
		JLabel lblVerMasDetalles = new JLabel("Ver mas detalles del articulo\r\n");
		lblVerMasDetalles.setForeground(Color.WHITE);
		lblVerMasDetalles.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVerMasDetalles.setBounds(865, 46, 227, 35);
		contentPane.add(lblVerMasDetalles);
				
		if(a==1)
		{
			ArrayList <ClsArticulo> auxiliar = new ArrayList <ClsArticulo> ();
			
			for(int a1 = 0; a1<ArticuloList.size(); a1++)
			{		
				if (ArticuloList.get(a1).getAutor().toLowerCase().indexOf(Busc.toLowerCase())!=-1) 
				{
					auxiliar.add(ArticuloList.get(a1));
				}
				else
				{
					if(ArticuloList.get(a1).getNombre().toLowerCase().indexOf(Busc.toLowerCase())!=-1)  
					{
						auxiliar.add(ArticuloList.get(a1));
					}
				}
			}					
			ArticuloList.clear();
			for (ClsArticulo b: auxiliar)
			{
				ArticuloList.add(b);
			}
			auxiliar.clear();
		
			btnVerTodos = new JButton("Ver Todos");
			btnVerTodos.setBounds(1024, 348, 150, 46);
			btnVerTodos.addActionListener(this);
			contentPane.add(btnVerTodos);
		}
		
		if(ArticuloList!=null)
		{	
			tart = new TableArticulos(ArticuloList);
			tableArticulos = new JTable(tart);
			scrollPane.setViewportView(tableArticulos);
			tableArticulos.setToolTipText("");
			tableArticulos.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
			tableArticulos.setFillsViewportHeight(true);
			ArrayList <Integer> tamanos = Gestor.tamanosColumnas();
			for(int i = 0; i<7; i++)
			{
				tableArticulos.getColumnModel().getColumn(i).setPreferredWidth(tamanos.get(i).intValue());
			}
			tableArticulos.setEnabled(true);
			tableArticulos.setRowSelectionAllowed(true);
		}
	}


	public void actionPerformed(ActionEvent c) 
	{
		
		JButton botonPulsado = (JButton)c.getSource();
		
		if (botonPulsado == btnAtras) 
		{
			if (adminOusu == 0)
			{
				JFrameMenuAdministrador objMenuAdministrador = new JFrameMenuAdministrador();
				objMenuAdministrador.setVisible(true);
				this.dispose();
			}
			else
			{
				JFrameMenuCliente objCliente = new JFrameMenuCliente();
				objCliente.setVisible(true);
				this.dispose();
			}
		}
		
		if (botonPulsado == btnInsertarCD || botonPulsado == btnInsertarCD1 )
		{
			JFrameCFCD nuevoCD = new JFrameCFCD(saberSiBusc, ordenacion, busqueda);
			nuevoCD.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == btnInsertarDVD || botonPulsado == btnInsertarDVD1 )
		{
			JFrameCFDVD nuevoDVD = new JFrameCFDVD(saberSiBusc, ordenacion, busqueda);
			nuevoDVD.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == btnInsertarLibro || botonPulsado == btnInsertarLibro1 )
		{
			JFrameCFLibro nuevoLibro = new JFrameCFLibro(saberSiBusc, ordenacion, busqueda);
			nuevoLibro.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == btnBuscar )
		{
			//Aqui se manda lo que hemos buscado
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(1, textBusqueda.getText(), ordenacion,adminOusu);
			objVerArticulos.setVisible(true);
			
			this.dispose();
		}
		
		if (botonPulsado == btnVerTodos )
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(0, "", ordenacion, adminOusu );
			objVerArticulos.setVisible(true);
			
			this.dispose();
		}
		
		
		if (botonPulsado == btnVerFichaDel )
		{
			tableArticulos.getSelectedRow();
			try
			{
				if(tableArticulos.getSelectedRow()!=-1)
				{	
					ClsArticulo Articulo = ArticuloList.get(tableArticulos.getSelectedRow());
					
					JFrameVerFicha objFicha = new JFrameVerFicha(Articulo, saberSiBusc, busqueda, ordenacion, adminOusu,1);
					objFicha.setVisible(true);
					this.dispose();
				}
				else
				{
					throw new MiExcepcion();
				}
			}
			catch(MiExcepcion e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		
		if (botonPulsado == btnAlquilardevolver )
		{
			tableArticulos.getSelectedRow();
			try
			{
				if(tableArticulos.getSelectedRow()!=-1)
				{	
					
					ClsArticulo Articulo = ArticuloList.get(tableArticulos.getSelectedRow());
					
					ClsUnificadorDClases cambio = new ClsUnificadorDClases();
					cambio.comenzarModificacion(Articulo);
					cambio.Modificar(Articulo,0,0,null, null);
					
					JFrameVerArticulos objVerArticulos11= new JFrameVerArticulos(saberSiBusc,busqueda,ordenacion, adminOusu);
					objVerArticulos11.setVisible(true);
					this.dispose();
				}
				else
				{
					throw new MiExcepcion();
				}
			}
			catch(MiExcepcion e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		
		if (botonPulsado == btnWeb)
		{
			tableArticulos.getSelectedRow();
			try
			{
				if(tableArticulos.getSelectedRow()!=-1)
				{	
					
					ClsArticulo Articulo = ArticuloList.get(tableArticulos.getSelectedRow());
					
					ClsUnificadorDClases cambio = new ClsUnificadorDClases();
					cambio.comenzarModificacion(Articulo);
					cambio.Modificar(Articulo,3,0,txtWeb.getText(),null);
					
					
					JFrameVerArticulos objVerArticulos11= new JFrameVerArticulos(saberSiBusc,busqueda,ordenacion, adminOusu);
					objVerArticulos11.setVisible(true);
					this.dispose();
				}
				else
				{
					throw new MiExcepcion();
				}
			}
			catch(MiExcepcion e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		
		if (botonPulsado == btnModificar )
		{
			tableArticulos.getSelectedRow();
			try
			{
				if(tableArticulos.getSelectedRow()!=-1)
				{
						ClsArticulo Articulo = ArticuloList.get(tableArticulos.getSelectedRow());
						
						switch(Articulo.getTipo())
						{
						case 0: JFrameModificarCD objModCD = new JFrameModificarCD(Articulo, saberSiBusc,ordenacion, busqueda); 
								objModCD.setVisible(true); this.dispose(); break;
						case 1: JFrameModificarDVD objModDVD = new JFrameModificarDVD(Articulo, saberSiBusc,ordenacion, busqueda);
								objModDVD.setVisible(true); this.dispose(); break;
						case 2: JFrameModificarLibro objModLib = new JFrameModificarLibro(Articulo, saberSiBusc,ordenacion, busqueda);
								objModLib.setVisible(true); this.dispose(); break;
						}
						
				}
				else
				{
					throw new MiExcepcion();
				}
			}
			catch(MiExcepcion e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		
		if (botonPulsado == btnBorrarDatos )
		{
			tableArticulos.getSelectedRow();
			try
			{
				if(tableArticulos.getSelectedRow()!=-1)
				{	
					ClsArticulo Articulo = ArticuloList.get(tableArticulos.getSelectedRow());
					ClsUnificadorDClases cambio = new ClsUnificadorDClases();
					cambio.comenzarModificacion(Articulo);
					
					JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda, ordenacion , adminOusu);
					objVerArticulos.setVisible(true);
					this.dispose();
				}
				else
				{
					throw new MiExcepcion();
				}
			}
			catch(MiExcepcion e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		if (botonPulsado == btnNumero)
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda, 0, adminOusu);
			objVerArticulos.setVisible(true);
			this.dispose();
		}
		
		if (botonPulsado == btnNombre)
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda, 1, adminOusu);
			objVerArticulos.setVisible(true);
			this.dispose();
		}
	}

	public void mouseClicked(MouseEvent c) 
	{
		
	}

	public void mouseEntered(MouseEvent c) 
	{
		JButton botonPulsado = (JButton)c.getSource();
		
		if (botonPulsado == btestrella1) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella2) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella3) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella4) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella5) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png")));
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella6) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella7) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella8) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png")));
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella8.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella9) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella8.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella9.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella10) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella8.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella9.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			btestrella10.setIcon(new ImageIcon(getClass().getResource("/images/star-full.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
	}

	public void mouseExited(MouseEvent c) 
	{
		JButton botonPulsado = (JButton)c.getSource();
		
		if (botonPulsado == btestrella1) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella2) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella3) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella4) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella5) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella6) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella7) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella8) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png")));
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella8.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella9) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella8.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella9.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
		if (botonPulsado == btestrella10) 
		{
			btestrella1.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella2.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella3.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella4.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella5.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella6.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella7.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella8.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella9.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			btestrella10.setIcon(new ImageIcon(getClass().getResource("/images/star-empty.png"))); 
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
	}

	public void mousePressed(MouseEvent c) 
	{
		tableArticulos.getSelectedRow();
		try
		{
			if(tableArticulos.getSelectedRow()!=-1)
			{	
				
				JButton botonPulsado = (JButton)c.getSource();
				int nota = 0;
				
				if (botonPulsado == btestrella1) 
				{
					nota=1;
				}
				
				if (botonPulsado == btestrella2) 
				{
					nota=2;
				}
				
				if (botonPulsado == btestrella3) 
				{
					nota=3;
				}
				
				if (botonPulsado == btestrella4) 
				{
					nota=4;
				}
				
				if (botonPulsado == btestrella5) 
				{
					nota=5;
				}
				
				if (botonPulsado == btestrella6) 
				{
					nota=6;
				}
				
				if (botonPulsado == btestrella7) 
				{
					nota=7;
				}
				
				if (botonPulsado == btestrella8) 
				{
					nota=8;
				}
				
				if (botonPulsado == btestrella9) 
				{
					nota=9;
				}
				
				if (botonPulsado == btestrella10) 
				{
					nota=10;
				}
				
				
				if(nota!=0)
				{
					ClsArticulo Articulo = ArticuloList.get(tableArticulos.getSelectedRow());
					
					ClsUnificadorDClases cambio = new ClsUnificadorDClases();
					cambio.comenzarModificacion(Articulo);
					cambio.Modificar(Articulo, 1, nota, null, null);
					
					JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda, ordenacion, 1);
					objVerArticulos.setVisible(true);
					this.dispose();
				}
			}
			else
			{
				throw new MiExcepcion();
			}
		}
		catch(MiExcepcion e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	public void mouseReleased(MouseEvent c) 
	{
		
	}
}
