package com.example.BlueringBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        ApiResponse<UserDTO> response = new ApiResponse<>();
        if (createdUser != null) {
            response.setSuccess(true);
            response.setMessage("User created successfully");
            response.setReturnField(createdUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            response.setSuccess(false);
            response.setMessage("Failed to create user");
            response.setReturnField(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        ApiResponse<UserDTO> response = new ApiResponse<>();
        if (updatedUser != null) {
            response.setSuccess(true);
            response.setMessage("User updated successfully");
            response.setReturnField(updatedUser);
            return ResponseEntity.ok(response);
        } else {
            response.setSuccess(false);
            response.setMessage("User not found");
            response.setReturnField(null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> partialUpdateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        // Implement partial update logic using userService
        // Example: UserDTO updatedUser = userService.partialUpdateUser(id, userDTO);
        ApiResponse<UserDTO> response = new ApiResponse<>();
        // Handle response based on update result
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        ApiResponse<Void> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("User deleted successfully");
        response.setReturnField(null);
        return ResponseEntity.noContent().build();
    }



    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        ApiResponse<List<UserDTO>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Users retrieved successfully");
        response.setReturnField(users);
        return ResponseEntity.ok(response);
    }
}
