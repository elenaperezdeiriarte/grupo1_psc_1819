package LNProyecto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class ClsNumerador implements Serializable {
	private static final long serialVersionUID = 4325019101914012599L;
	private int numerador;
	private static final Logger log = Logger.getLogger(ClsNumerador.class.getName());

	public ClsNumerador() {
		this.setNumerador(0);
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public void aumentarNumerador() {
		this.numerador++;
	}

	public String toString() {
		int entero = this.numerador;
		String enteroString = Integer.toString(entero);
		return enteroString;
	}
}
