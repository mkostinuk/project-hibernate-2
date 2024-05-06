package org.example;


import org.example.entities.*;
import org.example.enums.LanguageName;
import org.example.enums.Rating;
import org.example.enums.SpecialFeatures;
import org.example.repositories.*;


import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class Main {
    private static final StoreRepo STORE_REPO = StoreRepo.getInstance();
    private static final AddressRepo ADDRESS_REPO = AddressRepo.getInstance();
    private static final CustomerRepo CUSTOMER_REPO = CustomerRepo.getInstance();
    private static final RentalRepo RENTAL_REPO = RentalRepo.getInstance();
    private static final InventoryRepo INVENTORY_REPO = InventoryRepo.getInstance();
    private static final PaymentRepo PAYMENT_REPO = PaymentRepo.getInstance();
    private static final LanguageRepo LANGUAGE_REPO = LanguageRepo.getInstance();
    private static final ActorRepo ACTOR_REPO = ActorRepo.getInstance();
    private static final CategoryRepo CATEGORY_REPO = CategoryRepo.getInstance();
    private static final FilmRepo FILM_REPO = FilmRepo.getInstance();
    private static final FilmTextRepo FILM_TEXT_REPO = FilmTextRepo.getInstance();

    public static void main(String[] args) {
        System.out.println(createDefaultNewCustomer());
        returnBeforeFilm();
        bookInventory(createDefaultNewCustomer());
        System.out.println(createFilm());

    }

    static Customer createDefaultNewCustomer() {
        Customer customer = new Customer();
        customer.setStore(STORE_REPO.getFirst());
        customer.setFirstName("customer_name");
        customer.setLastName("customer_second_name");
        customer.setEmail("test@javarush.com");
        customer.setAddress(ADDRESS_REPO.getFirst());
        customer.setActive(new Random().nextBoolean());
        return CUSTOMER_REPO.save(customer);

    }

    static void returnBeforeFilm() {
        Rental rental = RENTAL_REPO.getUnreturnedFilm().orElseThrow(() -> new NoSuchElementException("all films have already been returned"));
        rental.setReturnDate(LocalDateTime.now());
        RENTAL_REPO.update(rental);
    }

    static void bookInventory(Customer customer) {
        Inventory inventory = new Inventory();
        Store store = STORE_REPO.getFirst();
        inventory.setStore(store);
        inventory.setFilm(FILM_REPO.getAvailableFilm());
        INVENTORY_REPO.save(inventory);
        Staff staff = store.getStaff();
        Rental rental = new Rental();
        rental.setRentalDate(LocalDateTime.now());
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setStaff(staff);
        RENTAL_REPO.save(rental);
        makePayment(customer, staff, rental);
    }

    static void makePayment(Customer customer, Staff staff, Rental rental) {
        Payment payment = new Payment();
        payment.setRental(rental);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStaff(staff);
        payment.setAmount(BigDecimal.valueOf(44.44));
        payment.setCustomer(customer);
        PAYMENT_REPO.save(payment);
    }

    static Film createFilm() {
        Film film = new Film();
        film.setTitle("JAVA 2077");
        film.setDescription("film for java junior devs");
        film.setReleaseYear(Year.now());
        film.setLanguage(LANGUAGE_REPO.findByName(LanguageName.ENGLISH));
        film.setRentalDuration((byte) 2);
        film.setRentalRate(BigDecimal.valueOf(4.44));
        film.setLength((short) 120);
        film.setReplacementCost(BigDecimal.valueOf(21.2));
        film.setRating(Rating.PG13);
        film.setSpecialFeatures(new HashSet<>(Set.of(SpecialFeatures.TRAILERS, SpecialFeatures.DELETED_SCENES)));
        film.setActors(ACTOR_REPO.getFiveActors());
        film.setCategories(CATEGORY_REPO.getFiveCustomers());
        FILM_REPO.save(film);
        FilmText filmText = new FilmText();
        filmText.setId(film.getFilmId());
        filmText.setTitle(film.getTitle());
        filmText.setDescription(film.getDescription());
        FILM_TEXT_REPO.save(filmText);
        return film;
    }


}