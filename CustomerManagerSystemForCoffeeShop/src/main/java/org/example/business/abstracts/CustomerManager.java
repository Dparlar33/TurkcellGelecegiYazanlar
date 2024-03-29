package org.example.business.abstracts;

import org.example.business.concretes.ICustomerDao;
import org.example.entities.Customer;

import java.util.ArrayList;
import java.util.List;

// Customer islemlerinin yapıldıgı yer.
// Bu class sayesinde customer ekleme (In memory) ve ekli olan customerları görünteleyebiliriz.
public class CustomerManager implements ICustomerDao {

    // In memory
    List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}
