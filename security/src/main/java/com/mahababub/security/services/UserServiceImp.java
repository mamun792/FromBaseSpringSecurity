package com.mahababub.security.services;

import com.mahababub.security.model.Authority;
import com.mahababub.security.model.User;
import com.mahababub.security.repository.AuthorityRepository;
import com.mahababub.security.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImp implements  UserSerive{

    private  final UserRepository userRepository;
    private  final AuthorityRepository authorityRepository;
    private  final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username){
       return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Authority authority = authorityRepository.findByAuthority("ROLE_USER");
        user.setAuthorities(Set.of(authority));
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Authority authority = authorityRepository.findByAuthority("ROLE_ADMIN");
        user.setAuthorities(Set.of(authority));
        userRepository.save(user);
    }
}
