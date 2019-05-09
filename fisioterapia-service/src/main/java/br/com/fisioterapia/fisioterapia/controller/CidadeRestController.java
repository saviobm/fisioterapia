package br.com.fisioterapia.fisioterapia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fisioterapia.fisioterapia.dto.CidadeDTO;
import br.com.fisioterapia.fisioterapia.modelo.Cidade;
import br.com.fisioterapia.fisioterapia.service.CidadeService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping(path = "/cidade")
public class CidadeRestController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(path = "/findByNomeContaining", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<CidadeDTO> listarCidades(@RequestBody Cidade cidade) {
		return cidadeService.findByNomeContaining(cidade.getNome());
	}
	
	@RequestMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<CidadeDTO> findAll() {
		return cidadeService.findAll();
	}

}
