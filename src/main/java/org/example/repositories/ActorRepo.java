package org.example.repositories;

import lombok.Getter;
import org.example.util.SessionFactoryUtil;
import org.example.entities.Actor;

import java.util.Set;
import java.util.stream.Collectors;

public class ActorRepo extends RepositoryCRUD<Actor, Short> {
    @Getter
    private static final ActorRepo instance = new ActorRepo();

    public ActorRepo() {
        super(Actor.class, SessionFactoryUtil.getSessionFactory().openSession());
    }

    public Set<Actor> getFiveActors() {
        return session.createQuery("from Actor", Actor.class).setMaxResults(5).stream().collect(Collectors.toSet());
    }
}
