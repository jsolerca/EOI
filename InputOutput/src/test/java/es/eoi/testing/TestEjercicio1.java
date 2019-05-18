package es.eoi.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import es.eoi.io.Ejercicio1;

public class TestEjercicio1 {

	@Test
	public void test() {
		try {
			int total = Ejercicio1.suma(1, 1);
			assertEquals(total, 2);
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

}
