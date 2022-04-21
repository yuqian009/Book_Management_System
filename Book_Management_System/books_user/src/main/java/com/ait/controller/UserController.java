package com.ait.controller;


import com.ait.entry.BookUser;
import com.ait.mapper.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@ResponseBody
@RequestMapping("/sc_user")

public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/getAll")
    public ResponseEntity queryStudent(){
        List<BookUser> list ;
        list = userRepository.findAll();
        return ResponseEntity.ok(list);
    }



    @GetMapping("/{id}")
    public ResponseEntity queryStudent(@PathVariable(value = "id")  Integer id){
        Optional<BookUser> User = userRepository.findById(id);
        return ResponseEntity.ok(User);
    }

    @PostMapping(value="/add")
    public ResponseEntity addStudent(@RequestBody BookUser User){
        User= userRepository.save(User);
        return ResponseEntity.ok(User);
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity delete(@RequestParam Integer id){
        userRepository.deleteById(id);
        return ResponseEntity.ok("Delete Success");
    }




}
