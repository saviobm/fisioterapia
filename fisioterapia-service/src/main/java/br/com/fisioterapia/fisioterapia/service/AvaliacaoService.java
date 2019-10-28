package br.com.fisioterapia.fisioterapia.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fisioterapia.fisioterapia.dto.AvaliacaoDTO;
import br.com.fisioterapia.fisioterapia.modelo.Avaliacao;
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
		Avaliacao avaliacao = new Avaliacao();
		BeanUtils.copyProperties(avaliacaoDTO, avaliacao);
		obterObjetosCombos(avaliacaoDTO, avaliacao);		
		Avaliacao avaliacaoPersistida = avaliacaoRepository.save(avaliacao);
		BeanUtils.copyProperties(avaliacaoPersistida, avaliacaoDTO);
		return avaliacaoDTO;
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
