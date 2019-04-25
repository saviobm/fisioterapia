package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;
import java.util.List;

import br.com.fisioterapia.fisioterapia.modelo.Fisioterapia;

public class ConsultaDTO implements Serializable {
	
	/**
	 * total_count.
	 */
	private static final long serialVersionUID = 6158240938134017631L;

	private Long totalCount;
	
	private List<? extends Fisioterapia> items;

	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the items
	 */
	public List<? extends Fisioterapia> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<? extends Fisioterapia> items) {
		this.items = items;
	}

}
