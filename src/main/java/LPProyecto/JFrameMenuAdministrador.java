package LPProyecto;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrameMenuAdministrador extends JFrame implements ActionListener {

	// Desarrollo del menu del administrador

	private static final long serialVersionUID = 2691647860492756196L;
	private PanelConImagen contentPane;
	private JButton btnArticulo;
	private JButton btnVerSugerencias;
	private JButton btnCambiarContrasena;
	private JButton btnVolverAlMenu;

	public JFrameMenuAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 300);
		contentPane = new PanelConImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		contentPane.setBackgroundImage(contentPane.createImage(
				"/images/administrador.png").getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnArticulo = new JButton("Ver articulos");
		btnArticulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArticulo.setBounds(280, 149, 193, 58);
		contentPane.add(btnArticulo);
		btnArticulo.addActionListener(this);

		btnVerSugerencias = new JButton("Ver Sugerencias/Quejas");
		btnVerSugerencias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerSugerencias.setBounds(280, 80, 193, 58);
		contentPane.add(btnVerSugerencias);
		btnVerSugerencias.addActionListener(this);

		btnCambiarContrasena = new JButton("Cambiar Contrase\u00F1a");
		btnCambiarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiarContrasena.setBounds(280, 11, 193, 58);
		contentPane.add(btnCambiarContrasena);
		btnCambiarContrasena.addActionListener(this);

		btnVolverAlMenu = new JButton(new ImageIcon(getClass().getResource(
				"/images/back.png")));
		btnVolverAlMenu.setBounds(0, 214, 48, 48);
		btnVolverAlMenu.setOpaque(false);
		btnVolverAlMenu.setContentAreaFilled(false);
		btnVolverAlMenu.setBorderPainted(false);
		btnVolverAlMenu.addActionListener(this);
		contentPane.add(btnVolverAlMenu);
	}

	public void actionPerformed(ActionEvent a) {
		JButton botonPulsado = (JButton) a.getSource();

		if (botonPulsado == btnArticulo) {
			JFrameVerArticulos objVerArticulos = new JFrameVerArticulos(0, "",
					0, 0);
			objVerArticulos.setVisible(true);

			this.dispose();
		}

		if (botonPulsado == btnCambiarContrasena) {
			JFrameCambiarContrasena objCambiarContrasena = new JFrameCambiarContrasena();
			objCambiarContrasena.setVisible(true);

			this.dispose();
		}

		if (botonPulsado == btnVerSugerencias) {
			JFrameListaQuejasSugerencias objQuejas = new JFrameListaQuejasSugerencias();
			objQuejas.setVisible(true);

			this.dispose();
		}

		if (botonPulsado == btnVolverAlMenu) {
			JFrameMenuPrincipal objPrincipal = new JFrameMenuPrincipal();
			objPrincipal.setVisible(true);
			this.dispose();
		}
	}
}
