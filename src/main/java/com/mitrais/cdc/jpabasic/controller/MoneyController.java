package com.mitrais.cdc.jpabasic.controller;

import com.mitrais.cdc.jpabasic.model.Money;
import com.mitrais.cdc.jpabasic.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("money")
public class MoneyController {
    @Autowired
    private MoneyRepository moneyRepository;

    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Money>> retrieveData() {
        Iterable<Money> data = moneyRepository.findAll();
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PostMapping(path = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveData(@RequestBody Money data){
        moneyRepository.save(data);
        return new ResponseEntity(HttpStatus.OK);
    }
}
