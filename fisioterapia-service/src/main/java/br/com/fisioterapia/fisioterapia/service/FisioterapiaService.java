package br.com.fisioterapia.fisioterapia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.com.fisioterapia.fisioterapia.propriedades.FisioterapiaProperties;

public class FisioterapiaService {

	@Autowired
	private FisioterapiaProperties fisioterapiaProperties;
	
	/**
	 * Cria o objeto PageRequest para as consultas
	 * 
	 * @param direction
	 * @param pageIndex
	 * @return
	 */
	public PageRequest criarPageRequest(String direction, Integer pageIndex) {
		Integer qtd = Integer.valueOf(fisioterapiaProperties.getPropriedade("quantidade.registros.por.pagina"));
		return PageRequest.of(pageIndex, qtd, Sort.by(Sort.Direction.valueOf(direction.toUpperCase()), "nome"));
	}

}
