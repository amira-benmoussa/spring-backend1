package com.elcom.flux.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Responsable;
import com.elcom.flux.repositories.ResponsableRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private ResponsableRepository responsableRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Responsable> responsable = responsableRepository.findByEmail(username);
		if (responsable.isEmpty()) {
			responsable = responsableRepository.findByMatricule(username);
		}
		return responsable.get();
	}

}
