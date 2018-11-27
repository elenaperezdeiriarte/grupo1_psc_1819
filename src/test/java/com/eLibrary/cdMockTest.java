package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import LNProyecto.ClsCD;


public class cdMockTest {
	
	String nombre;
	String song;

	@Mock
	ClsCD mockCD;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(mockCD.isValidAuthor(nombre)).thenReturn(true);
		Mockito.when(mockCD.isValidSong(song)).thenReturn(true);
	}
	
	@Test
	public void test() {
		assertTrue(mockCD.isValidAuthor(nombre));
		assertTrue(mockCD.isValidSong(song));
	}

}
