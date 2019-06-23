package es.usal.tfm.lucius.comun.dto;

import java.io.Serializable;
import java.util.List;

public class EnvioJsonDto<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String tipo;
	
	private Object obj;
	
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

	public EnvioJsonDto(String tipo, Object obj) {
		super();
		this.tipo = tipo;
		this.obj = obj;
	}

	public EnvioJsonDto(String tipo, Object obj, List<T> lista) {
		super();
		this.tipo = tipo;
		this.obj = obj;
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

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
