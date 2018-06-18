package com.mitrais.cdc.jpabasic.controller;

import com.mitrais.cdc.jpabasic.model.Address;
import com.mitrais.cdc.jpabasic.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("")
    public ResponseEntity<List<Address>> getAll() {
        List<Address> data = addressRepository.findAll();
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
