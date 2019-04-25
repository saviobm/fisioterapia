package br.com.fisioterapia.fisioterapia.service;

import br.com.fisioterapia.fisioterapia.dto.ConsultaDTO;

public interface IFisioterapiaService {
	
	ConsultaDTO listar(String direction, Integer pageIndex);

}
