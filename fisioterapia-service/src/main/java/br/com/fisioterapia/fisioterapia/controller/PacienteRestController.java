package br.com.fisioterapia.fisioterapia.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fisioterapia.fisioterapia.dto.ConsultaDTO;
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
	
	@RequestMapping(path = "/listarPacientes/{findBy}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ConsultaDTO listarPacientes(@PathVariable("findBy") String findBy) {
		Class<?> c;
		Method method;
		try {
			c = Class.forName(PacienteService.class.getName());
			method = c.getDeclaredMethod("findBy" + findBy, null);
			return (ConsultaDTO)method.invoke(pacienteService);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
