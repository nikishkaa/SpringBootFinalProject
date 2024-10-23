package org.example.springbootfinalproject.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    public UserDto(String email, String username, String phoneNumber) {
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
}
