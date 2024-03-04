package net.codefusionhub.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @Schema(
            description = "user first name"
    )
    @NotEmpty(message = "Please enter valid firstname.")
    private String firstName;

    @Schema(
            description = "user last name"
    )
    @NotEmpty(message = "Please enter valid lastname.")
    private String lastName;

    @Schema(
            description = "user email"
    )
    @NotEmpty(message = "Email field should not be empty.")
    @Email(message = "Please enter valid email.")
    private String email;
}
