// package com.example.demo.repository;

// import com.example.demo.entity.Role;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface RoleRepository extends JpaRepository<Role, Long> {
//     Optional<Role> findByName(String name);
// }






package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
