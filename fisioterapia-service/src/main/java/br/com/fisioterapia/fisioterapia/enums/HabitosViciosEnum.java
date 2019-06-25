package br.com.fisioterapia.fisioterapia.enums;

public enum HabitosViciosEnum {
	    
    TAB("Tabagista", "TAB"),
    EXTAB("Ex-Tabagista", "EXTAB"),
    ELIT("Etilista", "ELIT"),
    EXELIT("Etilista", "EXELIT");
	
	private String descricao;
	
	private String sigla;
	
	HabitosViciosEnum(String descricao, String sigla) {
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
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
