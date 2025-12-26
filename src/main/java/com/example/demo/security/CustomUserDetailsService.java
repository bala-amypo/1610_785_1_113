// package com.example.demo.security;

// import com.example.demo.entity.AppUser;
// import com.example.demo.repository.AppUserRepository;

// import org.springframework.security.core.userdetails.*;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;

// import java.util.stream.Collectors;

// public class CustomUserDetailsService implements UserDetailsService {

//     private final AppUserRepository repo;

//     public CustomUserDetailsService(AppUserRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String email) {

//         AppUser user = repo.findByEmail(email)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found"));

//         return new User(
//                 user.getEmail(),
//                 user.getPassword(),
//                 user.getRoles()
//                         .stream()
//                         .map(r -> new SimpleGrantedAuthority(r.getName()))
//                         .collect(Collectors.toSet())
//         );
//     }
// }





package com.example.demo.security;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private final AppUserRepository appUserRepository;
    
    public CustomUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        
        return User.builder()
            .username(user.getEmail())
            .password(user.getPassword())
            .authorities(user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList()))
            .build();
    }
}



