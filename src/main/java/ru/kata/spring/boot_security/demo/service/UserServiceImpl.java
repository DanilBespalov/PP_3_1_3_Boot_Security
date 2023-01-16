package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.Roles;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.security.UserDetailsClass;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));

        }
        return new UserDetailsClass(user.get());
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
//        mapRolesAuthorities(user.getRoles()));
    }

    // из коллекции ролей делаем коллекцию авторизованных ролей с точно такими же строками
//    private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Roles> roles) {
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toList());
//    }
}
