package com.moneylender.backend.service;

import com.moneylender.backend.model.Person;
import com.moneylender.backend.model.Payment;
import com.moneylender.backend.repository.PersonRepository;
import com.moneylender.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonService {

    @Autowired private PersonRepository personRepo;
    @Autowired private PaymentRepository paymentRepo;

    public Person addPerson(String name, double totalAmount) {
        Person p = new Person();
        p.setName(name);
        p.setTotalAmount(totalAmount);
        p = personRepo.save(p);

        double daily = totalAmount -(totalAmount/10) / 90.0;
        for (int i = 0; i < 90; i++) {
            Payment pay = new Payment();
            pay.setDate(LocalDate.now().plusDays(i));
            pay.setExpectedAmount(daily);
            pay.setPaidAmount(0.0);
            pay.setPerson(p);
            paymentRepo.save(pay);
        }
        return p;
    }

    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public List<Payment> getPayments(Long personId) {
        return paymentRepo.findByPersonIdOrderByDate(personId);
    }

    public Payment recordPayment(Long paymentId, double paidAmount) {
        Payment pay = paymentRepo.findById(paymentId).orElseThrow();
        pay.setPaidAmount(paidAmount);
        return paymentRepo.save(pay);
    }
}
