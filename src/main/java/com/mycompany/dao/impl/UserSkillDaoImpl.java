/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserSkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> lists = new ArrayList<>();
        try {
            Connection c = connect();

            PreparedStatement pstmt = c.prepareStatement("SELECT "
                    + "	u.*,"
                    + "	us.power,"
                    + " us.id as user_skill_id ,"
                    + "	s.id as skill_id,"
                    + "	s.`name` as skill_name "
                    + " FROM"
                    + "	user_skill as us"
                    + "	LEFT JOIN myuser as u ON us.user_id = u.id"
                    + "	LEFT JOIN skill as s ON us.skill_id = s.id"
                    + " where us.user_id=" + userId);
            pstmt.execute();
            ResultSet r = pstmt.getResultSet();
            while (r.next()) {
                UserSkill us = checkUserSkill(r);
                lists.add(us);

            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return lists;

    }

    private UserSkill checkUserSkill(ResultSet r) {
        UserSkill us = null;
        try {
            int id = r.getInt("id");
            int power = r.getInt("power");
            int skillId = r.getInt("skill_id");
            int userSkillId = r.getInt("user_skill_id");
            String skillName = r.getString("skill_name");

            us = new UserSkill(userSkillId, new User(id), new Skill(skillId, skillName), power);
            return us;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return us;
    }

    @Override
    public boolean removeUserSkill(int id) {
        boolean result = false;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            result = stmt.execute("delete user_skill.* from user_skill where id=" + id);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("update user_skill set  power=?,skill_id=? where user_skill.id=" + u.getId());
            pstmt.setInt(1, u.getPower());
            pstmt.setInt(2, u.getSkill().getId());
            result = pstmt.execute();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUserSkill(UserSkill u) {
        boolean result = false;
        try {
            Connection c = connect();
            PreparedStatement pstmt = c.prepareStatement("insert into user_skill (user_id ,skill_id , power) values(?,?,?)");
            pstmt.setInt(1, u.getUser().getId());
            pstmt.setInt(2, u.getSkill().getId());
            pstmt.setInt(3, u.getPower());

            result = pstmt.execute();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public UserSkill getByIdUserSkill(int userId) {
        UserSkill us = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("SELECT "
                    + " us.user_id as UserId,"
                    + "	u.id,"
                    + "	us.power,"
                    + "	us.id as user_skill_id,"
                    + "	s.id AS skill_id,"
                    + "	s.`name` AS skill_name "
                    + "FROM"
                    + "	user_skill AS us"
                    + "	LEFT JOIN myuser AS u ON us.user_id = u.id"
                    + "	LEFT JOIN skill AS s ON us.skill_id = s.id "
                    + "WHERE"
                    + "	us.user_id =" + userId);
            ResultSet r = stmt.getResultSet();

            while (r.next()) {
                us = checkUserSkill(r);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return us;

    }
}
