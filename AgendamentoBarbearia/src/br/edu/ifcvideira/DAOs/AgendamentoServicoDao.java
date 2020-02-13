package br.edu.ifcvideira.DAOs;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.AgendamentoServico;
import br.edu.ifcvideira.utils.Conexao;

public class AgendamentoServicoDao {
	
	public void cadastrarAgendamentoServico(AgendamentoServico ags)throws SQLException, Exception {
		try {
			String sql = "INSERT INTO agendamento_servico (idservico,idagendamento,valor) VALUES (?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setInt(1, ags.getIdservico());
			sqlPrep.setInt(2, ags.getIdagenda());
			sqlPrep.setDouble(3, ags.getValor());
			sqlPrep.execute();
	}
	catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}
