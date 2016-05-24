package br.com.unibratec.casino.business;

import java.io.Serializable;

public class Error implements Serializable {
	private static final long serialVersionUID = 8467553072140041374L;
	private int cod;
	private String error;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public Error(int cod, String error) {
		super();
		this.cod = cod;
		this.error = error;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}