package LPProyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LDProyecto.BaseDatos;

import javax.swing.JTextArea;
import javax.swing.JButton;

import LNProyecto.ClsUnificadorDClases;

public class JFrameQueja extends JFrame implements ActionListener
{
	
	//para poder enviar quejas
	//vista para los clientes

	/**
	 * 
	 */
	private static final long serialVersionUID = 456983590530819147L;
	private JPanel contentPane;
	private JButton btnEnviar;
	private JTextArea textArea;
	private JButton btnAtras;
	public JFrameQueja() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtras = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
		btnAtras.setBounds(0, 214, 57, 48);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorderPainted(false);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
		
		textArea = new JTextArea();
		textArea.setBounds(27, 11, 372, 198);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		contentPane.add(textArea);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(176, 220, 89, 23);
		btnEnviar.addActionListener(this);
		contentPane.add(btnEnviar);
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton botonPulsado = (JButton)e.getSource();
		
		if (botonPulsado == btnEnviar)
		{
			BaseDatos.initBD("eLibrary.db");
			BaseDatos.crearTablaBDQ();			
			try 
			{
				BaseDatos.crearQueja(BaseDatos.getStatement(), textArea.getText());
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}			
			BaseDatos.close();
			
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
