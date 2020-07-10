package com.sinervis.webapp.ortolano.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinervis.webapp.ortolano.model.User;

public interface UserRepositoryInterface extends JpaRepository<User, Integer>{

}
