package br.com.fisioterapia.fisioterapia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.fisioterapia.fisioterapia.dto.CidadeDTO;
import br.com.fisioterapia.fisioterapia.dto.EstadoDTO;
import br.com.fisioterapia.fisioterapia.modelo.Cidade;
import br.com.fisioterapia.fisioterapia.repository.CidadeRepository;

@Service
public class CidadeService extends FisioterapiaService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<CidadeDTO> findByNomeContaining(String nome) {
		return convertDTO(cidadeRepository.findByNomeContaining(nome));
	}

	private List<CidadeDTO> convertDTO(List<Cidade> listaCidade) {
		List<CidadeDTO> listaRetorno = new ArrayList<>();
		if (!CollectionUtils.isEmpty(listaCidade)) {
			CidadeDTO cidadeDTO = null;
			EstadoDTO estadoDTO = null;
			for (Cidade cidade : listaCidade) {
				cidadeDTO = new CidadeDTO();
				estadoDTO = new EstadoDTO();
				BeanUtils.copyProperties(cidade, cidadeDTO);
				BeanUtils.copyProperties(cidade.getEstado(), estadoDTO);
				cidadeDTO.setEstado(estadoDTO);
				listaRetorno.add(cidadeDTO);
			}
		}
		return listaRetorno;
	}

	public List<CidadeDTO> findAll() {
		final Iterable<Cidade> source = cidadeRepository.findAll();
		return convertDTO(StreamSupport.stream(source.spliterator(), false).collect(Collectors.toList()));
	}

}
