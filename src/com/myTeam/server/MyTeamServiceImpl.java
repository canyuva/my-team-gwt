package com.myTeam.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.myTeam.client.MyTeamService;

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
        String url = "jdbc:mysql://localhost:PORT/db_name";
        String username = "username";
        String password = "password";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public List<String> getTeams(){
        try {
            conn = getConnection();
            String query = "SELECT name FROM teams";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            List<String> teamList = new ArrayList<String>();

            while(rs.next()){
                String result = rs.getString(1);
                teamList.add(result);
            }

            return teamList;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error from getting team list!");
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public String getMessage(String msg) {
        return null;
    }
}