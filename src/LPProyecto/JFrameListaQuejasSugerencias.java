package LPProyecto;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import LDProyecto.BaseDatos;
import LNProyecto.ClsQuejas;
import LNProyecto.ClsSugerencias;
import LNProyecto.ClsUnificadorDClases;
import LNProyecto.TableSugerencias;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;

public class JFrameListaQuejasSugerencias extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 3550010992905899764L;
	private JPanel contentPane;
	private TableSugerencias tasug;
	private JTable tableSug;
	private JButton btnLimpiarQuejas;
	private JButton btnLimpiarSuger;
	private JList list;
	private JButton jbVolver;

	
	public JFrameListaQuejasSugerencias() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(708,135,536,517);
		contentPane.add(scrollPane);
		
		jbVolver = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		jbVolver.setBounds(10, 646, 48, 48);
		jbVolver.setOpaque(false);
		jbVolver.setContentAreaFilled(false);
		jbVolver.setBorderPainted(false);
		jbVolver.addActionListener(this);
		contentPane.add(jbVolver);
		
		btnLimpiarQuejas = new JButton(new ImageIcon(getClass().getResource("/images/Trash_Delete.png")));
		btnLimpiarQuejas.setBounds(377, 55, 65, 41);
		btnLimpiarQuejas.setOpaque(false);
		btnLimpiarQuejas.setContentAreaFilled(false);
		btnLimpiarQuejas.setBorderPainted(false);
		btnLimpiarQuejas.addActionListener(this);
		contentPane.add(btnLimpiarQuejas);
		
		btnLimpiarSuger = new JButton(new ImageIcon(getClass().getResource("/images/Trash_Delete.png")));
		btnLimpiarSuger.setBounds(1084, 55, 65, 41);
		btnLimpiarSuger.setOpaque(false);
		btnLimpiarSuger.setContentAreaFilled(false);
		btnLimpiarSuger.setBorderPainted(false);
		btnLimpiarSuger.addActionListener(this);
		contentPane.add(btnLimpiarSuger);
		
		JLabel lblQuejas = new JLabel("Quejas");
		lblQuejas.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblQuejas.setForeground(Color.WHITE);
		lblQuejas.setBounds(245, 40, 150, 67);
		contentPane.add(lblQuejas);
		
		JLabel lblSugerencias = new JLabel("Sugerencias");
		lblSugerencias.setForeground(Color.WHITE);
		lblSugerencias.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblSugerencias.setBounds(854, 40, 230, 67);
		contentPane.add(lblSugerencias);
		
		
		
		BaseDatos.initBD("eLibrary.db");
		BaseDatos.crearTablaBDQ();
		try 
		{
			BaseDatos.selectQuejas();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		ArrayList<ClsQuejas> QuejasList = new ArrayList<ClsQuejas>();
		QuejasList = BaseDatos.getQuejas();
		BaseDatos.close();
			
		ClsQuejas[] ListQuej = new ClsQuejas[QuejasList.size()];
		
		for(int a = 0 ; a<QuejasList.size();a++)
		{
			ListQuej[a] = QuejasList.get(a);
		}
		
		list = new JList(ListQuej);
		list.setBounds(59,135,536,517);
		contentPane.add(list);
		
		
		
		BaseDatos.initBD("eLibrary.db");
		BaseDatos.crearTablaBDS();
		try 
		{
			BaseDatos.selectSugerencias();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		ArrayList<ClsSugerencias> SugerenciasList = new ArrayList<ClsSugerencias>();
		SugerenciasList = BaseDatos.getSugerencias();
		BaseDatos.close();
		
		if(SugerenciasList!=null)
		{	
			tasug = new TableSugerencias(SugerenciasList);
			tableSug = new JTable(tasug);
			scrollPane.setViewportView(tableSug);
			tableSug.setToolTipText("");
			tableSug.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
			tableSug.setFillsViewportHeight(true);
			tableSug.setEnabled(true);
			tableSug.setRowSelectionAllowed(true);
		}
	}


	public void actionPerformed(ActionEvent e) 
	{
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == jbVolver)
		{
			JFrameMenuAdministrador objMenuAdministrador = new JFrameMenuAdministrador();			
			objMenuAdministrador.setVisible(true);
			this.dispose();
		}
		if (botonPulsado == btnLimpiarQuejas)
		{
			BaseDatos.initBD("eLibrary.db");
			BaseDatos.eliminarTablaBDQ();
			BaseDatos.close();
			
			JFrameListaQuejasSugerencias objQuejas= new JFrameListaQuejasSugerencias();
			objQuejas.setVisible(true);
			this.dispose();		
		}
		if (botonPulsado == btnLimpiarSuger)
		{
			BaseDatos.initBD("eLibrary.db");
			BaseDatos.eliminarTablaBDS();
			BaseDatos.close();
			
			JFrameListaQuejasSugerencias objQuejas= new JFrameListaQuejasSugerencias();
			objQuejas.setVisible(true);			
			this.dispose();			
		}
		
	}
}
