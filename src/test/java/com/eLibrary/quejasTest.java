package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import LNProyecto.ClsQuejas;

public class quejasTest {

	@Test
	public void test() {
		ClsQuejas queja = new ClsQuejas("Queja 1");
		assertNotNull(queja);
		
		String texto = queja.getQueja();
		assertNotNull(texto);
		
		String toString = queja.toString();
		assertNotNull(toString);
		
		
		}

}
