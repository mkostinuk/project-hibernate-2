package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.City;

public class CityRepo extends RepositoryCRUD<City, Short> {
    @Getter
    private static final CityRepo instance = new CityRepo();

    public CityRepo() {
        super(City.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
