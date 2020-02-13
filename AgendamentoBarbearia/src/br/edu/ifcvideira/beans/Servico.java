package br.edu.ifcvideira.beans;

public class Servico {
	private int id;
	private float valor;
	private int tipo;
	
	public Servico() {
		
	}
	
	public Servico(int id, float valor, int tipo) {
		this.id = id;
		this.valor = valor;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
