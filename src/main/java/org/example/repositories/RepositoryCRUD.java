package org.example.repositories;

import org.hibernate.Session;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class RepositoryCRUD<T, K> {
    private final Class<T> clazz;
    private final Session session;

    protected RepositoryCRUD(Class<T> clazz, Session session) {
        this.clazz = clazz;
        this.session = session;
    }

    public Optional<T> findById(K id) {
        return Optional.ofNullable(session.find(clazz, id));

    }

    public void save(T value) {
        session.getTransaction().begin();
        session.persist(value);
        session.getTransaction().commit();
    }

    public Stream<T> findAll() {
        return session.createQuery("from " + clazz.getSimpleName(), clazz).getResultStream();
    }

    public T update(T value) {
        session.getTransaction().begin();
        session.merge(value);
        session.getTransaction().commit();
        return value;
    }

    public void delete(T value) {
        session.getTransaction().begin();
        session.delete(value);
        session.getTransaction().commit();
    }

    public void deleteById(K id) {
        session.getTransaction().begin();
        T value = findById(id).orElseThrow(NoSuchElementException::new);
        session.delete(value);
        session.getTransaction().commit();
    }
}
