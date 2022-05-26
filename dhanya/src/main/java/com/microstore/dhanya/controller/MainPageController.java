package com.microstore.dhanya.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainPageController {

    @GetMapping("/")
    public ResponseEntity<String> mainPage()
    {
        return new ResponseEntity<String>("Welcome to DhansStore", HttpStatus.OK);
    }
}
