package br.edu.ifcvideira.controllers.views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifcvideira.DAOs.ClienteDao;
import br.edu.ifcvideira.beans.Cliente;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;



@SuppressWarnings("serial")
public class ClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfId;
	private JTextField tfCelular;
	private JTextField tfEndereco;

	
	
	List<Object> clientes = new ArrayList<Object>();
	
	Cliente cl = new Cliente();
	ClienteDao cd = new ClienteDao();
	private JTextField tfEmail;
	private JTextField tfDeletar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView frame = new ClienteView();
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
	public ClienteView() {
		setTitle("ClassicHaircutBarberShop - Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/br/edu/ifcvideira/imgs/clientes.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome: ");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(37, 48, 46, 14);
		contentPane.add(label);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(100, 42, 215, 20);
		contentPane.add(tfNome);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(37, 75, 46, 14);
		contentPane.add(label_1);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(100, 72, 205, 20);
		contentPane.add(tfId);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setForeground(Color.BLACK);
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCelular.setBounds(37, 108, 68, 14);
		contentPane.add(lblCelular);
		
		tfCelular = new JTextField();
		tfCelular.setColumns(10);
		tfCelular.setBounds(100, 105, 215, 20);
		contentPane.add(tfCelular);
		
		JLabel lblIdDoEndereo = new JLabel("ID do endere\u00E7o:");
		lblIdDoEndereo.setForeground(Color.BLACK);
		lblIdDoEndereo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdDoEndereo.setBounds(39, 191, 104, 14);
		contentPane.add(lblIdDoEndereo);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(155, 188, 104, 20);
		contentPane.add(tfEndereco);
		
		JButton jbCadstrar = new JButton("Cadastrar");
		jbCadstrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cl.setNome(tfNome.getText());
					cl.setEmail(tfEmail.getText());
					cl.setCelular(Integer.parseInt(tfCelular.getText()));
					cl.setIdendereco(Integer.parseInt(tfEndereco.getText()));
					
					
					cd.cadastrarCliente(cl);
					
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			
			}
		});
		jbCadstrar.setBounds(351, 39, 142, 23);
		contentPane.add(jbCadstrar);
		
		JButton jbCadastrar = new JButton("Limpar");
		jbCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfNome.setText("");
				tfEmail.setText("");
				tfCelular.setText("");
				tfEndereco.setText("");
			}
		});
		jbCadastrar.setBounds(351, 71, 142, 23);
		contentPane.add(jbCadastrar);
		
		JButton jbExcluir = new JButton("Excluir");
		jbExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
		jbExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cl.setId(Integer.parseInt(tfDeletar.getText()));
					cd.deletarCliente(cl);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}			
			}
		});
		jbExcluir.setForeground(Color.RED);
		jbExcluir.setBounds(133, 374, 156, 23);
		contentPane.add(jbExcluir);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(37, 146, 68, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(100, 143, 215, 20);
		contentPane.add(tfEmail);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(10, 221, 505, 2);
		contentPane.add(separator);
		
		JLabel lblIdDoCliente = new JLabel("ID do cliente:");
		lblIdDoCliente.setForeground(Color.BLACK);
		lblIdDoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdDoCliente.setBounds(89, 306, 111, 14);
		contentPane.add(lblIdDoCliente);
		
		tfDeletar = new JTextField();
		tfDeletar.setBounds(207, 303, 132, 22);
		contentPane.add(tfDeletar);
		tfDeletar.setColumns(10);
		
		JLabel lblExcluirCliente = new JLabel("EXCLUIR CLIENTE");
		lblExcluirCliente.setBackground(Color.WHITE);
		lblExcluirCliente.setForeground(Color.RED);
		lblExcluirCliente.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblExcluirCliente.setBounds(115, 236, 248, 39);
		contentPane.add(lblExcluirCliente);
	}
}
