package br.com.fisioterapia.fisioterapia.service;

import br.com.fisioterapia.fisioterapia.modelo.Fisioterapia;
import br.com.fisioterapia.fisioterapia.repository.FisioterapiaRepository;

public interface FisioterapiaService<T extends Fisioterapia> {
	
	FisioterapiaRepository<T> getRepository();

}
