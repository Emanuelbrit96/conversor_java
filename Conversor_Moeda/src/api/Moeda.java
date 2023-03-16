package api;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Moeda {
	private String primeiraMoeda;
	private String segundaMoeda;
	private double value;

	public Moeda(String primeiraMoeda, String segundaMoeda) {
		this.primeiraMoeda = primeiraMoeda;
		this.segundaMoeda = segundaMoeda;
	}

	public String corverter(double valor) {

		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		// conversionRates = {
		// BRL = {
		// BRL:valor,
		// USD:valor,
		// EUR:valor},
		// USD = {
		// BRL:valor,
		// USD:valor,
		// EUR :valor},},
		// EUR = {
		// BRL:valor,
		// USD:valor,
		// EUR:valor}
		// };

		Map<String, Map<String, Double>> conversionRates = new HashMap<>();
		conversionRates.put("BRL",
				Map.of("USD", 1 / 5.29, "EUR", 1 / 6.0, "GBP", 1 / 6.38, "JPY", 1 / 0.0397, "KRW", 1 / 0.0040));
		conversionRates.put("USD", Map.of("BRL", 5.29, "EUR", 0.95, "GBP", 0.83, "JPY", 133.31, "KRW", 1313.10));
		conversionRates.put("EUR", Map.of("USD", 1.06, "BRL", 5.60, "GBP", 0.88, "JPY", 141.00, "KRW", 1386.19));
		conversionRates.put("GBP", Map.of("USD", 1.21, "EUR", 1.14, "BRL", 6.38, "JPY", 160.74, "KRW", 1583.67));
		conversionRates.put("JPY", Map.of("USD", 0.0075, "EUR", 0.0071, "GBP", 0.0062, "BRL", 0.040, "KRW", 9.85));
		conversionRates.put("KRW", Map.of("USD", 0.00076, "EUR", 0.00072, "GBP", 0.00063, "JPY", 0.010, "BRL", 0.0040));

		if (primeiraMoeda != segundaMoeda) {
			double conversionRate = conversionRates.get(primeiraMoeda).get(segundaMoeda);
			double value = valor * conversionRate;
			return decimalFormat.format(value);
		}
		return decimalFormat.format(valor);
		
		
		
		
		

//		DecimalFormat decimalFormat = new DecimalFormat("#.##");
//		switch (primeiraMoeda) {
//		case "BRL":
//			if (segundaMoeda == "USD") {
//				value = valor / 5.29;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "EUR") {
//				value = valor / 6;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "GBP") {
//				value = valor / 6.38;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "JPY") {
//				value = valor / 0.0397;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "KRW") {
//				value = valor / 0.0040;
//				return decimalFormat.format(value);
//			}
//			break;
//		case "USD":
//			if (segundaMoeda == "BRL") {
//				value = valor * 5.29;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "EUR") {
//				value = valor * 0.95;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "GBP") {
//				value = valor * 0.83;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "JPY") {
//				value = valor * 133.31;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "KRW") {
//				value = valor * 1313.10;
//				return decimalFormat.format(value);
//			}
//			break;
//		case "EUR":
//			if (segundaMoeda == "USD") {
//				value = valor * 1.06;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "BRL") {
//				value = valor * 5.60;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "GBP") {
//				value = valor * 0.88;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "JPY") {
//				value = valor * 141.00;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "KRW") {
//				value = valor * 1386.19;
//				return decimalFormat.format(value);
//			}
//			break;
//		case "GBP":
//			if (segundaMoeda == "USD") {
//				value = valor * 1.21;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "EUR") {
//				value = valor * 1.14;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "BRL") {
//				value = valor * 6.38;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "JPY") {
//				value = valor * 160.74;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "KRW") {
//				value = valor * 1583.67;
//				return decimalFormat.format(value);
//			}
//			break;
//		case "JPY":
//			if (segundaMoeda == "USD") {
//				value = valor * 0.0075;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "EUR") {
//				value = valor * 0.0071;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "GBP") {
//				value = valor * 0.0062;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "BRL") {
//				value = valor * 0.040;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "KRW") {
//				value = valor * 9.85;
//				return decimalFormat.format(value);
//			}
//			break;
//		case "KRW":
//			if (segundaMoeda == "USD") {
//				value = valor * 0.00076;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "EUR") {
//				value = valor * 0.00072;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "GBP") {
//				value = valor * 0.00063;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "JPY") {
//				value = valor * 0.010;
//				return decimalFormat.format(value);
//			} else if (segundaMoeda == "BRL") {
//				value = valor * 0.0040;
//				return decimalFormat.format(value);
//			}
//			break;
//		default:
//			break;
//		}
//		return decimalFormat.format(valor);

	}
}
