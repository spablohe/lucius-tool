package es.usal.tfm.lucius.estimador.dto;

import java.io.Serializable;

public class EstimadorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer piezas;
	
	private String fechaIn;
	
	private String fechaOut;
	
	private Double gastosFinancieros;
	
	private Double beneficios;

	public EstimadorDto() {
		super();
	}

	public Integer getPiezas() {
		return piezas;
	}

	public void setPiezas(Integer piezas) {
		this.piezas = piezas;
	}

	public String getFechaIn() {
		return fechaIn;
	}

	public void setFechaIn(String fechaIn) {
		this.fechaIn = fechaIn;
	}

	public String getFechaOut() {
		return fechaOut;
	}

	public void setFechaOut(String fechaOut) {
		this.fechaOut = fechaOut;
	}

	public Double getGastosFinancieros() {
		return gastosFinancieros;
	}

	public void setGastosFinancieros(Double gastosFinancieros) {
		this.gastosFinancieros = gastosFinancieros;
	}

	public Double getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Double beneficios) {
		this.beneficios = beneficios;
	}

}
