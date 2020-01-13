package com.pooja_sample_project.springboot2restservicebasic.controller;
import com.pooja_sample_project.springboot2restservicebasic.model.User;
import com.pooja_sample_project.springboot2restservicebasic.model.login;
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
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/User")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping("/login")
    public String ValidateUser(@Valid @RequestBody login log){
        String result = null;
        try {
            User user = getByPhone_number(log.getUsername());
            if(user.getPassword().contentEquals(log.getPassword())){
                result = "Login Successfull";
            }else{
                result = "Username or password is incorrect";
            }
        }catch (UserNotFoundException e){
            result = "User Not Found";
        }
        return result;
    }

    // Create a new User
    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping("/User")
    public User createUser(@Valid @RequestBody User user)
    {
        return userRepository.save(user);
    }
    // Get a Single User
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/User/{id}")
    public User getByPhone_number(@PathVariable(value = "id") String phone_number) throws UserNotFoundException {
        return userRepository.findById(phone_number)
                .orElseThrow(() -> new UserNotFoundException(phone_number));
    }
    // Update User
    @CrossOrigin(origins = "http://localhost:8088")
    @PutMapping("/User/{id}")
    public User updateUser(@PathVariable(value = "id") String phone_number,
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
    @CrossOrigin(origins = "http://localhost:8088")
    @DeleteMapping("/User/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") String phone_number) throws UserNotFoundException {
        User user = userRepository.findById(phone_number)
                .orElseThrow(() -> new UserNotFoundException(phone_number));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
