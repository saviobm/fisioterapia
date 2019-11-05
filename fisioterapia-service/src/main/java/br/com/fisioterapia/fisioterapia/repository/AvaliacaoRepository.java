package br.com.fisioterapia.fisioterapia.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.fisioterapia.fisioterapia.modelo.Avaliacao;

public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {
	
	Optional<Avaliacao> findById(Long primaryKey);

}
