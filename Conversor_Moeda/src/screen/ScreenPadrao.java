package screen;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

abstract public class ScreenPadrao extends JFrame {

	private JPanel contentPane;
	private JTextField textInput;
	private String moedaUm;
	private String moedaDois;
	private JComboBox deMoeda;
	private JComboBox paraMoeda;
	private JLabel lblOutPutCoin;
	private JLabel lblOutPutValue;
	private JButton btnCurrency;
	private List<String> ls = new ArrayList<String>();

	public void setLs(List<String> ls) {
		getDeMoeda().setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));
		paraMoeda.setModel(new DefaultComboBoxModel<String>(ls.toArray(new String[0])));

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenPadrao frame = new ScreenPadrao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void setMoedaUm(String moedaUm) {
		this.moedaUm = moedaUm;
	}

	public void setMoedaDois(String moedaDois) {
		this.moedaDois = moedaDois;
	}

	public ScreenPadrao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// -------------------------Input----------------------------
		// Input - Local que recebe o valor digitado
		setTextInput(new JTextField());
		getTextInput().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {// Não recebe letra
					e.consume();
				} else {
					try {
						Double.parseDouble(getTextInput().getText() + e.getKeyChar());// Não recebe virgula
					} catch (NumberFormatException ex) {
						e.consume();
					}
				}

			}
		});
		getTextInput().setBounds(53, 45, 387, 30);
		contentPane.add(getTextInput());
		getTextInput().setColumns(10);

		// -------------------------Labels----------------------------

		// Label que imprime já convertido
		setLblOutPutValue(new JLabel(""));
		getLblOutPutValue().setHorizontalAlignment(SwingConstants.RIGHT);// Alinhar Right
		getLblOutPutValue().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		getLblOutPutValue().setBounds(169, 130, 81, 30);
		contentPane.add(getLblOutPutValue());

		// Label que imprime o nome da moeda - (Tornar o nome da variavel mais generico
		setLblOutPutCoin(new JLabel(""));
		getLblOutPutCoin().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		getLblOutPutCoin().setBounds(251, 130, 81, 30);
		contentPane.add(getLblOutPutCoin());
		// Label do input de valor
		JLabel lblNewLabel_1 = new JLabel("Insira um valor:");
		lblNewLabel_1.setLabelFor(getTextInput());
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(53, 10, 138, 30);
		contentPane.add(lblNewLabel_1);

		// Botão Fechar janela
		JButton btnClose = new JButton("Fechar");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnClose.setBounds(346, 207, 95, 21);
		contentPane.add(btnClose);

		// -------------------------Botões----------------------------
		// Botão de Conversão
		setBtnCurrency(new JButton(""));
		getBtnCurrency().setIcon(
				new ImageIcon("C:\\Users\\emanu\\Documents\\Alura\\Java\\Conversor_Moeda\\src\\img\\sync_alt.png"));
		getBtnCurrency().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!getTextInput().getText().equals("")) {// O valor do input for diferente de vazio
					double Amount = Double.parseDouble(getTextInput().getText());// Transformando o input String em
																					// Double
//					System.out.println(getDeMoeda().getSelectedItem().toString());
//					lblOutPutCoin.setText(paraMoeda.getSelectedItem().toString());
//					lblOutPutValue.setText(getTextInput().getText().toString());
//					System.out.println(getTextInput().getText());
				} else {
					JOptionPane.showMessageDialog(getBtnCurrency(), "Insira um valor!!!");// Janela de Alerta
					System.out.println("Vazio");
				}
			}
		});
		getBtnCurrency().setBounds(209, 85, 68, 35);
		contentPane.add(getBtnCurrency());

		// Botão Retorno janela inicial
		JButton btnNewButton_1 = new JButton("Retorne");
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(221, 207, 95, 21);
		contentPane.add(btnNewButton_1);

		// -------------------------JcomboBox----------------------------

		// --------------- de Moeda------------------
		setDeMoeda(new JComboBox());
		getDeMoeda().setBounds(128, 85, 71, 35);
		getContentPane().add(getDeMoeda());
		// --------------- Para Moeda------------------
		paraMoeda = new JComboBox();
		paraMoeda.setBounds(287, 85, 71, 35);
		getContentPane().add(paraMoeda);

	}

	
	
	//-----------------------------GETTERS AND SETTERS-----------------------------
	public JTextField getTextInput() {
		return textInput;
	}

	public void setTextInput(JTextField textInput) {
		this.textInput = textInput;
	}

	public JButton getBtnCurrency() {
		return btnCurrency;
	}

	public void setBtnCurrency(JButton btnCurrency) {
		this.btnCurrency = btnCurrency;
	}

	public JComboBox getDeMoeda() {
		return deMoeda;
	}
	public JComboBox getParaMoeda() {
		return this.paraMoeda;
	}

	public void setDeMoeda(JComboBox deMoeda) {
		this.deMoeda = deMoeda;
	}

	public JLabel getLblOutPutValue() {
		return lblOutPutValue;
	}

	public void setLblOutPutValue(JLabel lblOutPutValue) {
		this.lblOutPutValue = lblOutPutValue;
	}

	public JLabel getLblOutPutCoin() {
		return lblOutPutCoin;
	}
	


	public void setLblOutPutCoin(JLabel lblOutPutCoin) {
		this.lblOutPutCoin = lblOutPutCoin;
	}
}
