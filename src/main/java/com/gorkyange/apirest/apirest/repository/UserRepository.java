package com.gorkyange.apirest.apirest.repository;

import com.gorkyange.apirest.apirest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
