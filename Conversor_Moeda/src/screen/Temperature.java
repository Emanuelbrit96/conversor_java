package screen;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Temperature extends ScreenPadrao{
	private List<String> list = new ArrayList<String>();
	public Temperature () {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\emanu\\Documents\\Alura\\Java\\Conversor_Moeda\\src\\img\\thermostat.png"));
		setTitle("Conversor de Temperatura");
		getContentPane().setBackground(new Color(150, 150, 255));
		list.add("Celsius");
		list.add("Kelvin");
		list.add("Fahrenheit");
		setLs(list);
		
		getBtnCurrency().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(getTextInput().getText() + " Temperature");
			}
		});
		
		
	}
	
}
