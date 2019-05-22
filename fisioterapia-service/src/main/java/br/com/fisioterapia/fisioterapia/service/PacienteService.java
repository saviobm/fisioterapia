package br.com.fisioterapia.fisioterapia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.fisioterapia.fisioterapia.dto.CidadeDTO;
import br.com.fisioterapia.fisioterapia.dto.ConsultaDTO;
import br.com.fisioterapia.fisioterapia.dto.EnderecoDTO;
import br.com.fisioterapia.fisioterapia.dto.EstadoDTO;
import br.com.fisioterapia.fisioterapia.dto.FisioterapiaDTO;
import br.com.fisioterapia.fisioterapia.dto.PacienteDTO;
import br.com.fisioterapia.fisioterapia.enums.EstadoCivilEnum;
import br.com.fisioterapia.fisioterapia.modelo.Endereco;
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
    	dtoRetorno.setItems(convertListaPacienteDTO(resultado.getContent()));
    	dtoRetorno.setTotalCount(resultado.getTotalElements());
    	return dtoRetorno;
    }

	private List<? extends FisioterapiaDTO> convertListaPacienteDTO(List<Paciente> listaPaciente) {
		List<PacienteDTO> listaRetorno = new ArrayList<>();
		if (!CollectionUtils.isEmpty(listaPaciente)) {
			for (Paciente paciente : listaPaciente) {
				listaRetorno.add(convertPacienteDTO(paciente));
			}
		}
		return listaRetorno;
	}

	/**
	 * @param listaRetorno
	 * @param paciente
	 */
	private PacienteDTO convertPacienteDTO(Paciente paciente) {
		PacienteDTO pacienteDTO = new PacienteDTO();
		BeanUtils.copyProperties(paciente, pacienteDTO);
		if (paciente != null && !CollectionUtils.isEmpty(paciente.getListaEndereco())) {
			List<EnderecoDTO> listaEndereco = new ArrayList<>();
			EnderecoDTO enderecoDTO = null;
			CidadeDTO cidadeDTO = null;
			EstadoDTO estadoDTO = null;
			for (Endereco endereco : paciente.getListaEndereco()) {
				enderecoDTO = new EnderecoDTO();
				cidadeDTO = new CidadeDTO();
				estadoDTO = new EstadoDTO();
				BeanUtils.copyProperties(endereco.getCidade(), cidadeDTO);
				BeanUtils.copyProperties(endereco, enderecoDTO);
				BeanUtils.copyProperties(endereco.getCidade().getEstado(), estadoDTO);
				cidadeDTO.setEstado(estadoDTO);
				enderecoDTO.setCidade(cidadeDTO);
				listaEndereco.add(enderecoDTO);
			}
			pacienteDTO.setListaEndereco(listaEndereco);
		}
		return pacienteDTO;
	}

	public ConsultaDTO findByNomeContaining(String nome) {
    	List<Paciente> resultado = pacienteRepository.findByNomeContaining(nome);
    	ConsultaDTO dtoRetorno = new ConsultaDTO();
    	dtoRetorno.setItems(convertListaPacienteDTO(resultado));
    	dtoRetorno.setTotalCount(Long.valueOf(resultado.size()));
    	return dtoRetorno;
    }
    
    public ConsultaDTO findAll() {
    	final Iterable<Paciente> source = pacienteRepository.findAll();
		List<Paciente> listaRetorno = StreamSupport.stream(source.spliterator(), false).collect(Collectors.toList());
    	ConsultaDTO dtoRetorno = new ConsultaDTO();
    	dtoRetorno.setItems(convertListaPacienteDTO(listaRetorno));
    	dtoRetorno.setTotalCount(Long.valueOf(listaRetorno.size()));
    	return dtoRetorno;
    }
    
    public PacienteDTO findById(Paciente paciente) {
    	Optional<Paciente> optionalPaciente = pacienteRepository.findById(paciente.getId());
    	if (optionalPaciente.isPresent()) {
    		paciente = optionalPaciente.get();
    	}
    	return convertPacienteDTO(paciente);
    }

	public PacienteDTO salvar(Paciente paciente) {
		preencherEnums(paciente);
		preencherPacienteEndereco(paciente);		
		return convertPacienteDTO(pacienteRepository.save(paciente));
	}

	private void preencherPacienteEndereco(Paciente paciente) {
		if (paciente != null && !CollectionUtils.isEmpty(paciente.getListaEndereco())) {
			for (Endereco endereco : paciente.getListaEndereco()) {
				endereco.setPaciente(paciente);
			}
		}
	}

	private void preencherEnums(Paciente paciente) {
		EstadoCivilEnum estadoCivilEnum = EstadoCivilEnum.findBySiglaEstadoCivil(paciente.getEstadoCivil());
		paciente.setEstadoCivil(estadoCivilEnum.getSigla());
	}

}
