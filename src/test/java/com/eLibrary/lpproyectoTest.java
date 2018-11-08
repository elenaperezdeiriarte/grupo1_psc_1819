package com.eLibrary;

import static org.junit.Assert.*;

import java.awt.Button;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.Test;

import LNProyecto.ClsArticulo;
import LNProyecto.ClsCD;
import LNProyecto.ClsDVD;
import LNProyecto.ClsLibro;
import LPProyecto.Inicio;
import LPProyecto.JFrameCFCD;
import LPProyecto.JFrameCFDVD;
import LPProyecto.JFrameCFLibro;
import LPProyecto.JFrameCambiarContrasena;
import LPProyecto.JFrameEstadisticas;
import LPProyecto.JFrameListaQuejasSugerencias;
import LPProyecto.JFrameMenuAdministrador;
import LPProyecto.JFrameMenuCliente;
import LPProyecto.JFrameMenuPrincipal;
import LPProyecto.JFrameModificarCD;
import LPProyecto.JFrameModificarDVD;
import LPProyecto.JFrameModificarLibro;
import LPProyecto.JFrameQueja;
import LPProyecto.JFrameSugerencia;
import LPProyecto.JFrameVerArticulos;
import LPProyecto.JFrameVerFicha;

public class lpproyectoTest {
	ClsArticulo art;

	@Test
	public void fichaTest() {
		art = new ClsArticulo(4, "Julen", "La casa azul", 5, 1, 7, 9, 0, "", "ja");	

			JFrameVerFicha fic = new JFrameVerFicha(art, 0, null, 0, 0, 0);
			assertNotNull(fic);
	}
	
	@Test
	public void inicioTest() {
		Inicio ini = new Inicio();
		assertNotNull(ini);
	}
	
	@Test
	public void cambiarContraTest() {
		JFrameCambiarContrasena cont = new JFrameCambiarContrasena();
		assertNotNull(cont);		
	}
	@Test
	public void cfarticuloTest() {
		JFrameCFCD cfcd = new JFrameCFCD(0, 0, null);
		assertNotNull(cfcd);
		
		JFrameCFDVD cfdvd = new JFrameCFDVD(0, 0, null);
		assertNotNull(cfdvd);
		
		JFrameCFLibro cflibro = new JFrameCFLibro(0, 0, null);
		assertNotNull(cflibro);		
	}
	
	
	
	@Test
	public void estadisticasTest() {
		JFrameEstadisticas esta = new JFrameEstadisticas(0);
		assertNotNull(esta);		
	}
	
	@Test
	public void listaquejaTest() {
		JFrameListaQuejasSugerencias quejsug = new JFrameListaQuejasSugerencias();
		assertNotNull(quejsug);		
	}
	@Test
	public void menuadminTest()
	{
		JFrameMenuAdministrador admin = new JFrameMenuAdministrador();
		assertNotNull(admin);
	}
	
	@Test
	public void menuclienteTest()
	{
		JFrameMenuCliente cli = new JFrameMenuCliente();
		assertNotNull(cli);
	}
	
	@Test
	public void menuprinTest()
	{
		JFrameMenuPrincipal prin = new JFrameMenuPrincipal();
		assertNotNull(prin);
	}
	
	@Test
	public void modificarcdTest()
	{
		ClsCD cd = new ClsCD("Bohemian Rhapsody", 7, "Queen", 7, 0, 0, 0, 0, 0, 0, "a", "a");
		JFrameModificarCD mcd = new JFrameModificarCD(cd, 0, 0, null);
		assertNotNull(mcd);		
	}
	
	@Test
	public void modificardvdTest()
	{
		ClsDVD dvd = new ClsDVD("Monstruos SA" , 2, "Pixar", 5, 0, 0, 0, 0, 0, 0, 0, "a","a");
		JFrameModificarDVD mdvd = new JFrameModificarDVD(dvd, 0, 0, null);
		assertNotNull(dvd);
	}
	
	@Test
	public void modificarlibroTest()
	{
		ClsLibro libro = new ClsLibro("El silmarilion", 500, "Tolkien", 0, 3, 0, 0, 0, 0, "a", "a");
		JFrameModificarLibro mlib = new JFrameModificarLibro(libro, 0, 0, null);
		assertNotNull(mlib);
	}
	
	@Test
	public void quejaTest()
	{
		JFrameQueja quej = new JFrameQueja();
		assertNotNull(quej);
	}
	
	@Test
	public void sugerenciaTest()
	{
		JFrameSugerencia seg = new JFrameSugerencia();
		assertNotNull(seg);
	}
	
	@Test
	public void verarticuloTest()
	{
		JFrameVerArticulos articulo = new JFrameVerArticulos(0, null, 0, 0);
		assertNotNull(articulo);
		
		JFrameVerArticulos articulo1 = new JFrameVerArticulos(0,null,1,1);
		assertNotNull(articulo1);
	}
	
	@Test
	public void botonesTest()
	{
		JButton but = new JButton("btnAtras");
		ActionEvent e = new ActionEvent(but, 0, "btnAtras");
		
		assertNotNull(e);
	}
	

}
