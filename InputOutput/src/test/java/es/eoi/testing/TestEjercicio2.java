package es.eoi.testing;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import es.eoi.io.Ejercicio3;

public class TestEjercicio2 {

	@Test
	public void test() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("diarioEjercicio3.txt").getFile());
			Ejercicio3.leerDiario(file.getAbsolutePath());
	
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

}
