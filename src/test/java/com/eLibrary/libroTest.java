package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import LNProyecto.ClsLibro;

public class libroTest {

	@Test
	 public void test() { 
		 ClsLibro nuevolibro = new ClsLibro("El silmarilion", 500, "Tolkien", 0, 3, 0, 0, 0, 0, "a", "a");
		 assertNotNull(nuevolibro);
		 
		 String texto = nuevolibro.toString();
			assertNotNull(texto);
			
			
    }

}