package ru.kata.spring.boot_security.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.Collection;

public class UserDetailsClass implements UserDetails {
    private final User user;

    public UserDetailsClass(User user) {
        this.user = user;
    }

    // возвращает коллекцию ролей у конкретного юзера
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return user.getRoles();
    }

    @Override
    public String getPassword() {

        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // для получения данных аутентифицированного пользователя
    public User getUser() {
        return user;
    }
}
