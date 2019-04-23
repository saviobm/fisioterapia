package br.com.fisioterapia.fisioterapia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fisioterapia.fisioterapia.modelo.Fisioterapia;
import br.com.fisioterapia.fisioterapia.repository.FisioterapiaRepository;

@Service
public class FisioterapiaServiceImpl<T extends Fisioterapia> implements FisioterapiaService<T> {
	
	@Autowired
	private FisioterapiaRepository<T> repository;

	/**
	 * @return the repository
	 */
	public FisioterapiaRepository<T> getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(FisioterapiaRepository<T> repository) {
		this.repository = repository;
	}
	
}
