package com.myTeam.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myTeam.client.MyTeamService;
import com.myTeam.server.entities.Category;
import com.myTeam.server.entities.Team;

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

    public String sendInformation(String name, String surname, String city,
                                String gender, int team_id) throws Exception {
        try(Connection conn = getConnection();
            PreparedStatement ps = psSetInfo(name,surname,city,gender,team_id,conn)) {
            int i = ps.executeUpdate();
            if(i < 0){
                return "Error!!!";
            }
        }
        return "Success";
    }

    public List<String> getCategories(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Category cat = new Category();
        Query q = em.createQuery("SELECT c.cat_name FROM Category c");
        List<String> catList = q.getResultList();
        em.getTransaction().commit();
        return catList;
    }

    public List<Team> getTeamswithCategory(int selectedIndex) {
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
        em.getTransaction().commit();
        return teamList;
    }

    private PreparedStatement psSetInfo(String name, String surname, String city,
                                        String gender, int team_id, Connection conn) throws SQLException {
        String query = "INSERT INTO USER(NAME,SURNAME,CITY,GENDER,FK_TEAM_ID) VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, city);
        ps.setString(4, gender);
        ps.setInt(5, team_id);
        return ps;
    }

}