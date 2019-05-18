package es.eoi.springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository {

	public String getNombre() {
		return "Javi";
	}

}
