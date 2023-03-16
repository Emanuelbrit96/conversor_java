package screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Main extends JFrame {
	private JComboBox comboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	public Main() {
		getContentPane().setBackground(new Color(25, 25, 112));

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\emanu\\Documents\\Alura\\Java\\Conversor_Moeda\\src\\img\\autorenew_FILL0_wght400_GRAD0_opsz48.png"));
		setResizable(false);
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecione uma opção:");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 21, 300, 25);
		getContentPane().add(lblNewLabel);
		comboBox = new JComboBox<Object>();
		lblNewLabel.setLabelFor(comboBox);
		comboBox.setForeground(SystemColor.activeCaption);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Conversor de Moeda", "Conversor de Temperatura" }));
		comboBox.setBounds(50, 50, 300, 25);
		getContentPane().add(comboBox);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
				CoinsCurrency coin = new CoinsCurrency();
				coin.setVisible(true);
					setVisible(false);
				} else {
					Temperature temp = new Temperature();
					temp.setVisible(true);
					setVisible(false);
				}
			}
		});

		btnOK.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnOK.setBounds(50, 99, 125, 25);
		getContentPane().add(btnOK);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(225, 100, 125, 25);
		getContentPane().add(btnCancelar);
	}
}
