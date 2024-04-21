package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Inventory;

public class InventoryRepo extends RepositoryCRUD<Inventory, Integer> {
    @Getter
    private static final InventoryRepo instance = new InventoryRepo();
    public InventoryRepo() {
        super(Inventory.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
