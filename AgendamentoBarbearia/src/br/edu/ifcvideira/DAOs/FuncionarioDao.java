package br.edu.ifcvideira.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Funcionario;
import br.edu.ifcvideira.utils.Conexao;

public class FuncionarioDao {
	
	//Conexão com banco funcionando
	
	public void cadastrarFuncionario(Funcionario fun)throws SQLException, Exception{
		try {
			String sql = "INSERT INTO funcionario (nome) VALUES (?)";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1,fun.getNome());
			sqlPrep.execute();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}	
		
	public void alterarFuncionario(Funcionario fun) throws Exception {
		try {
			String sql = "UPDATE funcionario SET nome=? WHERE idfuncionario=?";
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1,fun.getNome());
			sqlPrep.setInt(2,fun.getIdfuncionario());
			sqlPrep.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public void deletarEndereco(Funcionario fun ) throws Exception{
		try {
			String sql = "DELETE FROM funcionario WHERE idfuncionario = ?";
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setInt(1, fun.getIdfuncionario());
			sqlPrep.execute();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public List<Object> buscarFuncionario() throws SQLException, Exception{
		List<Object> funcionariosNome = new ArrayList<Object>();
		try {
			String sql = "SELECT nome FROM funcionario";
			java.sql.Statement state = Conexao.conectar().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				funcionariosNome.add(rs.getString("nome"));
			}
			state.close();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return funcionariosNome;
	}
}
