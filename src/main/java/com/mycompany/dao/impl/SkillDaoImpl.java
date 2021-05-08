/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.entity.Skill;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.SkillDaoInter;
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
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        List<Skill> lists = new ArrayList<>();
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("select * from skill");
            pstmt.execute();
            ResultSet r = pstmt.getResultSet();
            while (r.next()) {
                Skill skill = checkSkill(r);
                lists.add(skill);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    private Skill checkSkill(ResultSet r) throws Exception {

        int id = r.getInt("id");
        String skillName = r.getString("name");

        return new Skill(id, skillName);

    }

    @Override
    public boolean removeSkill(int id) {
        boolean result = false;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            result = stmt.execute("delete * from skill where skill.id=" + id);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean updateSkill(Skill s) {
        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("update skill set  name=? where id=" + s.getId());
            pstmt.setString(1, s.getName());
            result = pstmt.execute();

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addSkill(Skill s) {
        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("insert into skill (name) values(?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, s.getName());
            result = pstmt.execute();
            ResultSet generetedKeys = pstmt.getGeneratedKeys();
            if (generetedKeys.next()) {
                s.setId(generetedKeys.getInt(1));
            }
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Skill getByIdSkill(int id) {
        Skill s = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill where skill.id=" + id);
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                s = checkSkill(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }

}
