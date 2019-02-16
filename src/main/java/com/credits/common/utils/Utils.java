package com.credits.common.utils;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.security.PrivateKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.credits.crypto.Ed25519;

public class Utils {

	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	private static final String ALPHA_LOWER_CASE_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

	/**
	 * Gets the subarray
	 * 
	 * @param array
	 *            - source
	 * @param offset
	 *            - starts position
	 * @param length
	 *            - length
	 * @return
	 */
	public static byte[] parseSubarray(byte[] array, int offset, int length) {
		byte[] result = new byte[length];
		System.arraycopy(array, offset, result, 0, length);
		return result;
	}

	/**
	 * Concatinate byte arrays
	 * 
	 * @param firstArr
	 * @param secondArr
	 * @return
	 */
	public static byte[] concatinateArrays(byte[] firstArr, byte[] secondArr) {
		byte[] resultArr = new byte[firstArr.length + secondArr.length];
		System.arraycopy(firstArr, 0, resultArr, 0, firstArr.length);
		System.arraycopy(secondArr, 0, resultArr, firstArr.length, secondArr.length);
		return resultArr;
	}

	// Returns a copy of the given byte array in reverse order.
	public static byte[] reverseBytes(byte[] bytes) {
		byte[] buf = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++)
			buf[i] = bytes[bytes.length - 1 - i];
		return buf;
	}

	public static String randomAlphaLowerCaseNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_LOWER_CASE_NUMERIC_STRING.length());
			builder.append(ALPHA_LOWER_CASE_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static boolean isEmpty(final Object object) {
		if (object instanceof String) {
			return object == null || ((String) object).trim().isEmpty();
		} else if (object instanceof ByteBuffer) {
			return object == null || ((ByteBuffer) object).position() == 0;
		} else if (object instanceof byte[]) {
			return object == null || ((byte[]) object).length == 0;
		} else {
			return object == null;
		}

	}

	public static ByteBuffer signTransactionStruct(TransactionStruct tStruct, PrivateKey privateKey) {
		ByteBuffer signature;
		try {
			byte[] tArr = tStruct.getBytes();

			LOGGER.debug("Smart contract length = " + tStruct.getScLen());
			LOGGER.debug("Transaction structure length = " + tArr.length);
			LOGGER.debug("Transaction structure ^^^^^ ");
			String arrStr = "";
			for (int i = 0; i < tArr.length; i++)
				arrStr = arrStr + ((i == 0 ? "" : ", ") + tArr[i]);
			LOGGER.debug(arrStr);
			LOGGER.debug("--------------------- vvvvv ");

			byte[] signatureArr = Ed25519.sign(tArr, privateKey);

			LOGGER.debug("Signature ^^^^^ ");
			arrStr = "";
			for (int i = 0; i < signatureArr.length; i++)
				arrStr = arrStr + ((i == 0 ? "" : ", ") + signatureArr[i]);
			LOGGER.debug(arrStr);
			LOGGER.debug("--------- vvvvv ");

			signature = ByteBuffer.wrap(signatureArr);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			signature = ByteBuffer.wrap(new byte[] {});
		}
		return signature;
	}

	public static int getNumberOfDecimalPlaces(BigDecimal bigDecimal) {
		String string = bigDecimal.stripTrailingZeros().toPlainString();
		int index = string.indexOf(".");
		return index < 0 ? 0 : string.length() - index - 1;
	}
}