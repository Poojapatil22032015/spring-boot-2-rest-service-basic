package com.pooja_sample_project.springboot2restservicebasic.controller;
import com.pooja_sample_project.springboot2restservicebasic.exception.Lib_userNotfoundException;
import com.pooja_sample_project.springboot2restservicebasic.model.Lib_User;
import com.pooja_sample_project.springboot2restservicebasic.model.User;
import com.pooja_sample_project.springboot2restservicebasic.repository.Lib_userRepository;
import com.pooja_sample_project.springboot2restservicebasic.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class Lib_UserController {
    @Autowired
    Lib_userRepository lib_userRepository;
    // Create a new Subject
    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping("/Lib_User")
    public Lib_User createSubject(@Valid @RequestBody Lib_User lib_user)
    {
        return lib_userRepository.save(lib_user);
    }

    // Get all subjects for particular user
    @CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/Lib_User/{id}")
    public List<Lib_User> getByPhone_number(@PathVariable(value = "id") String phone_number) throws Lib_userNotfoundException {
        List<Lib_User> ls=  lib_userRepository.findAll();
        List<Lib_User> res = new ArrayList<>();

        for(int i = 0; i<ls.size(); i++){
            if(ls.get(i).getPhone_number().contentEquals(phone_number)){
                res.add(ls.get(i));
            }
        }
        return res;
    }

    // Delete a User
    @CrossOrigin(origins = "http://localhost:8088")
    @DeleteMapping("/Lib_User/{id}/{subject}")
    public ResponseEntity<?> deleteSubject(@PathVariable(value = "id") String phone_number,
                                           @PathVariable(value = "subject") String subject) throws Lib_userNotfoundException{

        List<Lib_User> ls= lib_userRepository.findAll();
        Lib_User lib_user = null;
        for(int i=0; i<ls.size(); i++) {
            if(ls.get(i).getPhone_number().contentEquals(phone_number) && ls.get(i).getSubject().contentEquals(subject)){
                lib_user = ls.get(i);
            }
        }
        if(lib_user != null){
            lib_userRepository.delete(lib_user);
        }
        return ResponseEntity.ok().build();
    }

}
