package br.com.fisioterapia.fisioterapia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fisioterapia.fisioterapia.modelo.Avaliacao;
import br.com.fisioterapia.fisioterapia.service.AvaliacaoService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/avaliacao")
public class AvaliacaoRestController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	
	@RequestMapping(path = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Avaliacao salvar(@RequestBody Avaliacao avaliacao) {
		return avaliacaoService.salvar(avaliacao);
	}

}
