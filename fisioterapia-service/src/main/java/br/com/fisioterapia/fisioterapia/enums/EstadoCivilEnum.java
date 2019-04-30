package br.com.fisioterapia.fisioterapia.enums;

import java.util.ArrayList;
import java.util.List;

public enum EstadoCivilEnum {
	
	SOL("Solteiro"),
	CAS("Casado"),
	DIV("Divorciado"),
	VIU("Viúvo(a)");
	
	private String sgEstadoCivil;
	
	EstadoCivilEnum(String sgEstadoCivil) {
		this.sgEstadoCivil = sgEstadoCivil;
	}

	/**
	 * @return the sgEstadoCivil
	 */
	public String getSgEstadoCivil() {
		return sgEstadoCivil;
	}
	
	public static List<String> getValues() {
		List<String> listaRetorno = new ArrayList<>();
		for (EstadoCivilEnum item : values()) {
			listaRetorno.add(item.getSgEstadoCivil());
		}
		return listaRetorno;
	}
	
}
