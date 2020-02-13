package br.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifcvideira.DAOs.FuncionarioDao;
import br.edu.ifcvideira.beans.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class FuncionarioView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField tfNome;
	
	Funcionario fun = new Funcionario();
	FuncionarioDao funcdao = new FuncionarioDao();
	private JTextField tfIdfuncionario;
	private JTextField tfAtualizar;
	private JTextField tfAtualizarid;
	JRadioButton rbNomeID = new JRadioButton("NOME & ID");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView frame = new FuncionarioView();
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
	public FuncionarioView() {
		setTitle("ClassicHaircutBarberShop - Funcionario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/br/edu/ifcvideira/imgs/funcionario.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarFuncionario = new JLabel("CADASTRAR FUNCION\u00C1RIO");
		lblCadastrarFuncionario.setForeground(Color.BLACK);
		lblCadastrarFuncionario.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCadastrarFuncionario.setBounds(87, 0, 322, 39);
		contentPane.add(lblCadastrarFuncionario);
		
		JLabel label = new JLabel("ID:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(57, 52, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(118, 52, 215, 20);
		contentPane.add(textField);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Arial", Font.BOLD, 17));
		lblNome.setBounds(33, 107, 56, 16);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(118, 105, 215, 20);
		contentPane.add(tfNome);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBackground(new Color(192, 192, 192));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fun.setNome(tfNome.getText());
					
					funcdao.cadastrarFuncionario(fun);
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastrar.setBounds(145, 160, 142, 23);
		contentPane.add(btnCadastrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 209, 502, 2);
		contentPane.add(separator);
		
		JLabel lblExcluirFuncionrio = new JLabel("EXCLUIR FUNCION\u00C1RIO");
		lblExcluirFuncionrio.setForeground(Color.RED);
		lblExcluirFuncionrio.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblExcluirFuncionrio.setBounds(124, 209, 248, 39);
		contentPane.add(lblExcluirFuncionrio);
		
		JLabel lblIdDoFuncionrio = new JLabel("ID do funcion\u00E1rio:");
		lblIdDoFuncionrio.setForeground(Color.BLACK);
		lblIdDoFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdDoFuncionrio.setBounds(33, 279, 134, 16);
		contentPane.add(lblIdDoFuncionrio);
		
		tfIdfuncionario = new JTextField();
		tfIdfuncionario.setColumns(10);
		tfIdfuncionario.setBounds(179, 278, 154, 20);
		contentPane.add(tfIdfuncionario);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setForeground(Color.RED);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fun.setIdfuncionario(Integer.parseInt(tfIdfuncionario.getText()));
					funcdao.deletarEndereco(fun);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnExcluir.setBackground(Color.LIGHT_GRAY);
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 13));
		btnExcluir.setBounds(145, 347, 142, 23);
		contentPane.add(btnExcluir);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 398, 502, 2);
		contentPane.add(separator_1);
		
		JLabel lblAtualizarDados = new JLabel("ATUALIZAR DADOS DO FUNCION\u00C1RIO");
		lblAtualizarDados.setForeground(Color.BLACK);
		lblAtualizarDados.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblAtualizarDados.setBounds(87, 398, 322, 39);
		contentPane.add(lblAtualizarDados);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Arial", Font.BOLD, 15));
		label_1.setBounds(97, 452, 56, 16);
		contentPane.add(label_1);
		
		tfAtualizar = new JTextField();
		tfAtualizar.setColumns(10);
		tfAtualizar.setBounds(157, 450, 215, 20);
		contentPane.add(tfAtualizar);
		
		tfAtualizarid = new JTextField();
		tfAtualizarid.setColumns(10);
		tfAtualizarid.setBounds(225, 483, 147, 20);
		contentPane.add(tfAtualizarid);
		
		JLabel label_2 = new JLabel("ID do funcion\u00E1rio:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(79, 484, 134, 16);
		contentPane.add(label_2);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					fun.setIdfuncionario(Integer.parseInt(tfAtualizarid.getText()));					
					fun.setNome(tfAtualizar.getText());
					
					funcdao.alterarFuncionario(fun);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAtualizar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAtualizar.setBackground(Color.LIGHT_GRAY);
		btnAtualizar.setBounds(145, 557, 142, 23);
		contentPane.add(btnAtualizar);
	}
}
