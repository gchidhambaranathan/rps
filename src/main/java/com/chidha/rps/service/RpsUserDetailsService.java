package com.chidha.rps.service;


import com.chidha.rps.data.AuthGroupRepository;
import com.chidha.rps.data.UserRespository;
import com.chidha.rps.entity.AuthGroup;
import com.chidha.rps.entity.User;
import com.chidha.rps.security.RpsUserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RpsUserDetailsService implements UserDetailsService {


    private final UserRespository userRespository;
    private final AuthGroupRepository authGroupRepository;

    public RpsUserDetailsService(UserRespository userRespository, AuthGroupRepository authGroupRepository){
        super();
        this.userRespository = userRespository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRespository.findByUsername(username);
        if(null == user){
            throw new UsernameNotFoundException("cannot find username :"+ username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
        return new RpsUserPrincipal(user,authGroups);
    }
}
