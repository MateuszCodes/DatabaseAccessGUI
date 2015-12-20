import java.sql.*;
//import oracle.jdbc.pool.OracleDataSource;

public class SQLConnect {

    static Connection conn;

    public static void connect(String user, String pass) throws SQLException {
    
        String URL = "jdbc:oracle:thin:" + user + "/" + pass + "@address:port:name";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        catch(IllegalAccessException ex) {
            System.out.println("Error: access problem while loading!");
            System.exit(2);
        }
        catch(InstantiationException ex){
            System.out.println("Error: unable to instantiate driver!");
            System.exit(3);
        }
        //Don't fucking delete!!! I'm serious
        try{
            conn = DriverManager.getConnection(URL);
            if(conn.isValid(30)) {
                System.out.println("Connection established");
                LoginMenu.updateLoginBox();
                MainMenu menu = new MainMenu();
            }
        }catch (SQLException e)
        {
            System.out.println("Error connection");
        }


    }

    public static void closeConnection() throws SQLException {
        conn.close();
    }

}
