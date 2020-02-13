package br.edu.ifcvideira.DAOs;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Notificacao;
import br.edu.ifcvideira.utils.Conexao;

public class NotificacaoDao {

	public void cadastrarNotificacao(Notificacao not) throws SQLException, Exception{
		String sql = "INSERT INTO notificacao (texto,idcliente) VALUES (?,?)";
		java.sql.PreparedStatement sqlPrep = Conexao.conectar().prepareStatement(sql);
		try {
			sqlPrep.setString(1, not.getTexto());
			sqlPrep.setInt(2, not.getIdCliente());
			sqlPrep.execute();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}
