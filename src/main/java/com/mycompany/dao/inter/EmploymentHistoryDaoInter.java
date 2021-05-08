/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface EmploymentHistoryDaoInter {

    List<EmploymentHistory> getAllEmploymentHistoryGetById(int id);

    boolean removeEmpolymetHistroy(User u);

    boolean updateEmploymetHistroy(EmploymentHistory u);

    boolean addEmploymetHistroy(EmploymentHistory u);
    
    EmploymentHistory getByIdEmploymentHistroy(int Id);

}
