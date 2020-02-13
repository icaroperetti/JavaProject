package br.edu.ifcvideira.beans;

public class Funcionario {
	private String nome;
	private int idfuncionario;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, int idfuncionario) {
		this.nome = nome;
		this.idfuncionario = idfuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	
	
	
}
