package com.pooja_sample_project.springboot2restservicebasic.controller;
import com.pooja_sample_project.springboot2restservicebasic.model.User;
import com.pooja_sample_project.springboot2restservicebasic.repository.UserRepository;
import com.pooja_sample_project.springboot2restservicebasic.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    // Get All Users
    @GetMapping("/User")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // Create a new User
    @PostMapping("/User")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
    // Get a Single Note
    @GetMapping("/user/{phone_number}")
    public User getByPhone_number(@PathVariable(value = "phone_number") String phone_number) throws UserNotFoundException {
        return userRepository.findById(phone_number)
                .orElseThrow(() -> new UserNotFoundException(phone_number));
    }
    // Update User
    @PutMapping("/User/{id}")
    public User updateUser(@PathVariable(value = "phone_number") String phone_number,
                           @Valid @RequestBody User userDetails) throws UserNotFoundException {

        User user = userRepository.findById(phone_number)
                .orElseThrow(() -> new UserNotFoundException(phone_number));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhone_number(userDetails.getPhone_number());
        user.setPassword(userDetails.getPassword());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    // Delete a User
    @DeleteMapping("/User/{phone_number}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "phone_number") String phone_number) throws UserNotFoundException {
        User user = userRepository.findById(phone_number)
                .orElseThrow(() -> new UserNotFoundException(phone_number));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}