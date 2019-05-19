package es.eoi.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.eoi.springboot.service.HelloWorldService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EjemploSpringBootApplicationTests {
	
	@Autowired
	private HelloWorldService service;

	@Test
	public void contextLoads() {
		System.out.println(service.saluda());
	}

}
