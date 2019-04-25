package br.com.fisioterapia.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fisioterapia.fisioterapia.modelo.Paciente;
import br.com.fisioterapia.fisioterapia.repository.PacienteRepository;

@Service
public class PacienteService implements IPacienteService {
	
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
    	return (List<Paciente>)pacienteRepository.findAll();
    }
    
}
