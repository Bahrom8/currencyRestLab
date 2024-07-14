package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonIgnore
    private Long id;

    @NotBlank(message = "First Name is a required field")
    @Size(max = 15, min = 2, message = "First Name must be between 2 and 15 characters long")
    private String firstName;

    @NotBlank(message = "Last Name is a required field")
    @Size(max = 15, min = 2, message = "Last Name must be between 2 and 15 characters long")
    private String lastName;

    @NotBlank(message = "Phone Number is a required field")
    @Pattern(regexp = "^\\d{10}$", message = "Phone Number should be 10 characters long, and can only include digits")
    private String phoneNumber;

    @NotBlank(message = "Email is a required field")
    @Email(message = "Email must be in a valid email format")
    private String email;

    @NotBlank(message = "Username is a required field")
    @Size(max = 15, min = 2, message = "Username must be between 2 and 15 characters long")
    private String username;

    @NotBlank(message = "Password is a required field")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}", message = "The password must be at least 4 characters long and include at least 1 uppercase letter, 1 lowercase letter and 1 digit")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<AccountDTO> accounts;
}