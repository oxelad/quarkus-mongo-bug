package io.quarkus.mongo.bug;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SomeService {

	public SomeEntity getEntityById(final String id) {
		return SomeEntity.findById(id);
	}
}
