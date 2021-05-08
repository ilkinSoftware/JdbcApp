/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.entity.Country;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.CountryDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        List<Country> lists = new ArrayList<>();
        try {
            Connection c = connect();

            PreparedStatement pstmt = c.prepareStatement("select * from country");
            pstmt.execute();
            ResultSet r = pstmt.getResultSet();
            while (r.next()) {
                Country country = checkCountry(r);
                lists.add(country);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return lists;

    }

    private Country checkCountry(ResultSet r) throws Exception {

        int id = r.getInt("id");
        String countryName = r.getString("name");
        String nationality = r.getString("nationality");
        return new Country(id, countryName, nationality);

    }

    @Override
    public boolean removeCountry(int countryId) throws Exception {

        Connection c = connect();
        Statement stmt = c.createStatement();
        return stmt.execute("delete country.*from country where country.id=" + countryId);

    }

    @Override
    public boolean updateCountry(Country c) {
        boolean result = false;
        try {
            Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement("update country set  name=?, nationality=? where id=" + c.getId());
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getNationality());
            return result = pstmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean addCountry(Country c) {
        boolean result = false;
        try {
            Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement("insert into country (name,nationality) values(?,?)");
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getNationality());
            result = pstmt.execute();
            return result;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    @Override
    public Country getcountryById(int countryId) {
        Country country = null;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("select * from country where country.id=" + countryId);
            pstmt.execute();
            ResultSet r = pstmt.getResultSet();

             while (r.next()) {
                country = checkCountry(r);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return country;
    }

}
