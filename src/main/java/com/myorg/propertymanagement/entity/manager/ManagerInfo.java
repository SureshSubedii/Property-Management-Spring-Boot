package com.myorg.propertymanagement.entity.manager;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ManagerInfo implements UserDetails {

    private String username;
    private String password;
    @Getter
    private Long id;
    private List<GrantedAuthority> authorities;


    public ManagerInfo(Manager manager) {
        this.username = manager.getEmail();
        this.password = manager.getPassword();
        this.id = manager.getId();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
}