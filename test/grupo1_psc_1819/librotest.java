package grupo1_psc_1819;

import static org.junit.Assert.*;

import org.junit.Test;

import LNProyecto.ClsLibro;

public class librotest {

	@Test
	 public void test() { 
		 ClsLibro nuevolibro = new ClsLibro("El silmarilion", 500, "Tolkien", 0, 3, 0, 0, 0, 0, "a", "a");
		 assertNotNull(nuevolibro);
    }

}
