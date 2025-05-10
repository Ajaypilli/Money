package com.moneylender.backend.controller;

import com.moneylender.backend.model.Person;
import com.moneylender.backend.model.Payment;
import com.moneylender.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin // allow all origins (for React dev)
public class PersonController {

    @Autowired private PersonService service;

    @PostMapping("/persons")
    public Person addPerson(@RequestParam String name,
                            @RequestParam double totalAmount) {
        return service.addPerson(name, totalAmount);
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
