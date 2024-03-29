package org.example;

import org.example.business.concretes.BaseCompanies;
import org.example.business.abstracts.StarbucksManager;
import org.example.entities.Customer;
import org.example.business.abstracts.CustomerManager;
import org.example.utilities.MernisController;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        // BaseCompanies ile Polymorphism yöntemiyle ister Starbucks ister Nero istersek Kahve dunyası gibi
        // kahve firmasına bağlı kalmadan işlemlerimizi gerçekleştirebiliriz.


        // Starbucks firmamız kullanıcı işlemleri gerçekleştireceği ve mernis kontrolü kullanacağı için
        // CustomerManager işlemlerinin yapıldığı CustomerManager ve
        // Mernis kontrolüne bağlı tutulduğu için MernisController yapıları constructorda eklenmiştir.

        BaseCompanies baseCompanies = new StarbucksManager(new CustomerManager(),new MernisController());
        Customer customer = new Customer();
        customer.setId(1);
        customer.setIdentityNumber("72307104576");
        customer.setName("Deniz");
        customer.setSurname("Parlar");
        customer.setDateOfBirth(LocalDate.of(1999,2,22));
        baseCompanies.add(customer);

        // İlerleyen zamanlarda baska bir kahve firması ile çalısmak istersek Örnek olarak ;
        // new StarbucksManager() yerine new NeroManager() eklersek kodlarımızı degistirmeden işlemlerimizi gerçekleştirebiliriz.

        // Eklemek istediğimiz kahve firmasını new XManager() seklinde ekledikten sonra Musteri kimlik dogrulama isterse firma
        // Suanda kayıtlı olan Mernisi veya ileride gelistirilecek baska bir dogrulama yöntemini yine herhangi bir
        // kod degisimi olmadan ekleyebilir.

        List<Customer> customers = baseCompanies.getAll();
        for (Customer customer2:customers){
            System.out.println(customer2.getIdentityNumber() +" " + customer2.getName());
        }

    }
}