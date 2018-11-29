import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("JDBC database");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Der er fjel med lortet, igen");
            e.printStackTrace();
        }
        System.out.println("Driver loaded");


        // 2) Connect to database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:33067/bank" , "root", "");
        System.out.println("Database connected");

        // 3) create a statement
        Statement statement = connection.createStatement();

        // 4)
        String sql = "select * from bruger";
        ResultSet resultSet = statement.executeQuery(sql);

        // 5)
        while (resultSet.next())
            System.out.println(resultSet.getString(2)+ "/t" + resultSet.getString(3));

        // 6) close the connection
        connection.close();
    }
}
