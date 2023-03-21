package screen;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import api.TemperatureCurrency;

public class Temperature extends ScreenPadrao {
	private List<String> list = new ArrayList<String>();

	public Temperature() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\emanu\\git\\repository\\Conversor_Moeda\\src\\img\\thermostat.png"));
		setTitle("Conversor de Temperatura");
		getContentPane().setBackground(new Color(150, 150, 255));
		list.add("Celsius");
		list.add("Kelvin");
		list.add("Fahrenheit");
		setLs(list);

		getBtnCurrency().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!getTextInput().getText().equals("")) {
					String primeiraEscala = getDeMoeda().getSelectedItem().toString();
					String segundaEscala = getParaMoeda().getSelectedItem().toString();
					double valor = Double.parseDouble(getTextInput().getText());

					TemperatureCurrency temp = new TemperatureCurrency(primeiraEscala, segundaEscala);
					String valorConvertido = temp.corverter(valor);

					getLblOutPutValue().setText(valorConvertido);
					getLblOutPutCoin().setText(getParaMoeda().getSelectedItem().toString());

//					System.out.println(getTextInput().getText() + " Temperature");
				}

			}
		});

	}

}
