package br.com.fisioterapia.fisioterapia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fisioterapia.fisioterapia.dto.ConsultaDTO;
import br.com.fisioterapia.fisioterapia.dto.PacienteDTO;
import br.com.fisioterapia.fisioterapia.modelo.Paciente;
import br.com.fisioterapia.fisioterapia.service.PacienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/paciente")
public class PacienteRestController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@RequestMapping(path = "/listarPacientes/{direction}/{pageIndex}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ConsultaDTO listarPacientes(@PathVariable("direction") String direction, @PathVariable("pageIndex") Integer pageIndex) {
		return pacienteService.listar(direction, pageIndex);
	}
	
	@RequestMapping(path = "/findByNomeContaining", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ConsultaDTO listarPacientes(@RequestBody Paciente paciente) {
		if (!StringUtils.isEmpty(paciente.getNome())) {
			return pacienteService.findByNomeContaining(paciente.getNome());
		}
		return pacienteService.findAll();
	}
	
	@RequestMapping(path = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public PacienteDTO salvar(@RequestBody Paciente paciente) {
		return pacienteService.salvar(paciente);
	}
	
	
	@RequestMapping(path = "/findById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public PacienteDTO findById(@RequestBody Paciente paciente) {
		return pacienteService.findById(paciente);
	}

}
