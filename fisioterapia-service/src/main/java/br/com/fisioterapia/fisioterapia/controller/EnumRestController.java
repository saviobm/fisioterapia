package br.com.fisioterapia.fisioterapia.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fisioterapia.fisioterapia.enums.EstadoCivilEnum;

@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping(path = "/enums")
public class EnumRestController {
	
	@RequestMapping(path = "/estadoCivil", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<String> recuperarEstadoCivil() {
		return EstadoCivilEnum.getValues();
	}

}
