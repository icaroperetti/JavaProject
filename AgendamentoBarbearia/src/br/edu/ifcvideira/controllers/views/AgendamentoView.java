package br.edu.ifcvideira.controllers.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import br.edu.ifcvideira.DAOs.AgendamentoDao;
import br.edu.ifcvideira.DAOs.AgendamentoServicoDao;
import br.edu.ifcvideira.DAOs.ClienteDao;
import br.edu.ifcvideira.DAOs.FuncionarioDao;
import br.edu.ifcvideira.DAOs.NotificacaoDao;
import br.edu.ifcvideira.DAOs.ServicoDao;
import br.edu.ifcvideira.beans.Agendamento;
import br.edu.ifcvideira.beans.AgendamentoServico;
import br.edu.ifcvideira.beans.Notificacao;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;



@SuppressWarnings("serial")
public class AgendamentoView extends JFrame {

	private JPanel contentPane;
	private JTable table_4;
	private JTextField tfNotificacao;
	
	List<Object> nomes = new ArrayList<Object>();
	List<Object> servico = new ArrayList<Object>();
	List<Object> funcionario = new ArrayList<Object>();
	List<Object> clientes = new ArrayList<Object>();
	List<Object> agendamentoTabela = new ArrayList<Object>();
	
	
	Agendamento ag = new Agendamento();
	ClienteDao clDao = new ClienteDao();
	ServicoDao svDao = new ServicoDao();
	FuncionarioDao funcDao = new FuncionarioDao();
	AgendamentoDao agDao = new AgendamentoDao();
	NotificacaoDao notDao = new  NotificacaoDao();
	Notificacao not = new Notificacao();
	
	AgendamentoServico ags = new AgendamentoServico();
	AgendamentoServicoDao agsDao = new AgendamentoServicoDao();
	
	
	DefaultComboBoxModel<Object> cbModel = new DefaultComboBoxModel<Object>();
	DefaultComboBoxModel<Object> cbModelS = new DefaultComboBoxModel<Object>(); //Servico
	DefaultComboBoxModel<Object> cbModelF = new DefaultComboBoxModel<Object>(); //Funcionario
	
	private JTextField tfData;
	private JTextField tfExcluir;
	

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendamentoView frame = new AgendamentoView();
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
	public AgendamentoView() {
		setTitle("ClassicHaircutBarberShop - Agendamento");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/br/edu/ifcvideira/imgs/agenda1.png")));
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				atualizarTabela();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblAgendamento = new JLabel("AGENDAMENTO");
		lblAgendamento.setFont(new Font("Arial", Font.BOLD, 23));
		lblAgendamento.setBounds(183, 13, 189, 24);
		contentPane.add(lblAgendamento);

			
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCliente.setBounds(55, 78, 56, 16);
		contentPane.add(lblCliente);
		
		JLabel lblServio = new JLabel("Servi\u00E7o:");
		lblServio.setFont(new Font("Arial", Font.PLAIN, 17));
		lblServio.setBounds(55, 133, 71, 27);
		contentPane.add(lblServio);
		
		//Inserir servicos ao comboBox
		JComboBox<Object> cbServico = new JComboBox<Object>();
				
				try {
					listarServicos();
				}
				catch(Exception e1 ) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
		
		
		cbServico.setModel(cbModelS);
		cbServico.setBounds(128, 130, 213, 35);
		contentPane.add(cbServico);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setFont(new Font("Arial", Font.PLAIN, 17));
		lblFuncionario.setBounds(48, 186, 92, 27);
		contentPane.add(lblFuncionario);
		
		//Inserir funcionario ao comboBox
		JComboBox<Object> cbFuncionario = new JComboBox<Object>();
				
				try{
					listarFuncionario();
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				//Inserir clientes ao comboBox
				JComboBox<Object> cbCliente = new JComboBox<Object>();
						try {
							listarNomes();
						}
						catch(Exception e1 ) {
							JOptionPane.showMessageDialog(null,e1.getMessage());
						}
				
				
			cbCliente.setModel(cbModel);
			cbCliente.setBounds(128, 70, 213, 35);
			contentPane.add(cbCliente);
			
		cbFuncionario.setModel(cbModelF);
		cbFuncionario.setBounds(157, 183, 184, 35);
		contentPane.add(cbFuncionario);
		
		JButton btnAgendar = new JButton("AGENDAR");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Funcionario
				ag.setFuncionarioNome(String.valueOf(cbFuncionario.getSelectedIndex()));
				for(int i = 0; i < funcionario.size();i++) {
					if(cbFuncionario.getSelectedIndex() == i ) {
						ag.setFuncionarioNome(cbFuncionario.getSelectedItem().toString());
					}
				}
		
				
				//Cliente
				ag.setClienteNome(String.valueOf(cbCliente.getSelectedIndex()));
				for(int i = 0; i < nomes.size();i++) {
					if(cbCliente.getSelectedIndex() == i) {
						ag.setClienteNome(cbCliente.getSelectedItem().toString());
					}
				
				}
				//Servico
				ag.setServico(String.valueOf(cbServico.getSelectedIndex()));
				for(int i = 0; i < servico.size();i++) {
					if(cbServico.getSelectedIndex() == i) {
						ag.setServico(cbServico.getSelectedItem().toString());
						ags.setIdservico(cbServico.getSelectedIndex() + 1);
						ags.setIdagenda(cbServico.getSelectedIndex() + 1);
					}	
				}
				//Valor
				if(cbServico.getSelectedIndex() == 0) {
					ags.setValor(30.00);
					
				}
				else if(cbServico.getSelectedIndex() == 1) {
					ags.setValor(15.00);
				}
				else if(cbServico.getSelectedIndex() == 2) {
					ags.setValor(10.00);
				}
				else if(cbServico.getSelectedIndex() == 3) {
					ags.setValor(40.00);
				}
				else if(cbServico.getSelectedIndex() == 4) {
					ags.setValor(35.00);
				}
				else if(cbServico.getSelectedIndex() == 5) {
					ags.setValor(20.00);
				}
				
				try {
					agsDao.cadastrarAgendamentoServico(ags);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
				
				
				//Horario
				ag.setHorario(String.valueOf(tfData.getText()));
				try {
					agDao.cadastrarAgendamento(ag);
					JOptionPane.showMessageDialog(null, "Agendamento feito com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
				//Notificacao
				not.setTexto(String.valueOf(tfNotificacao.getText()));
				not.setIdCliente(cbCliente.getSelectedIndex() + 1);
				try {
					notDao.cadastrarNotificacao(not);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnAgendar.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnAgendar.setBounds(361, 70, 189, 42);
		contentPane.add(btnAgendar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 421, 559, 78);
		contentPane.add(scrollPane);
		
		table_4 = new JTable();
		table_4.setFont(new Font("Arial", Font.PLAIN, 12));
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Cliente", "Data", "Funcionario", "Servi\u00E7o"
			}
		));
		table_4.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table_4);
		
		JLabel lblNotificao = new JLabel("Notifica\u00E7\u00E3o(opcional)");
		lblNotificao.setFont(new Font("Arial", Font.BOLD, 19));
		lblNotificao.setBounds(131, 297, 254, 27);
		contentPane.add(lblNotificao);
		
		tfNotificacao = new JTextField();
		tfNotificacao.setBounds(146, 337, 195, 35);
		contentPane.add(tfNotificacao);
		tfNotificacao.setColumns(10);
		
		
		
		JLabel lblData = new JLabel("Data/Hora:");
		lblData.setFont(new Font("Arial", Font.PLAIN, 17));
		lblData.setBounds(60, 257, 92, 27);
		contentPane.add(lblData);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(152, 249, 189, 35);
		contentPane.add(tfData);
		
		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMensagem.setBounds(48, 340, 92, 26);
		contentPane.add(lblMensagem);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AgendamentoView.class.getResource("/br/edu/ifcvideira/imgs/BarbeariaLogo.png")));
		lblNewLabel.setBounds(318, 133, 253, 239);
		contentPane.add(lblNewLabel);
		
		JLabel lblExcluirAgendamento = new JLabel("EXCLUIR AGENDAMENTO");
		lblExcluirAgendamento.setForeground(Color.RED);
		lblExcluirAgendamento.setFont(new Font("Arial", Font.BOLD, 20));
		lblExcluirAgendamento.setBounds(128, 547, 256, 16);
		contentPane.add(lblExcluirAgendamento);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 17));
		lblId.setBounds(157, 596, 56, 16);
		contentPane.add(lblId);
		
		tfExcluir = new JTextField();
		tfExcluir.setBounds(201, 594, 116, 22);
		contentPane.add(tfExcluir);
		tfExcluir.setColumns(10);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ag.setIdagendamento(Integer.parseInt(tfExcluir.getText()));
				try {
					agDao.deletarAgendamento(ag);
					atualizarTabela();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnExcluir.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnExcluir.setBounds(146, 639, 189, 42);
		contentPane.add(btnExcluir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 528, 583, 2);
		contentPane.add(separator);
	}
	
	//Listar servicos
	public void listarServicos() throws SQLException, Exception{
		servico = svDao.buscarServico();
		for(int j = 0; j != servico.size();j++) {
			cbModelS.addElement(servico.get(j));
		}
	}
	
	//Listar clientes
	public void listarNomes() throws SQLException, Exception{
		nomes = clDao.buscarNomes();
		
		for(int i = 0 ; i != nomes.size();i++) {
			cbModel.addElement(nomes.get(i));
		}
	}
	
	//Listar nome dos funcionários
	public void listarFuncionario() throws SQLException,Exception {
		funcionario = funcDao.buscarFuncionario();
		
			for (int c = 0; c != funcionario.size();c++) {
				cbModelF.addElement(funcionario.get(c));
			}
		}
	
	//Preencher tabela com os agendamentos
	public void atualizarTabela() {
		try {
			agendamentoTabela = agDao.buscarAgendamento();
			DefaultTableModel model = (DefaultTableModel) table_4.getModel();
			model.setNumRows(0);
		for (int x=0; x!=agendamentoTabela.size(); x++)
			{
				model.addRow((Object[]) agendamentoTabela.get(x));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
