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

import javax.persistence.*;
import java.sql.*;
import java.util.List;


public class MyTeamServiceImpl extends RemoteServiceServlet implements MyTeamService {
    // Implementation of sample interface method


    public Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/teamdb";
        String username = "admin";
        String password = "8520";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }


    public List<CategoryDTO> getCategories(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Category cat = new Category();
        Query q = em.createQuery("SELECT c FROM Category c");
        List<Category> catList = q.getResultList();
        Conversion convert = new Conversion();
        List<CategoryDTO> catDTOList = convert.fromCategoryToDTO(catList);
        em.getTransaction().commit();
        return catDTOList;
    }

    public List<TeamDTO> getTeamswithCategory(int selectedIndex) {
        if(selectedIndex < 1){
            selectedIndex = 1;
        }
        // Entity Manager ayrı sınıfa yazılacak
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT t FROM Team t WHERE t.fk_category_id=:index");
        q.setParameter("index",selectedIndex);
        List<Team> teamList = q.getResultList();
        Conversion convert = new Conversion();
        List<TeamDTO> dtoList = convert.fromTeamToDTO(teamList);
        em.getTransaction().commit();
        return dtoList;
    }

    public void sendInformation(UserDTO userDTO){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Conversion convert = new Conversion();
        User user = convert.fromDTOtoUser(userDTO);
        em.persist(user);
        em.getTransaction().commit();
    }

}