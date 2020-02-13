package br.edu.ifcvideira.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.utils.Conexao;

public class ServicoDao {
	
	public List<Object> buscarServico() throws SQLException, Exception{
		List<Object> servicos = new ArrayList<Object>();
		try {
			String sql = "SELECT tipo FROM servico";
			java.sql.Statement state = Conexao.conectar().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				servicos.add(rs.getString("tipo"));
			}
			state.close();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return servicos;
	}
	
	
}
