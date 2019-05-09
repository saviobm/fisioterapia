package br.com.fisioterapia.fisioterapia.dto;

import java.io.Serializable;
import java.util.List;

public class ConsultaDTO implements Serializable {
	
	/**
	 * total_count.
	 */
	private static final long serialVersionUID = 6158240938134017631L;

	private Long totalCount;
	
	private List<? extends FisioterapiaDTO> items;

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
	public List<? extends FisioterapiaDTO> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<? extends FisioterapiaDTO> items) {
		this.items = items;
	}

}
