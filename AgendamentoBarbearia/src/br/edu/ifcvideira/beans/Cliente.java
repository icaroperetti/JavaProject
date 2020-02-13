package br.edu.ifcvideira.beans;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	private int celular;
	private int idendereco;
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, String email, int celular, int idendereco) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.idendereco = idendereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getIdendereco() {
		return idendereco;
	}

	public void setIdendereco(int idendereco) {
		this.idendereco = idendereco;
	}
	
	
	
}
