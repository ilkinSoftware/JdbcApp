/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Skill;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface SkillDaoInter {

    public List<Skill> getAll();

    public boolean removeSkill(int id);

    public boolean updateSkill(Skill s);

    public boolean addSkill(Skill sk);

    Skill getByIdSkill(int Id);

}
