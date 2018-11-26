package com.eLibrary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import LNProyecto.ClsCD;


public class cdMockTest {
	
	ClsCD addingSong;

	@Mock
	ClsCD mockCD;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		Mockito.when(mockCD.isValidMusic(addingSong)).thenReturn(true);
	}
	
	@Test
	public void test() {
		assertTrue(mockCD.isValidMusic(addingSong));
	}

}
