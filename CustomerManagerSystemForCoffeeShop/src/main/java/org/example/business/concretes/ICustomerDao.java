package org.example.business.concretes;

import org.example.entities.Customer;

import java.util.List;

public interface ICustomerDao {
    void add(Customer customer);
    List<Customer> getAll();
}
