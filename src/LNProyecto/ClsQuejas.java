package LNProyecto;

import java.io.Serializable;
//se crea la clase quejas

public class ClsQuejas implements Serializable
{
	private static final long serialVersionUID = -5913412847978581167L;
	private String queja;

	public ClsQuejas(String queja) 
	{
		this.queja = queja;
	}

	public String getQueja() 
	{
		return queja;
	}

	public void setQueja(String queja) 
	{
		this.queja = queja;
	}
	
	public String toString()
	{
		StringBuffer salida = new StringBuffer();
		
		salida.append(this.queja);
	
		return salida.toString();
	}
}
