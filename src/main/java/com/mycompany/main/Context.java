/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.dao.impl.CountryDaoImpl;
import com.mycompany.dao.impl.EmploymentHistoryDaoImpl;
import com.mycompany.dao.impl.SkillDaoImpl;
import com.mycompany.dao.impl.UserDAOImpl;
import com.mycompany.dao.impl.UserSkillDaoImpl;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;

public class Context {

    public static UserDaoInter getInstanceUserDao() {
        return new UserDAOImpl();
    }

    public static UserSkillDaoInter getInstanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter getInstanceEmploymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }

    public static SkillDaoInter getInstanceSkillDao() {
        return new SkillDaoImpl();
    }

    public static CountryDaoInter getInstanceCountryDao() {
        return new CountryDaoImpl();
    }

}
