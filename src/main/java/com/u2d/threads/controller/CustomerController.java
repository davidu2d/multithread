package com.u2d.threads.controller;

import com.u2d.threads.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> asyncMethodWithConfiguredExecutor() {
        customerService.asyncMethodWithConfiguredExecutor();
        return new ResponseEntity<>("Deu bom", HttpStatus.OK);
    }

}
