package org.example.business.concretes;

import org.example.entities.Customer;

import java.util.List;

public interface  BaseCompanies {
     void add(Customer customer) throws Exception;
     List<Customer> getAll();
}
