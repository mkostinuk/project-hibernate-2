package org.example.repositories;

import lombok.Getter;
import org.example.util.SessionFactoryUtil;
import org.example.entities.FilmText;

public class FilmTextRepo extends RepositoryCRUD<FilmText, Short> {
    @Getter
    private static final FilmTextRepo instance = new FilmTextRepo();

    public FilmTextRepo() {
        super(FilmText.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
