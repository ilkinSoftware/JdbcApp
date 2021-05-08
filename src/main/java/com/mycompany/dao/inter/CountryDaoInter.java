/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.Country;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface CountryDaoInter {

    public List<Country> getAll();

    public boolean removeCountry(int countryId) throws Exception;

    public boolean updateCountry(Country c);

    public boolean addCountry(Country c);

    public Country getcountryById(int countryId);

}
