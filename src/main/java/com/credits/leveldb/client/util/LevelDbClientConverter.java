package com.credits.leveldb.client.util;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.credits.client.node.thrift.generated.Amount;
import com.credits.client.node.thrift.generated.AmountCommission;
import com.credits.common.exception.CreditsException;
import com.credits.common.utils.Const;
import com.credits.leveldb.client.exception.LevelDbClientException;

public class LevelDbClientConverter {

	public static Double amountToDouble(Amount amount) {

		Integer integralPart = amount.getIntegral();
		Double fractionPart = amount.getFraction() / 1000000000000000000D;
		return Double.valueOf(integralPart) + fractionPart;
	}

	public static BigDecimal amountToBigDecimal(Amount amount) throws LevelDbClientException {

		Integer integralPart = amount.getIntegral();
		BigDecimal fractionPart = null;
		try {
			fractionPart = com.credits.common.utils.Converter.toBigDecimal(amount.getFraction())
					.divide(com.credits.common.utils.Converter.toBigDecimal("1000000000000000000"));
		} catch (CreditsException e) {
			throw new LevelDbClientException(e);
		}

		integralPart += fractionPart.intValue();
		String integralPartAsString = com.credits.common.utils.Converter.toString(integralPart);
		String fractionPartAsString = com.credits.common.utils.Converter.toString(fractionPart);
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Const.LOCALE);
		char sep = symbols.getDecimalSeparator();
		String separator = Character.toString(sep);

		if (fractionPartAsString.contains(separator)) {
			String[] valueDelimited = fractionPartAsString.split("\\" + separator);
			fractionPartAsString = valueDelimited[1];
		} else {
			fractionPartAsString = "0";
		}
		return new BigDecimal(String.format("%s.%s", integralPartAsString, fractionPartAsString));
	}

	public static Amount doubleToAmount(Double value) throws LevelDbClientException {

		if (value == null) {
			throw new LevelDbClientException("value is null");
		}
		String valueAsString = String.format(Locale.ROOT, "%.18f", value);
		String[] valueDelimited = valueAsString.split("\\.");
		Integer integral = Integer.valueOf(valueDelimited[0]);
		Long fraction = Long.valueOf(valueDelimited[1]);
		return new Amount(integral, fraction);
	}

	public static Amount bigDecimalToAmount(BigDecimal value) throws LevelDbClientException {

		if (value == null) {
			throw new LevelDbClientException("value is null");
		}

		Integer integral;

		Long fraction;

		String valueAsString = com.credits.common.utils.Converter.toString(value);

		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Const.LOCALE);
		char sep = symbols.getDecimalSeparator();
		String separator = Character.toString(sep);

		if (valueAsString.contains(separator)) {
			String[] valueDelimited = valueAsString.split("\\" + separator);
			integral = Integer.valueOf(valueDelimited[0]);
			String fractionAsString = String.format("%-18s", valueDelimited[1]).replace(' ', '0');
			fraction = Long.valueOf(fractionAsString);
		} else {
			integral = Integer.valueOf(valueAsString);
			fraction = 0L;
		}
		return new Amount(integral, fraction);
	}

	public static AmountCommission bigDecimalToAmountCommission(BigDecimal value) throws LevelDbClientException {
		if (value == null) {
			throw new LevelDbClientException("value is null");
		}

		Short integral;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Const.LOCALE);
		char sep = symbols.getDecimalSeparator();
		String separator = Character.toString(sep);

		String valueAsString = com.credits.common.utils.Converter.toString(value);
		if (valueAsString.contains(separator)) {
			String[] valueDelimited = valueAsString.split("\\" + separator);
			integral = Short.valueOf(valueDelimited[0]);
		} else {
			integral = Short.valueOf(valueAsString);

		}
		return new AmountCommission(new Short(integral));
	}

}
