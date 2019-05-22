package br.com.fisioterapia.fisioterapia.enums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import br.com.fisioterapia.fisioterapia.dto.EnumDTO;

public enum EstadoCivilEnum {
	
	SOL("Solteiro", "SOL"),
	CAS("Casado", "CAS"),
	DIV("Divorciado", "DIV"),
	VIU("Viúvo(a)", "VIU");
	
	private String descricao;
	
	private String sigla;
	
	EstadoCivilEnum(String descricao, String sigla) {
		this.descricao = descricao;
		this.sigla = sigla;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	public static List<EnumDTO> getValues() {
		List<EnumDTO> listaRetorno = new ArrayList<>();
		EnumDTO enumDTO = null;
		for (EstadoCivilEnum item : values()) {
			enumDTO = new EnumDTO();
			enumDTO.setSigla(item.getSigla());
			enumDTO.setDescricao(item.getDescricao());
			listaRetorno.add(enumDTO);
		}
		return listaRetorno;
	}
	
	public static EstadoCivilEnum findByDescricaoEstadoCivil(String descricao) {
		if (!StringUtils.isEmpty(descricao)) {
			for (EstadoCivilEnum item : values()) {
				if (item.getDescricao().equalsIgnoreCase(descricao)) {
					return item;
				}
			}
		}
		return null;
	}
	
	public static EstadoCivilEnum findBySiglaEstadoCivil(String sigla) {
		if (!StringUtils.isEmpty(sigla)) {
			for (EstadoCivilEnum item : values()) {
				if (item.getSigla().equalsIgnoreCase(sigla)) {
					return item;
				}
			}
		}
		return null;
	}
	
}
