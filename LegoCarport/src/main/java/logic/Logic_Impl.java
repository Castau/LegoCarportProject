/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.mappers.UserMapper;
import logic.models.HouseOrder;
import logic.models.User;

/**
 *
 * @author Camilla
 */
public class Logic_Impl implements LogicFacade{

    @Override
    public User login(String email, String password) throws LoginSampleException {
        return UserMapper.login( email, password );
    }

    @Override
    public User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    @Override
    public void createHouse(HouseOrder order) throws LoginSampleException {
        // call algorithm 
        // create stykliste
        // map stykliste to db
        // maybe return boolean to presentation
    }
    
    private int helpCreate(){
        // test if private metohds work in interface_impl
        return 1;
    }
    
}
