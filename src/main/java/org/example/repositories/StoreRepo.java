package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Store;

public class StoreRepo extends RepositoryCRUD<Store, Byte> {
    @Getter
    private static final StoreRepo instance = new StoreRepo();
    public StoreRepo(){
        super(Store.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
