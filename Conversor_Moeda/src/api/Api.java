package api;
//package api;
//
//import java.io.IOException;
//import okhttp3.*;
//
//public class Api {
//	public static void main(String[] args) throws IOException {
//		try {
//			OkHttpClient client = new OkHttpClient().newBuilder().build();
//			Request request = new Request.Builder()
//					.url("https://api.apilayer.com/currency_data/convert?to=usd&from=brl&amount=5")
//					.addHeader("apikey", "zg5x26BCRsAXgsIcDN0o6oo71wZHon9e").method("GET", null).build();
//
//			Response response = client.newCall(request).execute();
//			System.out.println(response.body().string());
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//}

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Api {
    private static final BigDecimal DEFAULT_RATE = BigDecimal.ONE;
    private BigDecimal rate;
    private Currency fromCurrency;
    private Currency toCurrency;

    public Api(Currency fromCurrency, Currency toCurrency, BigDecimal rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = (rate == null ? DEFAULT_RATE : rate);
    }

    public Api(Currency fromCurrency, Currency toCurrency) {
        this(fromCurrency, toCurrency, null);
    }

    public BigDecimal convert(BigDecimal amount) {
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        Api converter = new Api(Currency.getInstance("USD"), Currency.getInstance("EUR"), BigDecimal.valueOf(0.83));
        BigDecimal amount = BigDecimal.valueOf(1000);
        BigDecimal convertedAmount = converter.convert(amount);
        System.out.println(amount + " " + converter.fromCurrency + " = " + convertedAmount + " " + converter.toCurrency);
    }
}
