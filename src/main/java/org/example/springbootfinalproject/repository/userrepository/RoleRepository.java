package org.example.springbootfinalproject.repository.userrepository;

import org.example.springbootfinalproject.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}