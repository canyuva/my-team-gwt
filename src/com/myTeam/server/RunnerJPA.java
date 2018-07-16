package com.myTeam.server;

import com.myTeam.server.entities.Category;
import com.myTeam.server.entities.Team;

import javax.persistence.*;
import java.util.List;

public class RunnerJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT t FROM Team t WHERE t.fk_category_id=:index");
        int selectedIndex = 2;
        q.setParameter("index",selectedIndex);
        List<Team> teamList = q.getResultList();
        for (int i=0 ; i < teamList.size() ; i++){
            System.out.println(teamList.get(i).getName());
        }
        em.getTransaction().commit();
    }
}
