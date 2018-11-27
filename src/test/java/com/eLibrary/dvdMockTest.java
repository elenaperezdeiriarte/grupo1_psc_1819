package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import LNProyecto.ClsCD;
import LNProyecto.ClsDVD;

public class dvdMockTest {

	String nombre;
	String song;

	@Mock
	ClsDVD mockDVD;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(mockDVD.isValidAuthor(nombre)).thenReturn(true);
		Mockito.when(mockDVD.isValidSong(song)).thenReturn(true);
	}
	
	@Test
	public void test() {
		assertTrue(mockDVD.isValidAuthor(nombre));
		assertTrue(mockDVD.isValidSong(song));
	}


}
