
package za.co.eesoco;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import za.co.eesoco.domain.User;
import za.co.eesoco.repository.UserRepository;

/*In spring boot we have various

@Annotation we can use for test to indicate the type of test we are running,
In this case its a DataJPA Test Spring DataJPAtest provides EntityManager
Class we can use to perform Assertion by creating a new EntityManager
Instance And we have to set the Database tobe persisted
using @AutoConfigureTestDatabase
*/
@DataJpaTest

@AutoConfigureTestDatabase(replace = Replace.NONE)

@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void createUser() {
		User user = new User();

		user.setUserName("Nik");
		user.setPassword("mckenn91");
		user.setEmail("mckenn91@gmail.com");
		User savedUser = userRepository.save(user);

		User existUser = entityManager.find(User.class, savedUser.getId());
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

	}

}
