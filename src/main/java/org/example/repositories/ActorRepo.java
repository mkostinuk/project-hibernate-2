package org.example.repositories;

import lombok.Getter;
import org.example.SessionFactoryUtil;
import org.example.entities.Actor;

public class ActorRepo extends RepositoryCRUD<Actor, Short> {
    @Getter
    private static final ActorRepo INSTANCE = new ActorRepo();

    public ActorRepo() {
        super(Actor.class, SessionFactoryUtil.getSessionFactory().openSession());
    }

}
