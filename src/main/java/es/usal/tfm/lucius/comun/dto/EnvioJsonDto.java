package es.usal.tfm.lucius.comun.dto;

import java.io.Serializable;
import java.util.List;

public class EnvioJsonDto<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String tipo;
	
	private List<T> lista;

	public EnvioJsonDto() {
		super();
	}

	public String getTipo() {
		return tipo;
	}

	public EnvioJsonDto(String tipo, List<T> lista) {
		super();
		this.tipo = tipo;
		this.lista = lista;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

}
