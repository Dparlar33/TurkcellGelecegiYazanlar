package org.example.business.abstracts;

import org.example.business.concretes.BaseCompanies;
import org.example.business.concretes.ICustomerDao;
import org.example.entities.Customer;
import org.example.utilities.ICustomerChecker;
import org.example.utilities.MernisController;

import java.util.List;

// Kahve firmalarımızın kullancılar ile islemlerini gerceklestirdigi sınıfımız.
// Musterileri database ekleme ve gösterme işlemleri burada gerceklesir.

public class StarbucksManager implements BaseCompanies {
    ICustomerDao customerDao;
    ICustomerChecker customerChecker;
    public StarbucksManager(ICustomerDao customerDao,ICustomerChecker customerChecker) {
        this.customerDao = customerDao;
        this.customerChecker = customerChecker;
    }

    @Override
    public void add(Customer customer) throws Exception {
        //Mernis kontrol sisteminin kullanıldıgı kısım.
        if (customerChecker.isValid(customer)){
            customerDao.add(customer);
            System.out.println("Added to db : " + customer.getName());
        }else {
            throw new Exception("Invalid person!");
        }
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

}
