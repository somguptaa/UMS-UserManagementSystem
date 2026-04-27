package com.ums.service;

import java.util.List;

import com.ums.entity.User;
import com.ums.enums.UserStatus;

public interface IUserService {

	public User createUser(User user);
	public List<User> getAllUser();
	public User getUserById(Long id);
	public User updateUser(Long id, User user);
	public void deleteUser(Long id);
	public List<User> getUserByStatus(UserStatus status);
	public User updateUserStatus(Long id, UserStatus status);

}
