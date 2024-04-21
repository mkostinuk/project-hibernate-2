package org.example;


import org.example.entities.Rental;
import org.example.repositories.*;
import org.example.entities.Customer;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {
    private static final StoreRepo STORE_REPO = StoreRepo.getInstance();
    private static final AddressRepo ADDRESS_REPO = AddressRepo.getInstance();
    private static final CustomerRepo CUSTOMER_REPO = CustomerRepo.getInstance();
    private static final RentalRepo RENTAL_REPO = RentalRepo.getInstance();
    private static final InventoryRepo INVENTORY_REPO = InventoryRepo.getInstance();
    private static final StaffRepo STAFF_REPO = StaffRepo.getInstance();

    public static void main(String[] args) {
        System.out.println(createDefaultNewCustomer());
        returnBeforeFilm();
    }
    static void returnBeforeFilm(){
        Rental rental = RENTAL_REPO.getUnreturnedFilm().orElseThrow(() -> new  NoSuchElementException("all movies have already been returned"));
        rental.setReturnDate(LocalDateTime.now());
        RENTAL_REPO.update(rental);
    }



    static Customer createDefaultNewCustomer() {
        Customer customer = new Customer();
        customer.setStore(STORE_REPO.findById((byte) 1).get());
        customer.setFirstName("customer_name");
        customer.setLastName("customer_second_name");
        customer.setEmail("test@javarush.com");
        customer.setAddress(ADDRESS_REPO.findById((short) 1).get());
        customer.setActive(new Random().nextBoolean());
        CUSTOMER_REPO.save(customer);
        return customer;
    }
}