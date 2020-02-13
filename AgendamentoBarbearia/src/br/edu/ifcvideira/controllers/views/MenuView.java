package br.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class MenuView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
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
	public MenuView() {
		setBackground(Color.BLACK);
		setTitle("Menu De Op\u00E7\u00F5es");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/br/edu/ifcvideira/imgs/barber.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 563);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneAOpo = new JLabel("SELECIONE UM CADASTRO");
		lblSelecioneAOpo.setForeground(Color.WHITE);
		lblSelecioneAOpo.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		lblSelecioneAOpo.setBounds(54, 13, 336, 27);
		contentPane.add(lblSelecioneAOpo);
		
		JButton btnCadastrarEndereco = new JButton("CADASTRAR ENDERE\u00C7O");
		btnCadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnderecoView enderecoview = new EnderecoView();
				enderecoview.setVisible(true);
				
			}
		});
		btnCadastrarEndereco.setFont(new Font("Arial", Font.BOLD, 15));
		btnCadastrarEndereco.setBounds(84, 78, 253, 54);
		contentPane.add(btnCadastrarEndereco);
		
		JButton btnCadastrarFuncionario = new JButton("CADASTRAR FUNCIONARIO");
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioView funcionarioview = new FuncionarioView();
				funcionarioview.setVisible(true);
			}
		});
		btnCadastrarFuncionario.setFont(new Font("Arial", Font.BOLD, 15));
		btnCadastrarFuncionario.setBounds(84, 254, 253, 54);
		contentPane.add(btnCadastrarFuncionario);
		
		JButton btnCadastrarAgendamento = new JButton("CADASTRAR AGENDAMENTO");
		btnCadastrarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendamentoView agendamentoview = new AgendamentoView();
				agendamentoview.setVisible(true);
			}
		});
		btnCadastrarAgendamento.setFont(new Font("Arial", Font.BOLD, 15));
		btnCadastrarAgendamento.setBounds(84, 360, 253, 54);
		contentPane.add(btnCadastrarAgendamento);
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR CLIENTE");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteView clienteview = new ClienteView();
				clienteview.setVisible(true);
			}
		});
		btnCadastrarCliente.setFont(new Font("Arial", Font.BOLD, 15));
		btnCadastrarCliente.setBounds(84, 164, 253, 54);
		contentPane.add(btnCadastrarCliente);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuView.class.getResource("/br/edu/ifcvideira/imgs/tex-barbearia-a-barbearia-01.jpg")));
		lblNewLabel.setBounds(-340, 0, 803, 524);
		contentPane.add(lblNewLabel);
	}
}
