package br.com.fisioterapia.fisioterapia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fisioterapia.fisioterapia.modelo.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {
	
	List<Cidade> findByNomeContaining(String nome);

}
