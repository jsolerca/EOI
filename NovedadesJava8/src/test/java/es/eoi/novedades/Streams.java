package es.eoi.novedades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		
		List<String> palabras = new ArrayList<String>();
		palabras.add("Ballena");
		palabras.add("Caballo");
		palabras.add("Jirafa");
		palabras.add("Perro");
		palabras.add("Ratón");
		
		Stream st;
		
		st = palabras.stream();
		System.out.println(st.findFirst().get());
		st.close();
		
		st = palabras.stream();
		System.out.println(
				st.filter(p -> ((String) p).toLowerCase().contains("o")).count());
		st.close();
		
		st = palabras.stream();
		st.filter(p -> ((String) p).toLowerCase().contains("o")).forEach(System.out::println);	
		st.close();
	}
}
