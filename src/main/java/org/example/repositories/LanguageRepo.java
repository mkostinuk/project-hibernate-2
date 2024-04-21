package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Language;

public class LanguageRepo extends RepositoryCRUD<Language, Byte> {
    @Getter
    private static final LanguageRepo instance = new LanguageRepo();
    public LanguageRepo(){
        super(Language.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
