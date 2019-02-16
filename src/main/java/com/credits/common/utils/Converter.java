package com.credits.common.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Base64;

import org.apache.commons.beanutils.converters.BigDecimalConverter;

import com.credits.common.exception.CreditsCommonException;

public class Converter {

	public static final String DOUBLE_FORMAT = "#.##################";

	public static String toString(Object value) {
		if (value instanceof Double) {
			NumberFormat nf = NumberFormat.getNumberInstance(Const.LOCALE);
			DecimalFormat df = (DecimalFormat) nf;
			df.applyPattern(DOUBLE_FORMAT);
			return df.format(value);
		}
		if (value instanceof Integer) {
			return String.valueOf(value);
		}
		if (value instanceof Long) {
			return String.valueOf(value);
		}
		if (value instanceof BigDecimal) {
			BigDecimalConverter bigDecimalConverter = new BigDecimalConverter();
			bigDecimalConverter.setLocale(Const.LOCALE);
			bigDecimalConverter.setPattern("#.##################");
			return (String) bigDecimalConverter.convert(String.class, value);
		}
		return null;
	}

	public static Double toDouble(Object value) throws CreditsCommonException {
		if (value instanceof String) {
			NumberFormat nf = NumberFormat.getNumberInstance(Const.LOCALE);
			DecimalFormat df = (DecimalFormat) nf;
			df.applyPattern(DOUBLE_FORMAT);
			try {
				return (Double) df.parse((String) value);
			} catch (ParseException e) {
				throw new CreditsCommonException(e);
			}
		}
		return null;
	}

	public static BigDecimal toBigDecimal(Object value) throws CreditsCommonException {

		if (value == null) {
			return BigDecimal.ZERO;
		}

		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Const.LOCALE);

		if (value instanceof String) {
			String valueAsString = (String) value;

			if (Utils.isEmpty(valueAsString)) {
				return BigDecimal.ZERO;
			}

			String pattern = "#,##0.0#";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
			decimalFormat.setParseBigDecimal(true);

			try {
				return (BigDecimal) decimalFormat.parse(valueAsString);
			} catch (ParseException e) {
				throw new CreditsCommonException(e);
			}
		}

		if (value instanceof Double) {
			Double doubleValue = (Double) value;
			String text = Converter.toString(Math.abs(doubleValue));
			int integerPlaces = text.indexOf(symbols.getDecimalSeparator());
			int decimalPlaces = text.length() - integerPlaces - 1;
			return new BigDecimal(doubleValue, new MathContext(decimalPlaces));
		}

		if (value instanceof Long) {
			return new BigDecimal((Long) value);
		}

		return null;
	}

	public static String encodeToBASE64(byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}

	public static byte[] decodeFromBASE64(String string) {
		return Base64.getDecoder().decode(string);
	}

	public static String encodeToBASE58(byte[] bytes) {
		return Base58.encode(bytes);
	}

	public static byte[] decodeFromBASE58(String string) throws CreditsCommonException {
		return Base58.decode(string);
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	public static ByteBuffer bytesToByteBuffer(byte[] bytes) {
		return ByteBuffer.wrap(bytes);
	}

	public static String byteArrayToString(byte[] bytes, String delimiter) {
		if (delimiter == null || delimiter == "") {
			delimiter = " ";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(b + delimiter);
		}
		return stringBuilder.toString();
	}

}
