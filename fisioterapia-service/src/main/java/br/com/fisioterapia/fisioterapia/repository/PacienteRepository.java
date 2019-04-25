package br.com.fisioterapia.fisioterapia.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fisioterapia.fisioterapia.modelo.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
