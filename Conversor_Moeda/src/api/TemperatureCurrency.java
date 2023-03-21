package api;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class TemperatureCurrency {

	private String primeraEscalaTemperatura;
	private String segundaEscalaTemperatura;

	public TemperatureCurrency(String primeraEscalaTemperatura, String segundaEscalaTemperatura) {
		this.primeraEscalaTemperatura = primeraEscalaTemperatura;
		this.segundaEscalaTemperatura = segundaEscalaTemperatura;
	}

	public String corverter(double valor) {

//		Celsius para Kelvin: K = C + 273.15
//		Kelvin para Celsius: C = K - 273.15
//		Celsius para Fahrenheit: F = (C * 1.8) + 32
//		Fahrenheit para Celsius: C = (F - 32) / 1.8
//		Kelvin para Fahrenheit: F = (K - 273.15) * 1.8 + 32
//		Fahrenheit para Kelvin: K = (F - 32) / 1.8 + 273.15

		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		Map<String, Map<String, Double>> conversionRates = new HashMap<>();
		conversionRates.put("Celsius", Map.of("Kelvin", valor + 273.15, "Fahrenheit", (valor * 1.8) + 32));
		conversionRates.put("Kelvin", Map.of("Celsius", valor - 273.15, "Fahrenheit", (valor - 273.15) * 1.8 + 32));
		conversionRates.put("Fahrenheit", Map.of("Celsius", (valor - 32) / 1.8, "Kelvin", (valor - 32) / 1.8 + 273.15));

		if (primeraEscalaTemperatura != segundaEscalaTemperatura) {
			double conversionRate = conversionRates.get(primeraEscalaTemperatura).get(segundaEscalaTemperatura);
			double value = conversionRate + 0;
			return decimalFormat.format(value);

		}
		return decimalFormat.format(valor);

	}

}
