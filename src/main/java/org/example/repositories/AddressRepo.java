package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Address;

public class AddressRepo extends RepositoryCRUD<Address, Short> {
    @Getter
    private static final AddressRepo instance = new AddressRepo();

    public AddressRepo() {
        super(Address.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
