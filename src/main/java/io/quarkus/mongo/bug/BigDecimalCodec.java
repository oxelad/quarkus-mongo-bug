package io.quarkus.mongo.bug;

import java.math.BigDecimal;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class BigDecimalCodec implements Codec<BigDecimal> {

	@Override
	public BigDecimal decode(final BsonReader reader, final DecoderContext decoderContext) {
		final String str = reader.readString();
		if (str == null) {
			return null;
		}

		try {
			return new BigDecimal(str);
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void encode(final BsonWriter writer, final BigDecimal value, final EncoderContext encoderContext) {
		writer.writeString(value.toString());
	}

	@Override
	public Class getEncoderClass() {
		return BigDecimal.class;
	}
}
