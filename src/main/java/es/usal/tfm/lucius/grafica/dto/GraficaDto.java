package es.usal.tfm.lucius.grafica.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class GraficaDto<T,S> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	List<T> tags;
	
	List<S> values;
	
	Map<T,S> mValues;

	public GraficaDto() {
		super();
	}

	public GraficaDto(List<T> tags, List<S> values) {
		super();
		this.tags = tags;
		this.values = values;
	}

	public GraficaDto(List<T> tags, Map<T, S> mValues) {
		super();
		this.tags = tags;
		this.mValues = mValues;
	}

	public List<T> getTags() {
		return tags;
	}

	public void setTags(List<T> tags) {
		this.tags = tags;
	}

	public List<S> getValues() {
		return values;
	}

	public void setValues(List<S> values) {
		this.values = values;
	}

	public Map<T, S> getmValues() {
		return mValues;
	}

	public void setmValues(Map<T, S> mValues) {
		this.mValues = mValues;
	}

}
