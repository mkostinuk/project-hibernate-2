package org.example.repositories;

import lombok.Getter;
import org.example.util.SessionFactoryUtil;
import org.example.entities.Category;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryRepo extends RepositoryCRUD<Category, Byte> {
    @Getter
    private static final CategoryRepo instance = new CategoryRepo();

    public CategoryRepo() {
        super(Category.class, SessionFactoryUtil.getSessionFactory().openSession());
    }

    public Set<Category> getFiveCustomers() {
        return session.createQuery("from Category", Category.class).setMaxResults(5).stream().collect(Collectors.toSet());
    }
}
