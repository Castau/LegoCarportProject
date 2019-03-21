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
import java.util.ArrayList;
import logic.LEGO_CustomException;
import logic.models.HouseOrder;

/**
 *
 * @author Camilla
 */
public class OrderMapper {

    private static OrderMapper orderMapper;

    private OrderMapper() {

    }

    public static OrderMapper getInstance() {
        if (orderMapper == null) {
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }

    public void createOrder(HouseOrder order) throws LEGO_CustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO lego.orders (orders.id_user, orders.length, orders.width, orders.height, orders.door, orders.window)"
                    + " VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getUserID());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setInt(5, order.isDoor() ? 1 : 0);
            ps.setInt(6, order.isWindow() ? 1 : 0);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LEGO_CustomException(ex.getMessage());
        }
    }

    public ArrayList<HouseOrder> getAllOrders() throws LEGO_CustomException {
        ArrayList<HouseOrder> allOrders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM lego.orders; ";
            ResultSet rs = con.prepareStatement(SQL).executeQuery();

            while (rs.next()) {
                HouseOrder order = new HouseOrder();
                order.setHeight(rs.getInt("height"));
                order.setWidth(rs.getInt("width"));
                order.setLength(rs.getInt("length"));
                order.setDoor(rs.getInt("door") > 0);
                order.setWindow(rs.getInt("window") > 0);
                order.setUserID(rs.getInt("id_user"));
                order.setOrderID(rs.getInt("id_order"));
                order.setStatus(rs.getString("order_status"));
                allOrders.add(order);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LEGO_CustomException(ex.getMessage());
        }
        return allOrders;
    }

    public ArrayList<HouseOrder> getAllOrdersByUserID(int userID) throws LEGO_CustomException {
        ArrayList<HouseOrder> allOrders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM lego.orders "
                    + "WHERE id_user = '" + userID + "';";
            ResultSet rs = con.prepareStatement(SQL).executeQuery();

            while (rs.next()) {
                HouseOrder order = new HouseOrder();
                order.setHeight(rs.getInt("height"));
                order.setWidth(rs.getInt("width"));
                order.setLength(rs.getInt("length"));
                order.setDoor(rs.getInt("door") > 0);
                order.setWindow(rs.getInt("window") > 0);
                order.setUserID(rs.getInt("id_user"));
                order.setOrderID(rs.getInt("id_order"));
                order.setStatus(rs.getString("order_status"));
                allOrders.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LEGO_CustomException(ex.getMessage());
        }
        return allOrders;
    }

    public void empUpdateOrder(HouseOrder order) throws LEGO_CustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE lego.orders SET order_status = 'SHIPPED' "
                    + "WHERE id_order = '" + order.getOrderID() + "';";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LEGO_CustomException(ex.getMessage());
        }
    }

    public HouseOrder getOrderByOrderID(int orderID) throws LEGO_CustomException {
        HouseOrder order = new HouseOrder();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM lego.orders "
                    + "WHERE id_order = '" + orderID + "';";
            ResultSet rs = con.prepareStatement(SQL).executeQuery();

            while (rs.next()) {
                order.setHeight(rs.getInt("height"));
                order.setWidth(rs.getInt("width"));
                order.setLength(rs.getInt("length"));
                order.setDoor(rs.getInt("door") > 0);
                order.setWindow(rs.getInt("window") > 0);
                order.setUserID(rs.getInt("id_user"));
                order.setOrderID(rs.getInt("id_order"));
                order.setStatus(rs.getString("order_status"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LEGO_CustomException(ex.getMessage());
        }
        return order;
    }
}
