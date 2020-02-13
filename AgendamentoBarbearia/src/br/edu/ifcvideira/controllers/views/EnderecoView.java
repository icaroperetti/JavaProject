package br.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifcvideira.DAOs.EnderecoDao;
import br.edu.ifcvideira.beans.Endereco;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class EnderecoView extends JFrame {

	private JPanel contentPane;
	private JTextField tfLogradouro;
	private JTextField tfID;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfCep;
	
	Endereco en = new Endereco();
	EnderecoDao ed = new EnderecoDao();
	private JTextField tfNumero;
	private JTextField tfExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnderecoView frame = new EnderecoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnderecoView() {
		setTitle("Endereços");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/br/edu/ifcvideira/imgs/endereco.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 437, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setForeground(Color.WHITE);
		lblLogradouro.setFont(new Font("Arial", Font.BOLD, 15));
		lblLogradouro.setBounds(12, 139, 179, 23);
		contentPane.add(lblLogradouro);
		
		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(123, 139, 218, 22);
		contentPane.add(tfLogradouro);
		tfLogradouro.setColumns(10);
		
		JLabel label = new JLabel("ID:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(42, 102, 46, 14);
		contentPane.add(label);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(123, 102, 218, 20);
		contentPane.add(tfID);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial", Font.BOLD, 15));
		lblBairro.setBounds(12, 185, 99, 23);
		contentPane.add(lblBairro);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(123, 185, 218, 22);
		contentPane.add(tfBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Arial", Font.BOLD, 15));
		lblCidade.setBounds(12, 253, 99, 23);
		contentPane.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(123, 253, 218, 22);
		contentPane.add(tfCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Arial", Font.BOLD, 15));
		lblCep.setBounds(12, 289, 99, 23);
		contentPane.add(lblCep);
		
		tfCep = new JTextField();
		tfCep.setColumns(10);
		tfCep.setBounds(123, 289, 218, 22);
		contentPane.add(tfCep);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					en.setLogradouro(tfLogradouro.getText());
					en.setCidade(tfCidade.getText());
					en.setBairro(tfBairro.getText());
					en.setCep(tfCep.getText());
					en.setNumero(Integer.parseInt(tfNumero.getText()));;
					
					ed.cadastrarEndereco(en);
					
					JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!");
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnCadastrar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnCadastrar.setBounds(131, 341, 159, 46);
		contentPane.add(btnCadastrar);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("Arial", Font.BOLD, 15));
		lblNumero.setBounds(12, 221, 99, 23);
		contentPane.add(lblNumero);
		
		tfNumero = new JTextField();
		tfNumero.setColumns(10);
		tfNumero.setBounds(123, 218, 218, 22);
		contentPane.add(tfNumero);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 403, 552, 2);
		contentPane.add(separator);
		
		JLabel lblExcluirEndereco = new JLabel("EXCLUIR ENDERE\u00C7O");
		lblExcluirEndereco.setForeground(Color.RED);
		lblExcluirEndereco.setFont(new Font("Arial", Font.BOLD, 18));
		lblExcluirEndereco.setBounds(123, 422, 206, 23);
		contentPane.add(lblExcluirEndereco);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(102, 485, 46, 14);
		contentPane.add(label_1);
		
		tfExcluir = new JTextField();
		tfExcluir.setColumns(10);
		tfExcluir.setBounds(131, 481, 179, 22);
		contentPane.add(tfExcluir);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				en.setIdendereco(Integer.parseInt(tfExcluir.getText()));
				try {
					ed.deletarEndereco(en);
					
					JOptionPane.showMessageDialog(null, "Endereço excluido!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}			
			}
		});
		btnExcluir.setForeground(Color.RED);
		btnExcluir.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnExcluir.setBackground(Color.LIGHT_GRAY);
		btnExcluir.setBounds(131, 538, 159, 46);
		contentPane.add(btnExcluir);
		
		JLabel lblCadastrarEndereo = new JLabel("CADASTRAR ENDERE\u00C7O");
		lblCadastrarEndereo.setBounds(93, 26, 267, 26);
		contentPane.add(lblCadastrarEndereo);
		lblCadastrarEndereo.setForeground(Color.WHITE);
		lblCadastrarEndereo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EnderecoView.class.getResource("/br/edu/ifcvideira/imgs/tex-barbearia-a-barbearia-01.jpg")));
		lblNewLabel.setBounds(-201, -6, 620, 613);
		contentPane.add(lblNewLabel);
	}
}
