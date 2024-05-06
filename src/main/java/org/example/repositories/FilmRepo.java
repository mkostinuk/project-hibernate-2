package org.example.repositories;

import lombok.Getter;
import org.example.util.SessionFactoryUtil;
import org.example.entities.Film;
import org.hibernate.query.Query;

public class FilmRepo extends RepositoryCRUD<Film, Short> {
    @Getter
    private static final FilmRepo instance = new FilmRepo();

    public FilmRepo() {
        super(Film.class, SessionFactoryUtil.getSessionFactory().openSession());
    }

    public Film getAvailableFilm() {
        Query<Film> query = session.createQuery("from Film f where f.id not in(select distinct i.film.filmId from Inventory i)", Film.class);
        return query.list().getFirst();

    }
}
