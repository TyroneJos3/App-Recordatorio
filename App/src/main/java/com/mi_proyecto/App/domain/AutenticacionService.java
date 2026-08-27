package com.mi_proyecto.App.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mi_proyecto.App.domain.usuario.UserRepository;

@Service
public class AutenticacionService implements UserDetailsService{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException{
        return repository.findByLogin(username);
    }
}