package org.example.business.abstracts;

import org.example.business.concretes.BaseCompanies;
import org.example.business.concretes.ICustomerDao;
import org.example.entities.Customer;

import java.util.List;

// Kahve firmalarımızın kullancılar ile islemlerini gerceklestirdigi sınıfımız.
// Musterileri database ekleme ve gösterme işlemleri burada gerceklesir.
public class NeroManager implements BaseCompanies {
    ICustomerDao customerDao;

    public NeroManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void add(Customer customer) {
        customerDao.add(customer);
        System.out.println("Saved to db : " + customer.getName());
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
