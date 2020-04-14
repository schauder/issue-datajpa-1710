package de.schauderhaft.issuedatajpa1710;

import io.netty.resolver.RoundRobinInetAddressResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	void findByNameAsync() {

		Person one = createPerson();

		persons.save(one);

		Person reloaded = persons.findAsyncByName("one");

		assertThat(reloaded).isNotNull();

	}

	private Person createPerson() {
		Person one = new Person();
		one.id = 1L;
		one.name = "one";
		return one;
	}

}
