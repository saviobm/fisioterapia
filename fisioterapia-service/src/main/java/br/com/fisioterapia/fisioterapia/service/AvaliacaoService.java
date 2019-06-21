package br.com.fisioterapia.fisioterapia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fisioterapia.fisioterapia.modelo.Avaliacao;
import br.com.fisioterapia.fisioterapia.modelo.Patologia;
import br.com.fisioterapia.fisioterapia.repository.AvaliacaoRepository;
import br.com.fisioterapia.fisioterapia.repository.PatologiaRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private PatologiaRepository patologiaRepository;
	
	public Avaliacao salvar(Avaliacao avaliacao) {
		obterObjetosCombos(avaliacao);		
		Avaliacao avaliacaoPersistida = null;
		try {
			avaliacaoPersistida = avaliacaoRepository.save(avaliacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return avaliacaoPersistida;
	}

	private void obterObjetosCombos(Avaliacao avaliacao) {
		if (avaliacao.getPatologia() != null 
				&& avaliacao.getPatologia().getId() != null) {
			Optional<Patologia> patologia = patologiaRepository.findById(avaliacao.getPatologia().getId());
			if (patologia.isPresent()) {
				avaliacao.setPatologia(patologia.get());
			}
		}
	}

}
