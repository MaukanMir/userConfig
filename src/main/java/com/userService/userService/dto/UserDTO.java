package com.userService.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    String id;
    String username;
    String email;
    LocalDate dob;
    LocalDateTime createdAt;
}
