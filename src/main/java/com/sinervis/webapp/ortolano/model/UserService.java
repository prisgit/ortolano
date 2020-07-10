package com.sinervis.webapp.ortolano.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sinervis.webapp.ortolano.repository.UserRepositoryInterface;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepositoryInterface userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) return user.get();
		else throw new UsernameNotFoundException("Credentials not valid");
	}
}
