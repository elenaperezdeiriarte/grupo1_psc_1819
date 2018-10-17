package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import LNProyecto.ClsUnificadorDClases;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class JFrameSugerencia extends JFrame implements ActionListener
{
 //mostrar sugerencia por pantalla
	private static final long serialVersionUID = 456983590530819147L;
	private JPanel contentPane;
	private JButton btnEnviar;
	private JLabel lblTipo;
	private JTextField textNombre;
	private JTextField textAutor;
	private JRadioButton rdbtnCd;
	private JRadioButton rdbtnDvd;
	private JRadioButton rdbtnLibro;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnAtras;
	public JFrameSugerencia() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtras = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		btnAtras.setBounds(10, 203, 57, 48);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(176, 220, 89, 23);
		btnEnviar.addActionListener(this);
		contentPane.add(btnEnviar);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(42, 31, 56, 18);
		contentPane.add(lblTipo);
		
		rdbtnCd = new JRadioButton("CD");
		buttonGroup.add(rdbtnCd);
		rdbtnCd.setBounds(105, 31, 46, 23);
		contentPane.add(rdbtnCd);
		
		rdbtnDvd = new JRadioButton("DVD");
		buttonGroup.add(rdbtnDvd);
		rdbtnDvd.setBounds(176, 31, 61, 23);
		contentPane.add(rdbtnDvd);
		
		rdbtnLibro = new JRadioButton("Libro");
		buttonGroup.add(rdbtnLibro);
		rdbtnLibro.setBounds(239, 31, 56, 23);
		contentPane.add(rdbtnLibro);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(24, 94, 63, 18);
		contentPane.add(lblNombre);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor.setBounds(42, 161, 56, 18);
		contentPane.add(lblAutor);
		
		textNombre= new JTextField();
		textNombre.setBounds(146, 94, 119, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(146, 162, 119, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == btnEnviar)
		{
			ClsUnificadorDClases cambio = new ClsUnificadorDClases();
			String tipo;
			
			if (rdbtnCd.isSelected()) 
			{
	            tipo = "CD";
	        }
			else if (rdbtnDvd.isSelected()) 
			{
	            tipo = "DVD";
	        } 
			else 
			{
	            tipo = "Libro";
	        }
			cambio.NuevaSugerencia(textNombre.getText(), textAutor.getText(), tipo);
			
			JFrameMenuCliente objCliente = new JFrameMenuCliente();
			
			objCliente.setVisible(true);
			
			this.dispose();
		}
		if (botonPulsado == btnAtras)
		{
			JFrameMenuCliente objCliente = new JFrameMenuCliente();
			
			objCliente.setVisible(true);
			
			this.dispose();
		}
	}
}
