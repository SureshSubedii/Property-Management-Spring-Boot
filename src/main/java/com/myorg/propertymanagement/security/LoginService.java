package com.myorg.propertymanagement.security;

import com.myorg.propertymanagement.entity.manager.Manager;
import com.myorg.propertymanagement.entity.manager.ManagerInfo;
import com.myorg.propertymanagement.entity.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginService implements UserDetailsService {
    @Autowired
    ManagerService managerService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Manager> userDetail = managerService.findByEmail(email);

        return userDetail.map(ManagerInfo::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }
}
