package com.myTeam.server;

import com.myTeam.Conversion;
import com.myTeam.server.entities.Team;
import com.myTeam.shared.TeamDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RunnerJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT t FROM Team t WHERE t.fk_category_id=:index");
        int selectedIndex = 2;
        q.setParameter("index",selectedIndex);
        Team team = (Team) q.getSingleResult();
        Conversion convert = new Conversion();
        TeamDTO tdto = convert.teamDTO(team);
        List<TeamDTO> dtoList = null;
        dtoList.add(tdto);
        for (int i=0 ; i < dtoList.size() ; i++){
            System.out.println(dtoList.get(i).getName());
        }
        em.getTransaction().commit();
    }
}
