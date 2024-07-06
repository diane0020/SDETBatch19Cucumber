package utils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static List<Map<String, String>> fetch(String query) {

        List<Map<String, String>> tableData = new ArrayList<>();

        try {
            // create a connection to the database
            String dbUrl = ConfigReader.read("dbURL");
            String dbUserName = ConfigReader.read("dbUserName");
            String dbPassword = ConfigReader.read("dbPassword");

            Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

            // take the queries from java code, execute them on the database, then bring the result back into java
            // program
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            // loop through to the resultSet
            // next() method in the resultSet checks if there are any more rows
            while (resultSet.next()) {
                // resultSet is like the data table in cucumber
                Map<String, String> rowMap = new LinkedHashMap<>();

                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    // getting the column names from resultMetaData
                    String key = resultSetMetaData.getColumnLabel(i);
                    // getting the column data from resultSet
                    String value = resultSet.getString(i);

                    // storing to map
                    rowMap.put(key, value);
                }
                // storing the map to the list
                tableData.add(rowMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableData;

    }

//    public static void main(String[] args) {
//        System.out.println(fetch("select * from employee"));
//    }
}
