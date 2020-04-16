package de.schauderhaft.issuedatajpa1710;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class IssueDatajpa1710ApplicationTests {

	@Autowired
	Persons persons;

	@Test
	void findByName() {

		Person one = createPerson();

		persons.save(one);

		Person reloaded = persons.findByName("one");

		assertThat(reloaded).isNotNull();

	}

	@Test
	void findCfBy() throws InterruptedException, ExecutionException, TimeoutException {

		Person one = createPerson();

		persons.save(one);

		Person reloaded = persons.findCfByName("one").get(1, TimeUnit.SECONDS);

		assertThat(reloaded).isNotNull();

	}

	private Person createPerson() {
		Person one = new Person();
		one.id = 1L;
		one.name = "one";
		return one;
	}

}
