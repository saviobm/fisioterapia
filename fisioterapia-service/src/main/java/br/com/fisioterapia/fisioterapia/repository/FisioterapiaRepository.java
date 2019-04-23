package br.com.fisioterapia.fisioterapia.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fisioterapia.fisioterapia.modelo.Fisioterapia;

public interface FisioterapiaRepository<T extends Fisioterapia> extends CrudRepository<T, Long> {

}
