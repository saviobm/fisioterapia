package br.com.fisioterapia.fisioterapia.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fisioterapia.fisioterapia.modelo.Patologia;
import br.com.fisioterapia.fisioterapia.repository.PatologiaRepository;

@Service
public class PatologiaService extends FisioterapiaService {

	@Autowired
	private PatologiaRepository patologiaRepository;
	
	public List<Patologia> listarPatologias() {
		final Iterable<Patologia> source = patologiaRepository.findAll();
		return StreamSupport.stream(source.spliterator(), false).collect(Collectors.toList());
	}
	
}
