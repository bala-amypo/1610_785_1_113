// package com.example.demo.security;

// import org.springframework.security.core.userdetails.*;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.AppUser;
// import com.example.demo.repository.AppUserRepository;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final AppUserRepository userRepo;

//     public CustomUserDetailsService(AppUserRepository userRepo) {
//         this.userRepo = userRepo;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String email)
//             throws UsernameNotFoundException {

//         AppUser user = userRepo.findByEmail(email)
//                 .orElseThrow(() ->
//                         new UsernameNotFoundException("User not found"));

//         return User.builder()
//                 .username(user.getEmail())
//                 .password(user.getPassword())
//                 .roles("USER")
//                 .build();
//     }
// } 



 package com.example.demo.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepository userRepo;

    public CustomUserDetailsService(AppUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        AppUser user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                    new UsernameNotFoundException("User not found"));

        return new User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toSet())
        );
    }
}
 