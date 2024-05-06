package org.example.repositories;

import lombok.Getter;
import org.example.enums.LanguageName;
import org.example.util.SessionFactoryUtil;
import org.example.entities.Language;
import org.hibernate.query.Query;

public class LanguageRepo extends RepositoryCRUD<Language, Byte> {
    @Getter
    private static final LanguageRepo instance = new LanguageRepo();

    public LanguageRepo() {
        super(Language.class, SessionFactoryUtil.getSessionFactory().openSession());
    }

    public Language findByName(LanguageName languageName) {
        Query<Language> nameL = session.createQuery("from Language where name = :nameL ", Language.class).setParameter("nameL", languageName.getValue());
        return nameL.uniqueResult();
    }
}
