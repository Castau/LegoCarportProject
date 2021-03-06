package data.mappers;

import data.Connector;
import logic.models.User;
import logic.LegoCustomException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Camilla
 */

    // The mappers are made as singletons, so that only one instance can exist
    // at a time, since the state of the objects never change.
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

    public void createUser( User user ) throws LegoCustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO lego.users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole().toString() );
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LegoCustomException( ex.getMessage() );
        }
    }

    public User login( String email, String password ) throws LegoCustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id_user, role FROM lego.users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                User.Role role = User.Role.valueOf(rs.getString( "role" ));
                int id = rs.getInt( "id_user" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LegoCustomException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoCustomException(ex.getMessage());
        }
    }

}
