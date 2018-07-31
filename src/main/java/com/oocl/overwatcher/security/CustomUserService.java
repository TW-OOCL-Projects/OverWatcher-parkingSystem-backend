package com.oocl.overwatcher.security;

import com.oocl.overwatcher.security.domain.SysUser;
import com.oocl.overwatcher.security.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author LIULE9
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }

}
