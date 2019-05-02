package br.com.fisioterapia.fisioterapia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import br.com.fisioterapia.fisioterapia.modelo.Fisioterapia;
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
	
	public List convert(Iterable<? extends Fisioterapia> iteratable) {
		List<Fisioterapia> listaRetorno = new ArrayList<>();
		if (iteratable != null) {
			while (iteratable.iterator().hasNext()) {
				Fisioterapia item = iteratable.iterator().next();
				listaRetorno.add(item);
			}
		}
		return listaRetorno;
	}

}
