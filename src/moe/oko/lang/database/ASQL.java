package moe.oko.lang.database;

import java.sql.*;

public class ASQL {
    static Connection connection = null;
    private static String connectionString = "";
    public static void initConnection() {
        if (connection != null) {
            System.err.println("[DATABASE] WARN | The moe.oko.lang.database.ASQL.initConnection has already ran. A database connection was found.");
            return;
        }
        try {
            connection = DriverManager.getConnection(connectionString);
            System.out.println("[DATABASE] SUCCESS | Connection established.");
        } catch (SQLException e) {
            System.err.println("[DATABASE] ERROR | The moe.oko.lang.database.ASQL.initConnection failed to execute!");
        }
    }
    
    public static int setLocaleValue(String UUID, String Locale){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE locale_table SET locale=? WHERE uuid=?");
            preparedStatement.setString(1, UUID);
	    preparedStatement.setString(2, Locale);
            preparedStatement.executeQuery();
            preparedStatement.close();
            resultSet.close();
            return 0;

        } catch (SQLException exception) {
            System.err.println("[DATABASE] ERROR | The moe.oko.lang.database.ASQL.setLocaleValue function failed to execute successfully.");
            System.err.println(exception);
        }
        return 0;
    }
    public static String getLocaleValue(String UUID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT locale FROM locale_table WHERE uuid=?");
            preparedStatement.setString(1, UUID);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
            resultSet.close();
            return resultSet.getString("locale");

        } catch (SQLException exception) {
            System.err.println("[DATABASE] ERROR | The moe.oko.lang.database.ASQL.setLocaleValue function failed to execute successfully.");
            System.err.println(exception);
        }
        return "auto";
    }
}
