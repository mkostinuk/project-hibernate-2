package org.example.util;

import org.example.entities.*;
import org.example.enums.LanguageName;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().
                    setProperties(configure()).
                    addAnnotatedClass(Actor.class).
                    addAnnotatedClass(Address.class).
                    addAnnotatedClass(Category.class).
                    addAnnotatedClass(City.class).
                    addAnnotatedClass(Country.class).
                    addAnnotatedClass(Customer.class).
                    addAnnotatedClass(Film.class).
                    addAnnotatedClass(FilmText.class).
                    addAnnotatedClass(Inventory.class).
                    addAnnotatedClass(LanguageName.class).
                    addAnnotatedClass(Payment.class).
                    addAnnotatedClass(Rental.class).
                    addAnnotatedClass(Staff.class).
                    addAnnotatedClass(Store.class).
                    addAnnotatedClass(Language.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    private static Properties configure() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/movie");
        properties.put(Environment.USER, System.getenv("user"));
        properties.put(Environment.PASS, System.getenv("pass"));
        properties.put(Environment.HBM2DDL_AUTO, "validate");
        return properties;
    }
}
