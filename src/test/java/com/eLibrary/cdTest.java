package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import LNProyecto.ClsCD;

public class cdTest {

	@Test
	 public void test() { 
		 ClsCD nuevocd = new ClsCD("Bohemian Rhapsody", 7, "Queen", 7, 0, 0, 0, 0, 0, 0, "a", "a");
		 assertNotNull(nuevocd);
		 
		String texto = nuevocd.toString();
		assertNotNull(texto);
    }

}