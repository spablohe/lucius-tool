package es.usal.tfm.lucius.grafica.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTRATOS")
public class ContratoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="id_cliente")
	private String id_cliente;
	
	@Column(name="fecha_in")
	private Date fecha_in;
	
	@Column(name="fecha_out")
	private Date fecha_out;
	
	@Column(name="piezas")
	private int piezas;
	
	@Column(name="cost_pieza")
	private double cost_pieza;
	
	
	@Column(name="estado")
	private String estado;
	
	public ContratoDto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getFecha_in() {
		return fecha_in;
	}

	public void setFecha_in(Date fecha_in) {
		this.fecha_in = fecha_in;
	}

	public Date getFecha_out() {
		return fecha_out;
	}

	public void setFecha_out(Date fecha_out) {
		this.fecha_out = fecha_out;
	}

	public int getPiezas() {
		return piezas;
	}

	public void setPiezas(int piezas) {
		this.piezas = piezas;
	}

	public double getCost_pieza() {
		return cost_pieza;
	}

	public void setCost_pieza(double cost_pieza) {
		this.cost_pieza = cost_pieza;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
