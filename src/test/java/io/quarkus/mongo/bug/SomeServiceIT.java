package io.quarkus.mongo.bug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.bson.Document;
import org.junit.jupiter.api.Test;

import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.result.InsertOneResult;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SomeServiceIT {
	private static final String DOC_ID = "abcdef";
	@Inject
	private SomeService target;

	@Inject
	private MongoClient client;

	private void setup() {
		final String strDoc = "{ \"_id\": \"" + DOC_ID + "\", \"data\":\"21.01\" }";
		final InsertOneResult res =
			client.getDatabase("somedb")
				.getCollection("somecollection").withWriteConcern(WriteConcern.MAJORITY)
				.insertOne(Document.parse(strDoc));
		assertTrue(res.wasAcknowledged());
	}

	@Test
	public void getById() {
		System.out.println(">>>> TEST <<<<<");
		setup();

		final SomeEntity e = target.getEntityById(DOC_ID);
		assertEquals(e.getData(), new BigDecimal("21.01"));
	}
}
