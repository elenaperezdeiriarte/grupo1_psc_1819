package com.eLibrary;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ articuloTest.class, cdTest.class, 
		//contrasenaTest.class,
		dvdTest.class, libroTest.class, lpproyectoPerfTest.class,
		//lpproyectoTest.class,
		quejasTest.class, unificadorTest.class })
public class AllTests {
	

}
