package es.eoi.springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldRepositoryImpl implements HelloWorldRepository {

	public String saluda() {
		return "Hola";
	}

}
