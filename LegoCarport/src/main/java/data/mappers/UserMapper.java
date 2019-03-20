package data.mappers;

import data.Connector;
import logic.models.User;
import logic.LEGOAllPurposeException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    private static UserMapper userMapper;
    
    private UserMapper() {
        
    }
    
    public static UserMapper getInstance(){
        if(userMapper == null){
            userMapper = new UserMapper();
        }
        return userMapper;
    }

    public void createUser( User user ) throws LEGOAllPurposeException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO lego.users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LEGOAllPurposeException( ex.getMessage() );
        }
    }

    public User login( String email, String password ) throws LEGOAllPurposeException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id_user, role FROM lego.users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id_user" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LEGOAllPurposeException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LEGOAllPurposeException(ex.getMessage());
        }
    }

}
