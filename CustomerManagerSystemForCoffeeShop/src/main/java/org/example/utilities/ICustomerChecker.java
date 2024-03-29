package org.example.utilities;

import org.example.entities.Customer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ICustomerChecker {
    boolean isValid(Customer customer) throws IOException, ParserConfigurationException, SAXException;
}
