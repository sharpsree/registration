package com.vms.registration.service;

import com.vms.registration.configuration.CustomUserDetails;
import com.vms.registration.entity.User;
import com.vms.registration.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;


    @Override
    public UserDetails loadUserByUsername(String Vehicleid) throws UsernameNotFoundException {
        Optional<User> optioanlUser = userDetailsRepository.findById(Integer.parseInt(Vehicleid));
        if(!optioanlUser.isPresent()){
            log.error("specified user not found");
        }
        optioanlUser.orElseThrow(()->new UsernameNotFoundException("user not found"));
        return optioanlUser.map(CustomUserDetails::new).get();
    }
}
