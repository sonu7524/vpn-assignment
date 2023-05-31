package com.driver.controllers;

import com.driver.model.Admin;
import com.driver.model.ServiceProvider;
import com.driver.services.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServiceImpl adminService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerAdmin(@RequestParam String username, @RequestParam String password){
        //create an admin and return
        Admin admin = adminService.register(username, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addProvider")
    public ResponseEntity<Void> addServiceProvider(@RequestParam int adminId, @RequestParam String providerName){
        //add a serviceProvider under the admin and return updated admin
        Admin admin = adminService.addServiceProvider(adminId, providerName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addCountry")
    public ResponseEntity<Void> addCountry(@RequestParam int serviceProviderId, @RequestParam String countryName) throws Exception{

        ServiceProvider serviceProvider = adminService.addCountry(serviceProviderId, countryName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
