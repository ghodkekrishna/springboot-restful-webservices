package net.codefusionhub.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.codefusionhub.springboot.dto.UserDto;
import net.codefusionhub.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create, Update, Get, Delete user"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;


    @Operation(
            summary = "Create User REST API",
            description = "Create user REST API is used to save user in database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get user by ID REST API",
            description = "Get user REST API."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Users REST API",
            description = "Get all users REST API."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Update users REST API",
            description = "Update user REST API."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody @Valid UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete user REST API",
            description = "Delete user REST API."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 Success"
    )
    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
