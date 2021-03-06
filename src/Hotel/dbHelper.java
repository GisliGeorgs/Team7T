package Hotel;
import java.sql.*;

/**
 * Created by Svava Hildur on 20/03/16.
 */
public class dbHelper {

    public ResultSet runQuery(String queryStr, Object[] params) {
        //fokkju
        Connection c = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/Hotel",
                            "postgres", "postgres");
            System.out.println("Opened database successfully");

            stmt = c.prepareStatement(queryStr);
            for(int i=0; i<params.length; i++) {
                if(params[i].getClass()==Integer.class) {
                    stmt.setInt(i+1, (Integer) params[i]);
                }
                else if(params[i].getClass()==String.class) {
                    stmt.setString(i+1, (String)params[i]);
                }
                else if(params[i].getClass()==Double.class) {
                    stmt.setDouble(i+1, (Double) params[i]);
                }
                else if(params[i].getClass()==java.sql.Date.class) {
                    stmt.setDate(i+1, (java.sql.Date) params[i]);
                }
            }
            if(queryStr.charAt(0)=='S') {
                result = stmt.executeQuery();
            }
            else {
                stmt.executeUpdate();
            }
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }
}