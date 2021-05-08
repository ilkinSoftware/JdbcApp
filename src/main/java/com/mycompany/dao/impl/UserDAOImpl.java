package com.mycompany.dao.impl;

import com.mycompany.entity.Country;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.dao.inter.UserDaoInter;

/**
 * data access object
 *
 * @author Lenovo
 */
public class UserDAOImpl extends AbstractDAO implements UserDaoInter {

    @Override
    public List<User> getAllUser() {
        List<User> lists = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("SELECT"
                    + "	myuser.*,"
                    + "	c.`name` AS country_name,"
                    + "	n.nationality AS nationality "
                    + "FROM"
                    + "	myuser"
                    + "	LEFT JOIN country n ON myuser.nationality_id = n.id"
                    + "	LEFT JOIN country c ON myuser.birthyplace_id = c.id ");
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                User u = checkUser(r);
                lists.add(u);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;

    }

    private User checkUser(ResultSet r) throws Exception {

        int id = r.getInt("id");
        String name = r.getString("name");
        String surName = r.getString("surname");
        String phone = r.getString("phone");
        String email = r.getString("email");
        Date birthyDate = r.getDate("birthydate");
        int countryId = r.getInt("birthyplace_id");
        int nationaltyId = r.getInt("nationality_id");
        String countryName = r.getString("country_name");
        String nationalityName = r.getString("nationality");
        String address = r.getString("address");
        String profileDesc = r.getString("profile_description");
        Country birthypalce = new Country(countryId, countryName, null);
        Country nationality = new Country(nationaltyId, null, nationalityName);

        return new User(name, surName, email, phone, id, birthyDate, nationality, birthypalce, address, profileDesc);

    }

    @Override
    public boolean updateUser(User u) {
        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("update myuser set name=?, surname=?,phone=?,email=?,address=?,profile_description=? , birthyplace_id=?, birthydate=? ,nationality_id=? where id =?");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurName());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getAddress());
            pstmt.setString(6, u.getProfileDesc());
            pstmt.setInt(7, u.getBirtypalce().getId());
            pstmt.setDate(8, u.getBirthyDate());
            pstmt.setInt(9, u.getNationality().getId());
            pstmt.setInt(10, u.getId());
            return result = pstmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return result;
        }

    }

    @Override
    public boolean removeUser(User u) {

        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            return stmt.execute("delete myuser.name from myuser where id=" + u.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public User getById(int userId) {
        User u = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("SELECT"
                    + "	myuser.*,"
                    + "	c.`name` AS country_name,"
                    + "	n.nationality AS nationality "
                    + "FROM"
                    + "	myuser"
                    + "	LEFT JOIN country n ON myuser.nationality_id = n.id"
                    + "	LEFT JOIN country c ON myuser.birthyplace_id = c.id where myuser.id=" + userId);
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                u = checkUser(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return u;

    }

    @Override
    public boolean addUser(User u) {
        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("insert into myuser(name,surname,email,phone,address,profile_description) values(?,?,?,?,?,?)");
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurName());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getEmail());
            pstmt.setString(5, u.getAddress());
            pstmt.setString(6, u.getProfileDesc());

            return result = pstmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return result;
        }

    }

}
