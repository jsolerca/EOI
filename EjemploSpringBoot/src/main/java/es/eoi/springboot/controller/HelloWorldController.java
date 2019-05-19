package es.eoi.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.eoi.springboot.service.HelloWorldService;

@RestController
@RequestMapping(value = "/helloWorld")
public class HelloWorldController {
	
	@Autowired
	private HelloWorldService service;
	
	@RequestMapping(method = RequestMethod.GET, value="/saluda1")
    public String saluda() {
        return service.saluda();
    }
	
	@RequestMapping(method = RequestMethod.GET, value="/saluda2")
    public ResponseEntity<String> saludaEntity() {
        return new ResponseEntity<>(
        		service.saluda(), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST, value="/saluda3")
    public ResponseEntity<String> getNombre(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(
        		service.saluda()
        		.concat(" ")
        		.concat(name), HttpStatus.OK);
    }
}
