package es.eoi.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.eoi.springboot.repository.HelloWorldRepository;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
	
	@Autowired
	private HelloWorldRepository repository;

	public String saluda() {
		return repository.saluda();
	}

}
