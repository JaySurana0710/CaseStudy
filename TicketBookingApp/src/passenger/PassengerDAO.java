package passenger;

import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerDAO {
    private DbConnection connection = new DbConnection();

    public void insertIntoPassenger(Passenger p){
        Connection con = connection.getConnection();
        try{
            String query = "insert into PASSENGERS values (?,?,?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,p.getName());
            pstm.setInt(2, p.getAge());
            pstm.setString(3, String.valueOf(p.getGender()));



            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

}
