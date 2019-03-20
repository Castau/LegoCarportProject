/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.models.HouseOrder;
import logic.models.User;

/**
 *
 * @author Camilla
 */
public interface LogicFacade {

    public User login(String email, String password) throws LEGO_CustomException;

    public User createUser(String email, String password) throws LEGO_CustomException;
    
    public void saveHouse (HouseOrder order) throws LEGO_CustomException;
    
    public void createHouse(HouseOrder order) throws LEGO_CustomException;
    
}
