package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import LNProyecto.ClsContrasena;
import LNProyecto.ClsUnificadorDClases;
import LPProyecto.JFramePedirContra;


public class contrasenaTest {

	private JFramePedirContra contrasena = new JFramePedirContra();
	private ClsUnificadorDClases Gestor = new ClsUnificadorDClases();
	@Test
	public void test() {
		String password = Gestor.leerContra();
			
		assertTrue(!password.equals(""));
	}

}
