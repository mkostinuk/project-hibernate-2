package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Film;

public class FilmRepo extends RepositoryCRUD<Film, Short> {
    @Getter
    private static final FilmRepo instance = new FilmRepo();
    public FilmRepo(){
        super(Film.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
