package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entry.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where name = ?1")
	List<User> findByName(String name);

	@Query(value = "select u.* from users u where u.name = ?1", nativeQuery = true)
	List<User> findByName2(String name);
}
