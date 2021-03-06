package com.credits.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.credits.client.node.thrift.generated.Amount;
import com.credits.common.exception.CreditsCommonException;
import com.credits.leveldb.client.exception.LevelDbClientException;

public class TransactionStruct implements Serializable {
	private long id;
	private byte[] source;
	private byte[] target;
	private int amountInt;
	private long amountFrac;
	// private int feeInt;
	// private long feeFrac;
	private short fee;
	private byte currency;
	private int ufNum;
	private int scLen;
	private byte[] sc;

	public TransactionStruct(long id, String source, String target, BigDecimal amount, short fee, byte currency,
			byte[] sc)
			throws CreditsCommonException, LevelDbClientException {
		this.id = id;
		this.source = Converter.decodeFromBASE58(source);
		this.target = Converter.decodeFromBASE58(target);

		Amount aAmount = Converter.bigDecimalToAmount(amount);
		this.amountInt = aAmount.integral;
		this.amountFrac = aAmount.fraction;

		// Amount aFee = LevelDbClientConverter.bigDecimalToAmount(fee);
		// this.feeInt = aFee.integral;
		// this.feeFrac = aFee.fraction;

		this.fee = fee;

		this.currency = currency;

		if (sc == null)
			ufNum = 0;
		else {
			this.ufNum = 1;
			this.scLen = sc.length;
			this.sc = sc;
		}
	}

	public byte[] getBytes() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			byte[] idWrite = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(id).array();
			for (int i = 0; i < 6; i++) {
				os.write(idWrite[i]);
			}
			// os.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(id).array());
			os.write(source);
			os.write(target);
			os.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(amountInt).array());
			os.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(amountFrac).array());
			// os.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(feeInt).array());
			// os.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(feeFrac).array());
			os.write(ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(fee).array());
			os.write(ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN).put(currency).array());
			// os.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ufNum).array());
			os.write(ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN).put((byte) 0).array());
			// if (sc != null) {
			// os.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(scLen).array());
			// os.write(ByteBuffer.allocate(scLen).order(ByteOrder.LITTLE_ENDIAN).put(sc).array());
			// }
		} catch (IOException e) {
			// do nothing - never happen
		}
		return os.toByteArray();
	}

	public int getScLen() {
		return scLen;
	}
}
