package br.com.fisioterapia.fisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fisioterapia.fisioterapia.dto.ConsultaDTO;
import br.com.fisioterapia.fisioterapia.modelo.Paciente;
import br.com.fisioterapia.fisioterapia.repository.PacienteRepository;

@Service
public class PacienteService extends FisioterapiaService implements IPacienteService {
	
    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaDTO listar(String direction, Integer pageIndex) {
    	PageRequest pageRequest = criarPageRequest(direction, pageIndex);
    	ConsultaDTO dtoRetorno = new ConsultaDTO();
    	Page<Paciente> resultado = pacienteRepository.findAll(pageRequest);
    	dtoRetorno.setItems(resultado.getContent());
    	dtoRetorno.setTotalCount(resultado.getTotalElements());
    	return dtoRetorno;
    }
    
    public ConsultaDTO findByNomeContaining(String nome) {
    	List<Paciente> resultado = pacienteRepository.findByNomeContaining(nome);
    	ConsultaDTO dtoRetorno = new ConsultaDTO();
    	dtoRetorno.setItems(resultado);
    	dtoRetorno.setTotalCount(Long.valueOf(resultado.size()));
    	return dtoRetorno;
    }

}
