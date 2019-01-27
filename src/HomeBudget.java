import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.math.BigDecimal;
import java.sql.*;
import java.text.NumberFormat;

public class HomeBudget {
    private static final String DB_HOST = "morfeusz.wszib.edu.pl";
    private static final int DB_PORT = 1433;
    private static final String DB_USER = "nlukasik";
    private static final String DB_PASS = "natalia123";
    private static final String DB_NAME = "nlukasik";

    private static final String INSERT_ENTRY_SQL = "insert into Budget.BudgetEntries (EntryName, Amount) values (?, ?)";
    private static final String GET_BALANCE_SQL = "select sum(Amount) as Balance from Budget.BudgetEntries";
    private static final String GET_LAST_TEN = "select top 10 * from Budget.BudgetEntries order by EntryDate";

    public static void main(String[] args) {

        //todo required validation
        BudgetEntry be = new BudgetEntry();
        if (args[]>1){

        be.setEntryName(args[0]);
        be.setAmount(new BigDecimal(args[1]));
        }else {

        }




        HomeBudget hb = new HomeBudget();
        try (Connection con = hb.connect(DB_USER, DB_PASS, DB_NAME);
            Statement stmt = con.createStatement())
        {
            PreparedStatement ps = con.prepareStatement(INSERT_ENTRY_SQL);
            ps.setString(1, be.getEntryName());
            ps.setBigDecimal(2, be.getAmount());
            ps.execute();

            BigDecimal balance ;
            ResultSet rs = stmt.executeQuery(GET_BALANCE_SQL);
            if (rs.next()) {
                balance = rs.getBigDecimal("Balance");
            } else {
                balance= new BigDecimal(0);
            }

            System.out.print("Zapisano. nazwa:" + be.getEntryName());
            System.out.print(", kwota:" + hb.currencyFormat(be.getAmount()) );
            System.out.print(", saldo:" + hb.currencyFormat(balance) );



        } catch (SQLException e) {
            System.out.print("wystapił blad bazy danych " + e.getMessage());

        }


    }

    public Connection connect (String username, String password, String dbName) throws SQLServerException {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName(DB_HOST);
        ds.setPortNumber(DB_PORT);
        ds.setUser(username);
        ds.setPassword(password);
        ds.setDatabaseName(dbName);
        return ds.getConnection ();



    }
    public String currencyFormat(BigDecimal bd) {
        return NumberFormat.getCurrencyInstance().format(bd);

    }

}


