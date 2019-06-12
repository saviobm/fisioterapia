package br.com.fisioterapia.fisioterapia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fisioterapia.fisioterapia.modelo.Patologia;
import br.com.fisioterapia.fisioterapia.service.PatologiaService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/patologia")
public class PatologiaRestController {
	
	@Autowired
	private PatologiaService patologiaService;
	
	@RequestMapping(path = "/listarPatologias", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Patologia> listarPatologias() {
		return patologiaService.listarPatologias();
	}

}
