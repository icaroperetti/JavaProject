package br.edu.ifcvideira.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Cliente;
import br.edu.ifcvideira.utils.Conexao;

public class ClienteDao{
	
	//Conexão com banco funcionando
	
	public void cadastrarCliente(Cliente cl) throws SQLException, Exception{
		try{
			String sql = "INSERT INTO cliente (nome, email, celular, idendereco) VALUES (?,?,?,?)";
			java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			sqlPrep.setString(1, cl.getNome());
			sqlPrep.setString(2,cl.getEmail());
			sqlPrep.setInt(3,cl.getCelular());
			sqlPrep.setInt(4,cl.getIdendereco());
			sqlPrep.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	public void alterarCliente(Cliente cl) throws Exception {
		try{
			String sql = "UPDATE cliente SET nome=?,email=?,celular=?,idendereco=? WHERE idcliente=?";
			PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
			//int contador = 1;
			sqlPrep.setString(1, cl.getNome());
			sqlPrep.setString(2,cl.getEmail());
			sqlPrep.setInt(3,cl.getCelular());
			sqlPrep.setInt(4,cl.getIdendereco());
			sqlPrep.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void deletarCliente(Cliente cl) throws Exception{
		try{
			String sql = "DELETE FROM cliente WHERE idcliente=? ";
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement(sql);
			sqlPrep.setInt(1, cl.getId());
			sqlPrep.execute();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void consultarEndereco(Cliente cl) throws Exception{
		try {
			String sql = "CALL `barbearia`.`cliente_endereco`(?)";
			PreparedStatement sqlPrep = (PreparedStatement) Conexao.conectar().prepareStatement(sql);
			sqlPrep.setInt(1, cl.getIdendereco());
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public List<Object> buscarNomes() throws SQLException, Exception{
		List<Object> clientes = new ArrayList<Object>();
		try {
			String sql = "SELECT nome FROM cliente";
			java.sql.Statement state = Conexao.conectar().createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while (rs.next())
			{
				clientes.add(rs.getString("nome"));
			}
			state.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return clientes;
	}

}














