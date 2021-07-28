
package za.co.eesoco.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.eesoco.domain.User;
import za.co.eesoco.service.RegistrationService;

@RestController

@RequestMapping("/api")
public class RegistrationAndLoginResource {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {

		String tempEmailId = user.getEmail();

		if (tempEmailId != null && !"".equals(tempEmailId)) {

			User userObj = registrationService.fetchUserByEmail(tempEmailId);

			if (userObj != null) {
				throw new Exception("user with " + tempEmailId + "already exist");

			}

		}

		User userObj = null;

		userObj = registrationService.addUser(user);
		return userObj;

	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User userLogin(@RequestBody User user) throws Exception {

		String tempEmail = user.getEmail();
		String tempPassword = user.getPassword();

		User userObj = null;

		if (tempEmail != null && tempPassword != null) {
			userObj = registrationService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
		}
		if (userObj == null) {
			throw new Exception("No such user" + " or Wrong username and Password");

		}
		return userObj;

	}

}
