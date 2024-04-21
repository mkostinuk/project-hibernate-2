package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Rental;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class RentalRepo extends RepositoryCRUD<Rental, Integer> {
    @Getter
    private static final RentalRepo instance = new RentalRepo();

    public RentalRepo() {
        super(Rental.class, SessionFactoryUtil.getSessionFactory().openSession());
    }

    public Optional<Rental> getUnreturnedFilm() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Query<Rental> query = session.createQuery("from Rental where returnDate is null", Rental.class);
            return Optional.ofNullable(query.list().getFirst());
        }
    }
}
