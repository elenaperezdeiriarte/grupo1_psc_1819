package LPProyecto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LNProyecto.ClsArticulo;
import LNProyecto.ClsAudioVisual;
import LNProyecto.ClsCD;
import LNProyecto.ClsComentario;
import LNProyecto.ClsDVD;
import LNProyecto.ClsLibro;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.LabelUrl;
import LNProyecto.MiExcepcion;

import javax.swing.JTextPane;

import org.apache.log4j.Logger;

import LDProyecto.BaseDatos;

public class JFrameVerFicha extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -5353048843038038829L;
	private JPanel contentPane;
	private JButton btnAtras;
	private int saberSiBusc;
	private String busqueda;
	private int ordenacion;
	private int adminOusu;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnNext;
	private JButton btnPrevious;
	private int numAct;
	private JTextPane textPane;
	private JButton btnComentar;
	private JButton btnEnviar;
	private ArrayList<ClsComentario> ComentariosArticulo;
	private ClsArticulo Articulo;
	private JLabel imagen;
	private JLabel lblNumActu;
	private JLabel lblEliminarFoto;
	private JLabel lblNewLabel;
	private static final Logger log = Logger.getLogger(JFrameVerFicha.class.getName());
	
	public JFrameVerFicha(ClsArticulo Articulo,int saberSiBusc, String busqueda, int ordenacion, int adminOusu, int numCom) 
	{
		this.adminOusu=adminOusu;
		this.busqueda= busqueda;
		this.ordenacion=ordenacion;
		this.saberSiBusc=saberSiBusc;
		this.numAct=numCom;
		this.Articulo = Articulo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBounds(5, 5, 5, 5);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		btnEnviar = new JButton(new ImageIcon(getClass().getResource("/images/enviar.png")));
		btnEnviar.setBounds(601, 411, 185, 56);
		btnEnviar.setOpaque(false);
		btnEnviar.setContentAreaFilled(false);
		btnEnviar.setBorderPainted(false);
		btnEnviar.addActionListener(this);
		
		JLabel lbNum = new JLabel("Numero:");
		lbNum.setForeground(Color.WHITE);
		lbNum.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbNum.setBounds(37, 73, 91, 37);
		contentPane.add(lbNum);
		
		JLabel lbNum1 = new JLabel(Integer.toString(Articulo.getNumero()));
		lbNum1.setForeground(Color.WHITE);
		lbNum1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbNum1.setBounds(155, 73, 224, 37);
		contentPane.add(lbNum1);
		
		JLabel lbTip = new JLabel("Tipo:");
		lbTip.setForeground(Color.WHITE);
		lbTip.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbTip.setBounds(75, 118, 53, 37);
		contentPane.add(lbTip);
		
		String tp= "";
		
		switch(Articulo.getTipo())
		{
		case 0: tp = "CD"; break;
		case 1: tp = "DVD"; break;
		case 2: tp = "Libro"; break;
		}
		
		JLabel lbTip1 = new JLabel(tp);
		lbTip1.setForeground(Color.WHITE);
		lbTip1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbTip1.setBounds(155, 121, 224, 37);
		contentPane.add(lbTip1);
		
		JLabel lbNom = new JLabel("Nombre:");
		lbNom.setForeground(Color.WHITE);
		lbNom.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbNom.setBounds(37, 163, 91, 37);
		contentPane.add(lbNom);
		
		JLabel lbNom1 = new JLabel(Articulo.getNombre());
		lbNom1.setForeground(Color.WHITE);
		lbNom1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbNom1.setBounds(155, 163, 319, 37);
		contentPane.add(lbNom1);
		
		JLabel lbAut = new JLabel("Autor:");
		lbAut.setForeground(Color.WHITE);
		lbAut.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbAut.setBounds(62, 208, 66, 37);
		contentPane.add(lbAut);
		
		JLabel lbAut1 = new JLabel(Articulo.getAutor());
		lbAut1.setForeground(Color.WHITE);
		lbAut1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbAut1.setBounds(155, 208, 319, 37);
		contentPane.add(lbAut1);
		
		JLabel lbEstado = new JLabel("Estado:");
		lbEstado.setForeground(Color.WHITE);
		lbEstado.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbEstado.setBounds(579, 118, 80, 37);
		contentPane.add(lbEstado);
		
		String estado= "";
		
		switch(Articulo.getEstado())
		{
		case 0: estado = "Disponible"; break;
		case 1: estado = "Prestado"; break;
		}
		
		JLabel lbEstado1 = new JLabel(estado);
		lbEstado1.setForeground(Color.WHITE);
		lbEstado1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbEstado1.setBounds(686, 118, 224, 37);
		contentPane.add(lbEstado1);
		
		JLabel lbVecPres = new JLabel("Veces Prestado:");
		lbVecPres.setForeground(Color.WHITE);
		lbVecPres.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbVecPres.setBounds(491, 163, 168, 37);
		contentPane.add(lbVecPres);
		
		JLabel lbVecPres1 = new JLabel(Integer.toString(Articulo.getContador()));
		lbVecPres1.setForeground(Color.WHITE);
		lbVecPres1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbVecPres1.setBounds(686, 163, 168, 37);
		contentPane.add(lbVecPres1);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setForeground(Color.WHITE);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNota.setBounds(600, 208, 59, 37);
		contentPane.add(lblNota);
		
		DecimalFormat formateador = new DecimalFormat("##.##");
		String nota = formateador.format(Articulo.getNota());
		
		JLabel lblNota1 = new JLabel(nota);
		lblNota1.setForeground(Color.WHITE);
		lblNota1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNota1.setBounds(686, 208, 59, 37);
		contentPane.add(lblNota1);
		
		if(Articulo.getWeb().equals(""))
		{
			JLabel lblNoWeb  = new JLabel("No hay Web");
			lblNoWeb.setForeground(Color.WHITE);
			lblNoWeb.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNoWeb.setBounds(694, 73, 161, 37);
			contentPane.add(lblNoWeb);
		}
		else
		{
			LabelUrl lbWeb1 = new LabelUrl();
			lbWeb1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbWeb1.setSize(161, 37);
			lbWeb1.setForeground(Color.WHITE);
			lbWeb1.setURL(Articulo.getWeb());
			lbWeb1.setText("Visitar Web");
			lbWeb1.setLocation(694, 73);                
			getContentPane().add(lbWeb1);
		}
		
		JLabel lbWeb = new JLabel("Web:");
		lbWeb.setForeground(Color.WHITE);
		lbWeb.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbWeb.setBounds(601, 73, 59, 37);
		contentPane.add(lbWeb);
		
		lblEliminarFoto = new JLabel("Eliminar Foto");
		lblEliminarFoto.setForeground(Color.WHITE);
		lblEliminarFoto.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEliminarFoto.setBounds(1119, 636, 123, 32);
		
		btnDelete = new JButton(new ImageIcon(getClass().getResource("/images/delete.png")));
		btnDelete.setBounds(1252, 636, 32, 32);
		btnDelete.setOpaque(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.addActionListener(this);
		
		imagen = new JLabel();
        imagen.setBounds(846, 28, 438, 597);
        
		if(!Articulo.getImagen().equals(""))
		{
			
			
			Image image = null;
			try 
	        {
	            URL url = new URL(Articulo.getImagen());
	            image = ImageIO.read(url);
	        } 
	        catch (IOException e1) 
	        {
	        }
			
			ImageIcon fot = new ImageIcon(image);
	        ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
	        imagen.setIcon(icono);
	        
	        contentPane.add(btnDelete);
	        contentPane.add(lblEliminarFoto);
	        
	        setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		
        contentPane.add(imagen);
     
		
		int tipo=Articulo.getTipo();
		
		if(tipo==2)
		{
			ClsLibro Libro = (ClsLibro) Articulo;
			
			JLabel lbPaginas = new JLabel("Paginas:");
			lbPaginas.setForeground(Color.WHITE);
			lbPaginas.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbPaginas.setBounds(37, 256, 102, 37);
			contentPane.add(lbPaginas);
			
			JLabel lbPaginas1 = new JLabel(Integer.toString(Libro.getpaginas()));
			lbPaginas1.setForeground(Color.WHITE);
			lbPaginas1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbPaginas1.setBounds(155, 256, 168, 37);
			contentPane.add(lbPaginas1);
		}
		
		if(tipo==0 || tipo==1)
		{
			ClsAudioVisual Audiovisual = (ClsAudioVisual) Articulo;
			
			JLabel lbDuracion = new JLabel("Duracion:");
			lbDuracion.setForeground(Color.WHITE);
			lbDuracion.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbDuracion.setBounds(557, 256, 102, 37);
			contentPane.add(lbDuracion);
			
			JLabel lbDuracion1 = new JLabel(Integer.toString(Audiovisual.getDuracion())+ " min");
			lbDuracion1.setForeground(Color.WHITE);
			lbDuracion1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbDuracion1.setBounds(686, 256, 168, 37);
			contentPane.add(lbDuracion1);
			
			JLabel lbAno= new JLabel("Año:");
			lbAno.setForeground(Color.WHITE);
			lbAno.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbAno.setBounds(80, 255, 48, 37);
			contentPane.add(lbAno);
			
			JLabel lbAno1= new JLabel(Integer.toString(Audiovisual.getAno()));
			lbAno1.setForeground(Color.WHITE);
			lbAno1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbAno1.setBounds(155, 255, 168, 37);
			contentPane.add(lbAno1);
			
			if(tipo==2)
			{
				ClsDVD DVD = (ClsDVD) Articulo;
				
				JLabel lbOscar = new JLabel("Oscar:");
				lbOscar.setForeground(Color.WHITE);
				lbOscar.setFont(new Font("Tahoma", Font.BOLD, 21));
				lbOscar.setBounds(62, 303, 68, 37);
				contentPane.add(lbOscar);
				
				JLabel lbOscar1 = new JLabel(Integer.toString(DVD.getOscar()));
				lbOscar1.setForeground(Color.WHITE);
				lbOscar1.setFont(new Font("Tahoma", Font.BOLD, 21));
				lbOscar1.setBounds(155, 303, 68, 37);
				contentPane.add(lbOscar1);
			}
		}
		
		JLabel lblAadir = new JLabel("A\u00F1adir/Modificar Foto");
		lblAadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAadir.setForeground(Color.WHITE);
		lblAadir.setBounds(846, 636, 201, 32);
		contentPane.add(lblAadir);
		
		btnAtras = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		btnAtras.setBounds(10, 649, 57, 48);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		btnAdd = new JButton(new ImageIcon(getClass().getResource("/images/Add.png")));
		btnAdd.setBounds(1057, 636, 32, 32);
		btnAdd.setOpaque(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		btnAdd.addActionListener(this);
		contentPane.add(btnAdd);
		
		btnNext = new JButton(new ImageIcon(getClass().getResource("/images/Next.png")));
		btnNext.setBounds(558, 564, 57, 48);
		btnNext.setOpaque(false);
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		btnNext.addActionListener(this);
		
		btnPrevious = new JButton(new ImageIcon(getClass().getResource("/images/Previous.png")));
		btnPrevious.setBounds(37, 564, 57, 48);
		btnPrevious.setOpaque(false);
		btnPrevious.setContentAreaFilled(false);
		btnPrevious.setBorderPainted(false);
		btnPrevious.addActionListener(this);
				
		lblNumActu = new JLabel();
		lblNumActu.setForeground(Color.WHITE);
		lblNumActu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumActu.setBounds(306, 624, 99, 14);

		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(21, 345, 817, 302);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == btnAtras)
		{
			JFrameVerArticulos objVerArticulos= new JFrameVerArticulos(saberSiBusc,busqueda, ordenacion, adminOusu);
			objVerArticulos.setVisible(true);
			this.dispose();
		}
		if (botonPulsado == btnAdd)
		{
			String Url = JOptionPane.showInputDialog("Inserte la nueva Url");
			
			if(Url.equals("")==false)
			{
				BaseDatos.initBD("eLibrary.db");
				try {
					BaseDatos.cambiarImagenArticulo(Articulo, Url);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				Image image = null;
	            URL url;
				try {
					url = new URL(Url);
					image = ImageIO.read(url);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ImageIcon fot = new ImageIcon(image);
		        ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
		        imagen.setIcon(icono);
		        btnDelete.setVisible(true);
		        lblEliminarFoto.setVisible(true);
		        
		        setContentPane(contentPane);
			    contentPane.validate();
			    contentPane.repaint();
			}
		}
		if (botonPulsado == btnDelete)
		{		
			BaseDatos.initBD("eLibrary.db");
			try {
				BaseDatos.cambiarImagenArticulo(Articulo, "");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			imagen.setIcon(null);
			btnDelete.setVisible(false);
	        lblEliminarFoto.setVisible(false);

			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		if (botonPulsado == btnComentar)
		{
			textPane.setText("Escribe aqui tu comentario");
			textPane.setEditable(true);
			if(contentPane.isAncestorOf(btnNext))
			{
				contentPane.remove(btnNext);
			}
			if(contentPane.isAncestorOf(btnPrevious))
			{
				contentPane.remove(btnPrevious);
			}
			if(contentPane.isAncestorOf(btnComentar))
			{
				contentPane.remove(btnComentar);
			}
			
			contentPane.remove(lblNewLabel);
			contentPane.add(btnEnviar);
			contentPane.add(lblNewLabel);
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		if (botonPulsado == btnNext)
		{
			this.numAct++;
			textPane.setText(ComentariosArticulo.get(numAct-1).toString());
			lblNumActu.setText((numAct +" de "+ ComentariosArticulo.size()));
			
			contentPane.remove(lblNewLabel);
			
			if(numAct==ComentariosArticulo.size())
				contentPane.remove(btnNext);
			
			if(contentPane.isAncestorOf(btnPrevious)==false)
				contentPane.add(btnPrevious);
			
			contentPane.add(lblNewLabel);
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
		if (botonPulsado == btnPrevious)
		{
			this.numAct--;
			textPane.setText(ComentariosArticulo.get(numAct-1).toString());

			lblNumActu.setText((numAct +" de "+ ComentariosArticulo.size()));
			
			contentPane.remove(lblNewLabel);
			if(numAct==1)
				contentPane.remove(btnPrevious);
			
			if(contentPane.isAncestorOf(btnNext)==false)
				contentPane.add(btnNext);
			
			contentPane.add(lblNewLabel);
			
			setContentPane(contentPane);
		    contentPane.validate();
		    contentPane.repaint();
		}
//		if (botonPulsado == btnEnviar)
//		{
//			ClsComentario Comentario = new ClsComentario(Articulo.getNumero(),textPane.getText());
//			ComentariosArticulo.add(Comentario);
//			textPane.setText(ComentariosArticulo.get(ComentariosArticulo.size()-1).toString());
//			textPane.setEditable(true);
//			
//			ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
//			ArrayList<ClsComentario> ListaComentarios = Gestor.leerComentarios();
//			ListaComentarios.add(Comentario);			
//			Gestor.guardarComentarios(ListaComentarios);
//			
//			textPane.setText(ComentariosArticulo.get(numAct-1).toString());
//			lblNumActu.setText((numAct +" de "+ ComentariosArticulo.size()));
//			
//			if(contentPane.isAncestorOf(lblNumActu)==false)
//			contentPane.add(lblNumActu);
//
//			
//			contentPane.remove(btnEnviar);
//			contentPane.add(btnComentar);
//			if(ComentariosArticulo.size()>1) contentPane.add(btnNext);
//			contentPane.remove(lblNewLabel);
//			contentPane.add(lblNewLabel);
//			
//			setContentPane(contentPane);
//		    contentPane.validate();
//		    contentPane.repaint();
//		}
	}
}
