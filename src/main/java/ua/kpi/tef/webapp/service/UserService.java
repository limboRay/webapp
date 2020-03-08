package ua.kpi.tef.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.tef.webapp.dto.UserListDTO;
import ua.kpi.tef.webapp.entity.User;
import ua.kpi.tef.webapp.dto.UserDTO;
import ua.kpi.tef.webapp.repository.UserRepository;

import java.util.Optional;


@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserListDTO getAllUsers() {
		//TODO checking for an empty user list
		return new UserListDTO(userRepository.findAll());
	}

	public Optional<User> findByUserLogin (UserDTO userDTO){
		//TODO check for user availability. password check
		return userRepository.findByEmail(userDTO.getEmail());
	}

	public void saveNewUser (User user){
		//TODO inform the user about the replay email
		// TODO exception to endpoint
		try {
			userRepository.save(user);
		} catch (Exception ex){
			System.out.println("Error: duplicate user email");
		}

	}
}
