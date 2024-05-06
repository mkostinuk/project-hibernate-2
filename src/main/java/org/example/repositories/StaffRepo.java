package org.example.repositories;

import lombok.Getter;
import org.example.util.SessionFactoryUtil;
import org.example.entities.Staff;

public class StaffRepo extends RepositoryCRUD<Staff, Byte> {
    @Getter
    private static final StaffRepo instance = new StaffRepo();

    public StaffRepo() {
        super(Staff.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
