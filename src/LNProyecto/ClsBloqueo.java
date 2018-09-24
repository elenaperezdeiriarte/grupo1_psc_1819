package LNProyecto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class ClsBloqueo implements Serializable 
{
	
	private static final long serialVersionUID = -7956610234382749357L;
	private Date now1;
	private Date now2;
	private Date now3;
	private Date now4;
	private int intentado;

	public int sacarSemaforo()
	{
		sumarMinutoFecha();
		
		now3 = new Date();
		
		int semaforo;
		
		if (now3.before(now2))
		{
			semaforo = 1;
			return semaforo;
		}
		else
		{
			semaforo = 0;
			return semaforo;
		}
	}
	
	
	public void sumarMinutoFecha()
 	{
	       Calendar calendar = Calendar.getInstance();
	       calendar.setTime(now1); // Configuramos la fecha de antes
	       calendar.add(Calendar.MINUTE, intentado);  // numero de minutos a añadir
	       this.now2 = calendar.getTime(); // Da valor al atributo now2 con los nuevos minutos añadidos
	}
	
	public void sacarMinutos()
	{
		this.now1 = new Date();
	}
	
	public long sacarFalta()
	{
		this.now4 = new Date();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(now4);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(now2);
		
		long milis1 = cal1.getTimeInMillis();
		long milis2 = cal2.getTimeInMillis();
		
		long falta = (milis1-milis2)/1000;
		return falta;
	}
	
	public void reiniciarIntentos()
	{
		this.intentado = 0;
	}
	
	public void setIntentos()
	{
		this.intentado++;
	}
	
	public int getIntentos()
	{
		return this.intentado;
	}
	
	public String toString(Object o)
	{
		StringBuffer salida = new StringBuffer();
		
		salida.append("Intento numero: " + intentado);
		return salida.toString(); 
		
	}
}
