/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.mappers.UserMapper;
import logic.models.HouseOrder;
import logic.models.User;
import logic.models.User.Role;

/**
 *
 * @author Camilla
 */
public class Logic_Impl implements LogicFacade{

    @Override
    public User login(String email, String password) throws LEGOAllPurposeException {
        return UserMapper.getInstance().login( email, password );
    }

    @Override
    public User createUser(String email, String password) throws LEGOAllPurposeException {
        User user = new User(email, password, Role.customer);
        UserMapper.getInstance().createUser( user );
        return user;
    }

    @Override
    public void createHouse(HouseOrder order) throws LEGOAllPurposeException {
        // call algorithm 
        // create stykliste
        // map stykliste to db
        // maybe return boolean to presentation
    }
    
    private int helpCreate(){
        // test if private metohds work in interface_impl
        return 1;
    }

    @Override
    public void saveHouse(HouseOrder order) throws LEGOAllPurposeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
