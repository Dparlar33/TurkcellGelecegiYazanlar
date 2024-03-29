package com.turkcell.rentacar.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindexController {
    @GetMapping("/findex/{customerId}")
    public int getFindexScore(@PathVariable int customerId){
        return ((customerId * 365)/10);
    }
}
