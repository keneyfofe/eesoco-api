
package za.co.eesoco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.eesoco.domain.User;

//note the Registration will act on the user entity passed in then argument*/

@Repository
public interface RegistrationRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
	public User findByEmailAndPassword(String email, String password);
	

}
