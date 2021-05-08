/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface UserDaoInter {

    List<User> getAllUser();

    boolean updateUser(User u);

    boolean removeUser(User id);

    User getById(int userId);

    boolean addUser(User u);

}
