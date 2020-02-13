package br.edu.ifcvideira.beans;
public class Agendamento {
	private int idagendamento;
	private String clienteNome;
	private String funcionarioNome;
	private String servico;
	private String horario;
	
	public Agendamento() {
		
	}
	
	public Agendamento(int idagendamento, String clienteNome, String funcionarioNome, String servico,
		String horario) {
		this.idagendamento = idagendamento;
		this.clienteNome = clienteNome;
		this.funcionarioNome = funcionarioNome;
		this.servico = servico;
		this.horario = horario;
		
	}

	public int getIdagendamento() {
		return idagendamento;
	}

	public void setIdagendamento(int idagendamento) {
		this.idagendamento = idagendamento;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}
