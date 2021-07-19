
package za.co.eesoco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.eesoco.domain.User;
import za.co.eesoco.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;

	public User addUser(User user) {
		return registrationRepo.save(user);
	}

	public User fetchUserByEmail(String email) {
		return registrationRepo.findByEmail(email);
	}
	public User fetchUserByEmailAndPassword(String email,String password) {
		return registrationRepo.findByEmailAndPassword(email, password);
	}
	
}
