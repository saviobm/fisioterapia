package br.com.fisioterapia.fisioterapia.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fisioterapia.fisioterapia.modelo.Cidade;
import br.com.fisioterapia.fisioterapia.repository.CidadeRepository;

@Service
public class CidadeService extends FisioterapiaService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findByNomeContaining(String nome) {
		return cidadeRepository.findByNomeContaining(nome);
	}

	public List<Cidade> findAll() {
		final Iterable<Cidade> source = cidadeRepository.findAll();
		return StreamSupport.stream(source.spliterator(), false).collect(Collectors.toList());
	}

}
