package com.eLibrary;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import LDProyecto.BaseDatos;

//
//Prueba test de cambiar la contra
//
public class julenTest {
	String nuevaContra = "Vividores";
	@Test
	public void test() {
		BaseDatos.initBD("eLibraryTest.db");
		BaseDatos.eliminarTablaBDU();
		BaseDatos.crearTablaBDU();
		try 
		{
			BaseDatos.cambiarContra(BaseDatos.getStatement(), nuevaContra);
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}		
		BaseDatos.close();
		
		
		BaseDatos.initBD("eLibraryTest.db");		
		BaseDatos.crearTablaBDU();		
		String bdContra = "";		
		try 
		{
			BaseDatos.devolverContra();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}		
		bdContra = BaseDatos.getContra();
		BaseDatos.close();
		
		assertEquals(bdContra, nuevaContra);		
	}
}
