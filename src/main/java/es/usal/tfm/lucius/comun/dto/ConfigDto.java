package es.usal.tfm.lucius.comun.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONFIG")
public class ConfigDto {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="value")
	private String value;

	public ConfigDto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
