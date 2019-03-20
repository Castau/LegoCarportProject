/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.mappers;

import data.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.LEGO_CustomException;
import logic.models.HouseOrder;
import logic.models.User;

/**
 *
 * @author Camilla
 */

public class OrderMapper {

    private static OrderMapper orderMapper;
    
    private OrderMapper() {
        
    }
    
    public static OrderMapper getInstance(){
        if(orderMapper == null){
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }
    
    
    public void createUser(HouseOrder order) throws LEGO_CustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO lego.orders (id_user, length, width, height, door, window) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt( 1, order.getUser().getId() );
            ps.setInt( 2, order.getLength() );
            ps.setInt( 3, order.getWidth() );
            ps.setInt( 4, order.getHeight() );
            ps.setInt( 5, order.isDoor() ? 1 : 0 );
            ps.setInt( 6, order.isDoor() ? 1 : 0 );
            ps.executeUpdate();
            
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LEGO_CustomException( ex.getMessage() );
        }
    }
    
}