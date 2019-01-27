package jdbc;

import java.sql.*;

public class Employee {
    public static void main(String[] args) throws SQLException {
        String connectionUrl =
                "jdbc:sqlserver://morfeusz.wszib.edu.pl:1433;databaseName=AdventureWorks;user=nlukasik;password=natalia123";
        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select top 10 * from  person.contact where LastName = 'Anderson'");
        while (rs.next()) {
            System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));

        }
        rs.close();


        ResultSet ts = stmt.executeQuery("select distinct Title  from HumanResources.Employee");
        while (ts.next()) {
            System.out.println(ts.getString("Title") );

        }

        ts.close();



        ResultSet zs = stmt.executeQuery("select CustomerID, count (SalesOrderID) as IloscZamowien from sales.SalesOrderHeader group by CustomerID");
        while (zs.next()) {
            System.out.println(zs.getString("CustomerID") + " " + zs.getString("IloscZamowien")  );

        }

        zs.close();
        stmt.close();
        con.close();

    }
}
