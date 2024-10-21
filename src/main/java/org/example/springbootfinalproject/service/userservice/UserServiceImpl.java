package org.example.springbootfinalproject.service.userservice;


import org.example.springbootfinalproject.dto.userdto.UserDto;
import org.example.springbootfinalproject.entity.user.Role;
import org.example.springbootfinalproject.entity.user.User;
import org.example.springbootfinalproject.repository.userrepository.RoleRepository;
import org.example.springbootfinalproject.repository.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getEmail(), userDto.getPhoneNumber());
        Role role = roleRepository.findByName("DEFAULT_USER");
        if (role == null) {
            role = setDefaultRole();
        }

        user.setRole(role);
        return userRepository.save(user);
    }

    private Role setDefaultRole() {
        Role role = new Role();
        role.setName("DEFAULT_USER");
        return roleRepository.save(role);
    }


}