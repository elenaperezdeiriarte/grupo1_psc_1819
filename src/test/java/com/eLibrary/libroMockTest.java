package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import LNProyecto.ClsDVD;
import LNProyecto.ClsLibro;

public class libroMockTest {

	String nombre;
	String song;

	@Mock
	ClsLibro mockLibros;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(mockLibros.isValidAuthor(nombre)).thenReturn(true);
		Mockito.when(mockLibros.isValidSong(song)).thenReturn(true);
	}
	
	@Test
	public void test() {
		assertTrue(mockLibros.isValidAuthor(nombre));
		assertTrue(mockLibros.isValidSong(song));
	}

}
