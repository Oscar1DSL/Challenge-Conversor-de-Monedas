import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Converter {
    private float finalValue;

    public float Converter(String primaryCurrency, String secondaryCurrency, float numValue) {
        MonetaryExchangeRate conversion = new MonetaryExchangeRate();

        Currency currency = conversion.fnConvertCurrency(primaryCurrency, secondaryCurrency, numValue);
        var valueConverter = currency.conversion_rate();
        return numValue * valueConverter;
    }
}
