package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Payment;

public class PaymentRepo extends RepositoryCRUD<Payment, Short> {
    @Getter
    private static final PaymentRepo instance = new PaymentRepo();

    public PaymentRepo() {
        super(Payment.class, SessionFactoryUtil.getSessionFactory().openSession());
    }
}
