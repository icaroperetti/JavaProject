package br.edu.ifcvideira.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Endereco;
import br.edu.ifcvideira.utils.Conexao;



public class EnderecoDao {
	
	//Conexão com banco funcionando
	
	public void cadastrarEndereco(Endereco en) throws SQLException, Exception  {
		try {
			String sql = "INSERT INTO endereco (logradouro,bairro,cidade,cep,numero) VALUES (?,?,?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1,en.getLogradouro());
			sqlPrep.setString(2, en.getBairro());
			sqlPrep.setString(3, en.getCidade());
			sqlPrep.setString(4, en.getCep());
			sqlPrep.setInt(5, en.getNumero());
			sqlPrep.execute();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
		
		public void alterarEndereco(Endereco en) throws Exception {
			try {
				String sql = "UPDATE endereco SET logradouro=?, bairro=?, cidade=?, cep=?,numero=? WHERE idendereco=?";
				PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
				sqlPrep.setString(1,en.getLogradouro());
				sqlPrep.setString(2, en.getBairro());
				sqlPrep.setString(3, en.getCidade());
				sqlPrep.setString(4, en.getCep());
				sqlPrep.setInt(5, en.getNumero());
				sqlPrep.execute();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
		
		public void deletarEndereco(Endereco en) throws Exception {
			try {
				String sql = "DELETE FROM endereco WHERE idendereco = ?";
				PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
				sqlPrep.setInt(1, en.getIdendereco());
				sqlPrep.execute();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
	
}
