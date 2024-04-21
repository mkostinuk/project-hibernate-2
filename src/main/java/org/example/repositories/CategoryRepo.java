package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Category;

public class CategoryRepo extends RepositoryCRUD<Category, Byte> {
    @Getter
    private static final CategoryRepo instance = new CategoryRepo();

    public CategoryRepo() {
        super(Category.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
