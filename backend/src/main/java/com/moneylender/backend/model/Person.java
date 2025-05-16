package com.moneylender.backend.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double totalAmount;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();

    // getters & setters
    public Long getId() 
    { 
        return id;
     }
    public void setId(Long id) 
    { 
        this.id = id;
    }

    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }

    public double getTotalAmount() 
    { 
        return totalAmount; 
    }
    public void setTotalAmount(double totalAmount) 
    { 
        this.totalAmount = totalAmount; 
    }

    public List<Payment> getPayments() 
    { 
        return payments; 
    }
    public void setPayments(List<Payment> payments) 
    { 
        this.payments = payments; 
    }
}
