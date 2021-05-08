package com.mycompany.main;

import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.UserSkill;

public class Main {

    public static void main(String[] args) {

        UserSkillDaoInter userSkill = Context.getInstanceUserSkillDao();
        UserSkill r = userSkill.getByIdUserSkill(1);
        System.out.println(r);

    }

}


