package io.quarkus.mongo.bug;

import java.math.BigDecimal;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@MongoEntity(collection = "somecollection")
public class SomeEntity extends PanacheMongoEntityBase  {

	@BsonId
	private String id;
	private BigDecimal data;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public BigDecimal getData() {
		return data;
	}

	public void setData(final BigDecimal data) {
		this.data = data;
	}
}
