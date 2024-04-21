package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Customer;

import java.util.Random;

public class CustomerRepo extends RepositoryCRUD<Customer, Short> {
    @Getter
    private static final CustomerRepo instance = new CustomerRepo();
    public CustomerRepo() {
        super(Customer.class, SessionFactoryUtil.getSessionFactory().openSession());
    }

}
