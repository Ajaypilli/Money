package com.moneylender.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double expectedAmount;
    private double paidAmount;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public double getExpectedAmount() { return expectedAmount; }
    public void setExpectedAmount(double expectedAmount) { this.expectedAmount = expectedAmount; }

    public double getPaidAmount() { return paidAmount; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
