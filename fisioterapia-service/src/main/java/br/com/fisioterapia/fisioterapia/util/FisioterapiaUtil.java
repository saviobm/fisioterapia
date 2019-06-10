package br.com.fisioterapia.fisioterapia.util;

public class FisioterapiaUtil {
	
	/**
	 * Remove a máscara do CPF.
	 * @param cpf
	 * @return string sem máscara.
	 */
	public static String retirarMascaraCpf(String cpf) {
		if (cpf != null) {
			cpf = cpf.replaceAll("[^0-9]*", "");
		}
		return cpf;
	}

}
