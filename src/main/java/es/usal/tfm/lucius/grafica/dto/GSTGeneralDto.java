package es.usal.tfm.lucius.grafica.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GSTGENER")
public class GSTGeneralDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mes")
	private String mes;
	
	@Column(name="gastotal")
	private Double gastotal;
	
	@Column(name="capreal")
	private Integer capreal;
	
	@Column(name="capplant")
	private Integer capplant;

	public GSTGeneralDto() {
		super();
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Double getGastotal() {
		return gastotal;
	}

	public void setGastotal(Double gastotal) {
		this.gastotal = gastotal;
	}

	public int getCapreal() {
		return capreal;
	}

	public void setCapreal(int capreal) {
		this.capreal = capreal;
	}

	public int getCapplan() {
		return capplant;
	}

	public void setCapplan(int capplant) {
		this.capplant = capplant;
	}

}
