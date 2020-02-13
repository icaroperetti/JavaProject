package br.edu.ifcvideira.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Agendamento;
import br.edu.ifcvideira.utils.Conexao;

public class AgendamentoDao {
	
	public void cadastrarAgendamento(Agendamento ag) throws SQLException, Exception{
		try {
			String sql = "INSERT INTO agendamento (horario,cliente,funcionario_barbeiro,servico) VALUES (?,?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1, ag.getHorario());
			sqlPrep.setString(2, ag.getClienteNome());
			sqlPrep.setString(3, ag.getFuncionarioNome());
			sqlPrep.setString(4,ag.getServico());
			sqlPrep.execute();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public void alterarAgendamento(Agendamento ag) throws Exception{
		try {
			String sql = "UPDATE agendamento SET horario=?,cliente=?,funcionario_barbeiro=? servico = ? WHERE idagendamento = ?";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1, ag.getHorario());
			sqlPrep.setString(2, ag.getClienteNome());
			sqlPrep.setString(3, ag.getFuncionarioNome());
			sqlPrep.setInt(4, ag.getIdagendamento());
			sqlPrep.execute();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}	
	public void deletarAgendamento(Agendamento ag) throws Exception{
		try {
			String sql = "DELETE FROM agendamento WHERE idagendamento = ? ";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setInt(1, ag.getIdagendamento());
			sqlPrep.execute();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	 
	//Tabela
	public List<Object> buscarAgendamento() throws SQLException, Exception {
		List<Object> agendamento = new ArrayList<Object>();
		try {
			String sql = "SELECT cliente,horario,funcionario_barbeiro,servico FROM agendamento";
			java.sql.Statement state = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				Object[] linha = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
				agendamento.add(linha);
			}
			state.close();
			}
			catch(Exception e)	{
				JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return agendamento;
	}
	
	
}
