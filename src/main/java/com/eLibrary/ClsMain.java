package com.eLibrary;


import org.apache.log4j.Logger;


import LPProyecto.JFrameMenuPrincipal;

//Clase main de la aplicación desde donde se lanza el programa.

public class ClsMain
{
	private static final Logger log = Logger.getLogger(ClsMain.class.getName());

	public static void main(String[] args)
	{
		JFrameMenuPrincipal objPrincipal = new JFrameMenuPrincipal();
		objPrincipal.setVisible(true);
	}
}
