package LNProyecto;

import java.io.Serializable;

public class ClsNumerador implements Serializable
{
	private static final long serialVersionUID = 4325019101914012599L;
	private int numerador;
	
	public ClsNumerador()
	{
		this.setNumerador(0);
	}

	public int getNumerador() 
	{
		return numerador;
	}

	public void setNumerador(int numerador) 
	{
		this.numerador = numerador;
	}
	
	public void aumentarNumerador() 
	{
		this.numerador++;
	}
	
	public String toString()
	{
		int entero = this.numerador;
		String enteroString = Integer.toString(entero);
		return enteroString;
	}
}
