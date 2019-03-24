package data.mappers;

import data.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logic.LegoCustomException;
import logic.models.HouseOrder;

/**
 *
 * @author Camilla
 */
public class OrderMapper {

    // The mappers are made as singletons, so that only one instance can exist
    // at a time, since the state of the objects never change.
    private static OrderMapper orderMapper;

    private OrderMapper() {

    }

    public static OrderMapper getInstance() {
        if (orderMapper == null) {
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }

    public void createOrder(HouseOrder order) throws LegoCustomException {
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
            throw new LegoCustomException(ex.getMessage());
        }
    }

    public ArrayList<HouseOrder> getAllOrders() throws LegoCustomException {
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
            throw new LegoCustomException(ex.getMessage());
        }
        return allOrders;
    }

    public ArrayList<HouseOrder> getAllOrdersByUserID(int userID) throws LegoCustomException {
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
            throw new LegoCustomException(ex.getMessage());
        }
        return allOrders;
    }

    public void empUpdateOrder(HouseOrder order) throws LegoCustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE lego.orders SET order_status = 'SHIPPED' "
                    + "WHERE id_order = '" + order.getOrderID() + "';";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoCustomException(ex.getMessage());
        }
    }

    public HouseOrder getOrderByOrderID(int orderID) throws LegoCustomException {
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
            throw new LegoCustomException(ex.getMessage());
        }
        return order;
    }
}
