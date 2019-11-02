package com.kun.services;

import com.kun.models.User;
import com.kun.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import  org.springframework.security.core.userdetails.User.UserBuilder;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    //Spring security specific
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        UserBuilder userBuilder = null;

        if (user != null) {

            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(user.getPassword());
            userBuilder.disabled(!user.isEnabled());
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
