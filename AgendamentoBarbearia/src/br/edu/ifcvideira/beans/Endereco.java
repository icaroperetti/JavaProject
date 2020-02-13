package br.edu.ifcvideira.beans;

public class Endereco {
	private int idendereco;
	private int numero;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String cep;
	
	
	public Endereco() {
		
	}


	public Endereco(String logradouro, String bairro, String cidade, String cep, int idendereco, int numero) {
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.idendereco = idendereco;
		this.numero = numero;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public int getIdendereco() {
		return idendereco;
	}


	public void setIdendereco(int idendereco) {
		this.idendereco = idendereco;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
