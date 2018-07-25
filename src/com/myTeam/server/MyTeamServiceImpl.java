package com.myTeam.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myTeam.Conversion;
import com.myTeam.client.MyTeamService;
import com.myTeam.server.entities.Category;
import com.myTeam.server.entities.Team;
import com.myTeam.server.entities.User;
import com.myTeam.shared.CategoryDTO;
import com.myTeam.shared.TeamDTO;
import com.myTeam.shared.UserDTO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class MyTeamServiceImpl extends RemoteServiceServlet implements MyTeamService {
    // Implementation of sample interface method

    public List<CategoryDTO> getCategories() {
        EntityManager em = EntityController.getEntityController().createEM();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c FROM Category c");
        List<Category> catList = q.getResultList();
        List<CategoryDTO> catDTOList = Conversion.getConvert().fromCategoryToDTO(catList);
        em.getTransaction().commit();
        return catDTOList;
    }

    public List<TeamDTO> getTeamswithCategory(int selectedIndex) {
        if (selectedIndex < 1) { selectedIndex = 1; }

        EntityManager em = EntityController.getEntityController().createEM();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT t FROM Team t WHERE t.fk_category_id=:index");
        q.setParameter("index", selectedIndex);
        List<Team> teamList = q.getResultList();
        List<TeamDTO> dtoList = Conversion.getConvert().fromTeamToDTO(teamList);
        em.getTransaction().commit();
        return dtoList;
    }

    public List<UserDTO> getUsers() {

        EntityManager em = EntityController.getEntityController().createEM();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM User u");
        List<User> userList = q.getResultList();
        List<UserDTO> dtoList = Conversion.getConvert().fromUserToDTO(userList);
        em.getTransaction().commit();
        return dtoList;
    }

    public void sendInformation(UserDTO userDTO) {
        EntityManager em = EntityController.getEntityController().createEM();
        em.getTransaction().begin();
        User user = Conversion.getConvert().fromDTOtoUser(userDTO);
        em.persist(user);
        em.getTransaction().commit();
    }

}