package br.com.fisioterapia.fisioterapia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
import br.com.fisioterapia.fisioterapia.util.FisioterapiaUtil;

@Service
public class PacienteService extends FisioterapiaService implements IPacienteService {
	
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
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

	public Boolean delete(Long idPaciente) {
		Optional<Paciente> resultado = pacienteRepository.findById(idPaciente);
		if (resultado.isPresent()) {
			Paciente paciente = resultado.get();
			pacienteRepository.delete(paciente);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@SuppressWarnings("unchecked")
	public ConsultaDTO pesquisarPaciente(Paciente paciente) {
		StringBuilder sb = new StringBuilder();
		sb.append(" from Paciente where 1 = 1");
		if (!StringUtils.isEmpty(paciente.getCpf())) {
			sb.append(" and cpf = :cpf");
		}
		Query query = getEntityManager().createQuery(sb.toString());
		if (!StringUtils.isEmpty(paciente.getCpf())) {
			query.setParameter("cpf", FisioterapiaUtil.retirarMascaraCpf(paciente.getCpf()));
		}
		List<Paciente> listaRetultado = (List<Paciente>)query.getResultList();
		if (!listaRetultado.isEmpty()) {
			return preencherConsultaDTO(listaRetultado);
		}
		return null;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private ConsultaDTO preencherConsultaDTO(List<Paciente> listaPaciente) {
		ConsultaDTO dtoRetorno = new ConsultaDTO();
		dtoRetorno.setItems(convertListaPacienteDTO(listaPaciente));
    	dtoRetorno.setTotalCount(Long.valueOf(listaPaciente.size()));
    	return dtoRetorno;
	}

}
