package io.quarkus.mongo.bug;

import java.math.BigDecimal;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class CustomCodecsProvider implements CodecProvider {

	@Override
	public <T> Codec<T> get(final Class<T> clazz, final CodecRegistry registry) {
		if (clazz == BigDecimal.class) {
			return (Codec<T>) new BigDecimalCodec();
		}
		return null;
	}
}
