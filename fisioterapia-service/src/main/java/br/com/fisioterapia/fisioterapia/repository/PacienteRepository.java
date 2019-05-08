package br.com.fisioterapia.fisioterapia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.fisioterapia.fisioterapia.modelo.Paciente;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long>, CrudRepository<Paciente, Long> {
	
	Iterable<Paciente> findAll(Sort sort);
	Page<Paciente> findAll(Pageable pageable);
	List<Paciente> findByNomeContaining(String nome);

}
