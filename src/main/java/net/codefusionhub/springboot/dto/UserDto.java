package net.codefusionhub.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "Please enter valid firstname.")
    private String firstName;

    @NotEmpty(message = "Please enter valid lastname.")
    private String lastName;

    @NotEmpty(message = "Email field should not be empty.")
    @Email(message = "Please enter valid email.")
    private String email;
}
