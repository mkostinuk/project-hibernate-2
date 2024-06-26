package org.example.repositories;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class RepositoryCRUD<T, K> {
    private final Class<T> clazz;
    protected final Session session;

    protected RepositoryCRUD(Class<T> clazz, Session session) {
        this.clazz = clazz;
        this.session = session;
    }

    public Optional<T> findById(K id) {
        return Optional.ofNullable(session.find(clazz, id));

    }

    public T save(T value) {
        session.getTransaction().begin();
        session.persist(value);
        session.getTransaction().commit();
        return value;
    }

    public Stream<T> findAll() {
        return session.createQuery("from " + clazz.getSimpleName(), clazz).getResultStream();
    }

    public void update(T value) {
        session.getTransaction().begin();
        session.merge(value);
        session.getTransaction().commit();
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

    public T getFirst() {
        Query<T> tQuery = session.createQuery("from " + clazz.getSimpleName(), clazz).setMaxResults(1);
        return tQuery.uniqueResult();
    }
}
