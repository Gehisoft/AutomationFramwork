package utilities;

import java.io.IOException;
import java.sql.*;

public class DBconnection {


    public ResultSet getResultSetForQuery(String query) throws SQLException, IOException, ClassNotFoundException {

        LoadProperties dbproperties = new LoadProperties();

        String dbenv = dbproperties.getTestProperties("env");
        String dbip = dbproperties.getTestProperties(dbenv + "dbip");
        String dbport = dbproperties.getTestProperties(dbenv + "dbport");
        String dbname = dbproperties.getTestProperties(dbenv + "dbname");
        String dbusername = dbproperties.getTestProperties(dbenv + "dbusername");
        String dbpd = dbproperties.getTestProperties(dbenv + "dbpassword");

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connectionstring = "jdbc:oracle:thin:@//" + dbip + ":" + dbport + "/" + dbname;
        Connection con = DriverManager.getConnection(connectionstring, dbusername, dbpd);
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(query);

        return result;


    }

}
