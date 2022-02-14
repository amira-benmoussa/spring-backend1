package com.elcom.flux.services;

import java.util.Optional;

import com.elcom.flux.requests.PasswordRequest;
import com.elcom.flux.responses.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elcom.flux.entities.Responsable;
import com.elcom.flux.repositories.ResponsableRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ResponsableRepository responsableRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Responsable> responsable = responsableRepository.findByEmail(username);
        if (!responsable.isPresent()) {
            responsable = responsableRepository.findByMatricule(username);
        }
        return responsable.get();
    }


    public MessageResponse changePassword(PasswordRequest passwordRequest) {
        Responsable responsable = responsableRepository.findById(passwordRequest.getId()).orElse(null);
        if (responsable == null) {
            return new MessageResponse(false, "Attention", "Responsable n'existe pas");
        }

        boolean matched = passwordEncoder.matches(passwordRequest.getOldPassword(), responsable.getPassword());

        if (!matched) {
            return new MessageResponse(false, "Attention", "Ancien mot de passe incorrect");
        }

        String password = passwordEncoder.encode(passwordRequest.getNewPassword());
        responsable.setPassword(password);
        responsableRepository.save(responsable);

        return new MessageResponse(true, "Succès", "Mot de passe modifié");
    }
}
