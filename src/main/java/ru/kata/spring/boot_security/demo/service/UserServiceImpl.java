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

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findUserByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));

        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
        mapRolesAuthorities(user.getRoles()));
    }

    // из коллекции ролей делаем коллекцию авторизованных ролей с точно такими же строками
    private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Roles> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toList());
    }

    //    private final UserDAO userDAO;
//
//    @Autowired
//    public UserServiceImpl(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<User> getAllUsers() {
//        return userDAO.getAllUsers();
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public User showUserByID(int id) {
//        return userDAO.showUserByID(id);
//    }
//
//    @Override
//    @Transactional
//    public void add(User user) {
//        userDAO.add(user);
//    }
//
//    @Override
//    @Transactional
//    public User update(User user, int id) {
//
//        return userDAO.update(user, id);
//
//    }
//
//    @Override
//    @Transactional
//    public void delete(int id) {
//
//        userDAO.delete(id);
//    }

}
