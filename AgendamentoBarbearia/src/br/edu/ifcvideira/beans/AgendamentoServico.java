package br.edu.ifcvideira.beans;

public class AgendamentoServico {
	public int agendamentoServico;
	public int idservico;
	public int idagenda;
	public double valor;
	public double somaServico;
	
	public AgendamentoServico(){
		
	}



	public int getAgendamentoServico() {
		return agendamentoServico;
	}
	
	public void setAgendamentoServico(int agendamentoServico) {
		this.agendamentoServico = agendamentoServico;
	}	
			
	
	public int getIdservico() {
		return idservico;
	}

	public void setIdservico(int idservico) {
		this.idservico = idservico;
	}

	public int getIdagenda() {
		return idagenda;
	}

	public void setIdagenda(int idagenda) {
		this.idagenda = idagenda;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}



	public double getSomaServico() {
		return somaServico;
	}



	public void setSomaServico(double somaServico) {
		this.somaServico = somaServico;
	}
	
	
}
