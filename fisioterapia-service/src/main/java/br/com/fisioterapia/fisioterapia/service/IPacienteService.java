package br.com.fisioterapia.fisioterapia.service;

import br.com.fisioterapia.fisioterapia.dto.ConsultaDTO;

public interface IPacienteService extends IFisioterapiaService {
	
	ConsultaDTO findByNomeContaining(String nome);
	
}
