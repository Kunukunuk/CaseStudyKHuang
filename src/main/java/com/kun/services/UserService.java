package com.kun.services;

import com.kun.models.Credential;
import com.kun.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import  org.springframework.security.core.userdetails.User.UserBuilder;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    CredentialRepository credentialRepository;

    public void saveUser(Credential credential) {
        credentialRepository.save(credential);
    }

    //Spring security specific
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential user = credentialRepository.findByUsername(username);

        UserBuilder userBuilder = null;

        if (user != null) {

            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(user.getPassword());
            String[] authorities = user.getAuthorities().stream()
                    .map(
                            a-> a.getAuthority()).toArray(String[]::new);

            userBuilder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User Not Found");
        }
        return userBuilder.build();
    }
}
