package com.ums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ums.entity.User;
import com.ums.enums.UserStatus;
import com.ums.exception.UserIdNotFoundException;
import com.ums.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository repository;

	@Override
	public User createUser(User user) {
		user.setStatus(UserStatus.ACTIVE); // always start as ACTIVE
		return repository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new UserIdNotFoundException("User Not Found With This User Id"));
	}

	@Override
	public User updateUser(Long id, User user) {
		User existinguser = getUserById(id);
		existinguser.setName(user.getName());
		existinguser.setEmail(user.getEmail());
		existinguser.setMobileNo(user.getMobileNo());
		existinguser.setStatus(user.getStatus());
		return repository.save(existinguser);
	}

	@Override
	public void deleteUser(Long id) {
		User user = getUserById(id);
		repository.delete(user);

	}

	@Override
	public List<User> getUserByStatus(UserStatus status) {
		return repository.findByStatus(status);
	}

	@Override
	public User updateUserStatus(Long id, UserStatus status) {
		User user = getUserById(id); // reusing existing method
		user.setStatus(status);
		return repository.save(user); 
	}

}
