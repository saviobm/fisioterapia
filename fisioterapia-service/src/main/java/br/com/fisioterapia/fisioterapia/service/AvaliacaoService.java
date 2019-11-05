package br.com.fisioterapia.fisioterapia.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.com.fisioterapia.fisioterapia.dto.AvaliacaoDTO;
import br.com.fisioterapia.fisioterapia.dto.CkDTO;
import br.com.fisioterapia.fisioterapia.dto.PatologiaDTO;
import br.com.fisioterapia.fisioterapia.modelo.Avaliacao;
import br.com.fisioterapia.fisioterapia.modelo.EstadoEmocional;
import br.com.fisioterapia.fisioterapia.modelo.Paciente;
import br.com.fisioterapia.fisioterapia.modelo.Patologia;
import br.com.fisioterapia.fisioterapia.repository.AvaliacaoRepository;
import br.com.fisioterapia.fisioterapia.repository.PacienteRepository;
import br.com.fisioterapia.fisioterapia.repository.PatologiaRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private PatologiaRepository patologiaRepository;
	
	public AvaliacaoDTO salvar(AvaliacaoDTO avaliacaoDTO) {
		Avaliacao avaliacao = null;
		if (avaliacaoDTO != null && avaliacaoDTO.getId() != null) {
			Optional<Avaliacao> optionalAvaliacao = avaliacaoRepository.findById(avaliacaoDTO.getId());
			if (optionalAvaliacao.isPresent()) {
	    		avaliacao = optionalAvaliacao.get();
	    	}
		} else {
			avaliacao = new Avaliacao();
		}
		BeanUtils.copyProperties(avaliacaoDTO, avaliacao,
				"listaEstadoEmocional", "listaHabitosVicios", "listaNivelConsciencia", "listaPontos",
						"listaRitmo", "listaSinaisVitais", "listaSistemaRespiratorio");
		obterObjetosCombos(avaliacaoDTO, avaliacao);
		preencherListaEstadoEmocional(avaliacaoDTO, avaliacao);
		Avaliacao avaliacaoPersistida = avaliacaoRepository.save(avaliacao);		
		BeanUtils.copyProperties(avaliacaoPersistida, avaliacaoDTO);
		copyListaEstadoEmocional(avaliacaoPersistida, avaliacaoDTO);
		if (avaliacaoPersistida.getPatologia() == null) {
			avaliacaoDTO.setPatologia(new PatologiaDTO());
		}
		return avaliacaoDTO;
	}

	private void copyListaEstadoEmocional(Avaliacao avaliacaoPersistida, AvaliacaoDTO avaliacaoDTO) {
		if (avaliacaoPersistida != null && !CollectionUtils.isEmpty(avaliacaoPersistida.getListaEstadoEmocional())) {
			List<CkDTO> listaEstadoEmocionalDTO = new ArrayList<>();
			for (EstadoEmocional estadoEmocional : avaliacaoPersistida.getListaEstadoEmocional()) {
				CkDTO ckDTO = new CkDTO();
				ckDTO.setId(estadoEmocional.getId());
				List<String> listaSigla = new ArrayList<>();
				listaSigla.add(estadoEmocional.getSigla());
				ckDTO.setSigla(listaSigla);
				ckDTO.setTitulo(estadoEmocional.getTitulo());
				ckDTO.setSelecionado(Boolean.TRUE);
				listaEstadoEmocionalDTO.add(ckDTO);
			}
			avaliacaoDTO.setListaEstadoEmocional(listaEstadoEmocionalDTO);
		}
	}

	private void preencherListaEstadoEmocional(AvaliacaoDTO avaliacaoDTO, Avaliacao avaliacao) {
		if (!CollectionUtils.isEmpty(avaliacaoDTO.getListaEstadoEmocional())) {
			if (!CollectionUtils.isEmpty(avaliacao.getListaEstadoEmocional())) {
				avaliacao.getListaEstadoEmocional().removeAll(avaliacao.getListaEstadoEmocional());
			} else {
				avaliacao.setListaEstadoEmocional(new ArrayList<>());
			}
			for (CkDTO ckDTO : avaliacaoDTO.getListaEstadoEmocional()) {
				EstadoEmocional estadoEmocional = new EstadoEmocional();
				if (ckDTO.getId() != null) {
					estadoEmocional.setId(ckDTO.getId());
				}
				estadoEmocional.setTitulo(ckDTO.getTitulo());
				String sigla = Arrays.toString(ckDTO.getSigla().toArray());
				if (!StringUtils.isEmpty(sigla)) {
					estadoEmocional.setSigla(sigla.replace("[", "").replace("]", ""));
				}
				estadoEmocional.setAvaliacao(avaliacao);
				avaliacao.getListaEstadoEmocional().add(estadoEmocional);
			}
		}
	}

	private void obterObjetosCombos(AvaliacaoDTO avaliacaoDTO, Avaliacao avaliacao) {
		// Patologia
		if (avaliacaoDTO.getPatologia() != null 
				&& avaliacaoDTO.getPatologia().getId() != null) {
			Optional<Patologia> patologia = patologiaRepository.findById(avaliacaoDTO.getPatologia().getId());
			if (patologia.isPresent()) {
				avaliacao.setPatologia(patologia.get());
			}
		}
		// Paciente 
		if (avaliacaoDTO.getPaciente() != null 
				&& avaliacaoDTO.getPaciente().getId() != null) {
			Optional<Paciente> paciente = pacienteRepository.findById(avaliacaoDTO.getPaciente().getId());
			if (paciente.isPresent()) {
				avaliacao.setPaciente(paciente.get());
			}
		}
	}

}
