package com.moneylender.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneylender.backend.model.Payment;
import com.moneylender.backend.model.Person;
import com.moneylender.backend.service.PersonService;

@RestController
@RequestMapping("/api")
@CrossOrigin // allow all origins (for React dev)
public class PersonController {

    @Autowired private PersonService service;

    @PostMapping("/persons")
public Person addPerson(@RequestBody Person person) {
    return service.addPerson(person.getName(), person.getTotalAmount());
}


    @GetMapping("/persons")
    public List<Person> listPersons() {
        return service.getAllPersons();
    }

    @GetMapping("/persons/{id}/payments")
    public List<Payment> listPayments(@PathVariable Long id) {
        return service.getPayments(id);
    }

    @PutMapping("/payments/{paymentId}")
    public Payment makePayment(@PathVariable Long paymentId,
                               @RequestParam double paidAmount) {
        return service.recordPayment(paymentId, paidAmount);
    }
}
