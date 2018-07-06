package com.myTeam.server;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myTeam.client.MyTeamService;
import com.myTeam.client.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyTeamServiceImpl extends RemoteServiceServlet implements MyTeamService {
    // Implementation of sample interface method
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement ps = null;


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

    public List<String> getCategories() throws Exception {
        String query = "SELECT name FROM categories";
        List<String> categoryList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String result = rs.getString(1);
                categoryList.add(result);
            }
        }
        return categoryList;
    }

    public List<Team> getTeamswithCategory(int selectedIndex) throws Exception {
        List<Team> teamList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = psTeamswithCategory(selectedIndex, conn);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Team team = new Team();
                team.setId(rs.getInt(1));
                team.setName(rs.getString(2));
                team.setCity(rs.getString(3));
                team.setRanking(rs.getInt(4));
                team.setCategory_id(rs.getInt(5));
                teamList.add(team);
                for (int i=6 ; i < teamList.size() ; i++){
                    System.out.println(teamList.get(i).getName());
                }
            }
        }
        return teamList;
    }

    private PreparedStatement psSetInfo(String name, String surname, String city,
                                        String gender, int team_id, Connection conn) throws SQLException {
        String query = "INSERT INTO users(name,surname,city,gender,team_id) VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, city);
        ps.setString(4, gender);
        ps.setInt(5, team_id);
        return ps;
    }

    private PreparedStatement psTeamswithCategory(int selectedIndex, Connection conn) throws SQLException {
        String query = "SELECT team_id,name,city,ranking,category_id FROM teams WHERE category_id= ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, selectedIndex);
        return ps;
    }


    public class AutoClose implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("Resource closed..");
        }
    }

    @Override
    public String getMessage(String msg) {
        return null;
    }
}