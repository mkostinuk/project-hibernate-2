package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Country;

public class CountryRepo extends RepositoryCRUD<Country, Short> {
    @Getter
    private static final CountryRepo instance = new CountryRepo();

    public CountryRepo() {
        super(Country.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
