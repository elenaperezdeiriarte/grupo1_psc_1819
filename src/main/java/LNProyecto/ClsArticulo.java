package LNProyecto;

//Clase en la que se definen los atributos de los articulos
import java.io.Serializable;

@SuppressWarnings("rawtypes")
public class ClsArticulo implements Comparable, Serializable 
{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String autor;
	private int numero;
	private double nota; //guarda la nota del articulo
	private int estado; //0=Disponible 1=Prestado
	private int contador; //Veces prestado
	private int numVotos; //guarda el numero de votos del articulo
	private int tipo; //0=CD 1=DVD 2=Libro
	private String web;
	private String imagen; //hipervinculo a la imagen

	public ClsArticulo (int numero, String nombre, String autor, double nota, int estado, int contador, int numVotos, int tipo, String web, String imagen)
	{
		this.web= web;
		this.numero = numero;
		this.nombre = nombre;
		this.autor = autor;
		this.nota = nota ; //nota del articulo
		this.estado = estado;
		this.contador = contador;
		this.numVotos = numVotos;
		this.tipo = tipo;
		this.imagen = imagen;
	}	
	
	public int compareTo (Object o)
	{
		ClsArticulo a = (ClsArticulo)o;
		
		if(this.numero>a.getNumero()) return 1;
		if(this.numero<a.getNumero()) return -1;
				
		return 0;
	}
	
	//devuelve el numero de votos de un articulo
	public int getNumVotos() {
		return numVotos;
	}
	
	//asigna los numeros de votos introducidos a un articulo
	public void setNumVotos(int numVotos) {
		this.numVotos = numVotos;
	}
	
	public double getNota() {
		return nota;
	}

	public void setNota (double notapersona, double nota, int numVotos) 
	{
		double suma = nota*numVotos;
		this.nota = (suma+notapersona)/(numVotos+1);
	 }
	
	public int getEstado() {
		return estado;
	}

	public void setEstado (int estado) {
		this.estado = estado;
	}
	
	public int getContador() {
		return contador;
	}

	public void setContador (int contador) {
		this.contador = contador;
	}	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int cambiarNumero(int articulo) {
		if(articulo==this.numero)
		{
			return this.numero;
		}
		else
		{
			return 0;
		}
	}
	
	
	public String toString()
	{
		StringBuffer salida = new StringBuffer();
		
		salida.append(" numero ");
		salida.append(this.numero);
		salida.append(" con el nombre ");
		salida.append(this.nombre);
		salida.append(" cuyo autor es ");
		salida.append(this.autor);
		salida.append(" y tiene una nota de ");
		salida.append(this.nota);
		salida.append(" que esta ");
		
		if(estado==0)
		salida.append("disponible");
		else
		salida.append("prestado");
		
		salida.append(" que ha sido prestado ");
		salida.append(this.contador);
		salida.append(" veces ");
		
		return salida.toString();
	}
	
	public boolean equals (Object o)
	{
		if(o==null) return false;
		
		ClsArticulo Articulo = (ClsArticulo) o;
		
		if(this.getNombre().equals(Articulo.getNombre()))
			if(this.getAutor().equals(Articulo.getAutor()))
				if(this.getTipo()==Articulo.getTipo())
					return true;
		
		return false;
		
	}
	
	public int hashCode()
	{
		return this.getNombre().hashCode();
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
