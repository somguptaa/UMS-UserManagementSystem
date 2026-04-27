package com.ums.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ums.entity.User;
import com.ums.enums.UserStatus;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	List<User> findByStatus(UserStatus status);
}
