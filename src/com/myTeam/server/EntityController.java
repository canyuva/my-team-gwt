package com.myTeam.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityController {
    public static EntityController entityController;

    public synchronized static EntityController getEntityController(){
        if(entityController == null){
            entityController = new EntityController();
        }
        return  entityController;
    }

    public EntityManager createEM(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
