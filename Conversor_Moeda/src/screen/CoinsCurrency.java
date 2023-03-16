package screen;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import api.Moeda;

public class CoinsCurrency extends ScreenPadrao {

	private List<String> list = new ArrayList<String>();

	public CoinsCurrency() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\emanu\\git\\repository\\Conversor_Moeda\\src\\img\\currency_exchang.png"));
		setTitle("Conversor de Moeda");
		getContentPane().setBackground(new Color(150, 255, 150));

		list.add("BRL");
		list.add("USD");
		list.add("EUR");
		list.add("GBP");
		list.add("JPY");
		list.add("KRW");

		setLs(list);

		getBtnCurrency().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!getTextInput().getText().equals("")) {
					
					String primeiraMoeda = getDeMoeda().getSelectedItem().toString();
					String segundaMoeda = getParaMoeda().getSelectedItem().toString();
					double valor =  Double.parseDouble(getTextInput().getText());
					
					Moeda coin = new Moeda(primeiraMoeda, segundaMoeda);
					String valorConvertido = coin.corverter(valor);
					
										
//					System.out.println(valorConvertido+ " Coins Currency");
//					System.out.println(getDeMoeda().getSelectedItem().toString() + " Coins Currency");
//					System.out.println(getParaMoeda().getSelectedItem().toString() + " Coins Currency");
					getLblOutPutValue().setText(valorConvertido);
					//getLblOutPutValue().setText(Double.toString(valorConvertido)); Como converter se o retorno fosse double
					getLblOutPutCoin().setText(getParaMoeda().getSelectedItem().toString());
					
					
					
				} else {

				}
			}
		});
	}

}
