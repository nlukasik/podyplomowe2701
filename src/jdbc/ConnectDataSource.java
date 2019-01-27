/*
package jdbc;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDataSource {
    public static void main(String[] args) {

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("nlukasik");
        ds.setServerName("morfeusz.wszib.edu.pl");
        ds.setPortNumber(1433);
        ds.setDatabaseName("AdventureWorks");
        ds.setPassword("natalia123");

        String sql = "SELECT * FROM Person.Contact";

        try(Connection con =ds.getConnection(); Statement stmt =con.createStatement()){

            ResultSet rs = stmt.executeQuery(sql);
            String topicBody;
            int id;

            while (rs.next()){
                if (topicBody=rs.getString(""))

            }

        } catch (SQLException  e) {
            System.out.println("problemy z baza danych ");

        }
    }
}
*/
