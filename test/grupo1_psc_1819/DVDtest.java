package grupo1_psc_1819;

import static org.junit.Assert.*;

import org.junit.Test;

import LNProyecto.ClsDVD;

public class DVDtest {

	@Test
	 public void test() { 
		 ClsDVD nuevodvd = new ClsDVD("Monstruos SA" , 2, "Pixar", 5, 0, 0, 0, 0, 0, 0, 0, "a","a");
		 assertNotNull(nuevodvd);
    }

}
