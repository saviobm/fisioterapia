package br.com.fisioterapia.fisioterapia.enums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public enum EstadoCivilEnum {
	
	SOL("Solteiro", "SOL"),
	CAS("Casado", "CAS"),
	DIV("Divorciado", "DIV"),
	VIU("Viúvo(a)", "VIU");
	
	private String descricaoEstadoCivil;
	
	private String sgEstadoCivil;
	
	EstadoCivilEnum(String descricaoEstadoCivil, String sgEstadoCivil) {
		this.descricaoEstadoCivil = descricaoEstadoCivil;
		this.sgEstadoCivil = sgEstadoCivil;
	}

	/**
	 * @return the sgEstadoCivil
	 */
	public String getSgEstadoCivil() {
		return sgEstadoCivil;
	}
	
	/**
	 * @return the descricaoEstadoCivil
	 */
	public String getDescricaoEstadoCivil() {
		return descricaoEstadoCivil;
	}

	public static List<String> getValues() {
		List<String> listaRetorno = new ArrayList<>();
		for (EstadoCivilEnum item : values()) {
			listaRetorno.add(item.getDescricaoEstadoCivil());
		}
		return listaRetorno;
	}
	
	public static EstadoCivilEnum findByDescricaoEstadoCivil(String descricaoEstadoCivil) {
		if (!StringUtils.isEmpty(descricaoEstadoCivil)) {
			for (EstadoCivilEnum item : values()) {
				if (item.getDescricaoEstadoCivil().equalsIgnoreCase(descricaoEstadoCivil)) {
					return item;
				}
			}
		}
		return null;
	}
	
}
