package ru.stqa.pft.mantis.appmanager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 20.07.2017.
 */
public class DbHelper {
  private ApplicationManager app;

  public DbHelper(ApplicationManager app) {
    this.app = app;
  }

  public String getUserName() throws SQLException {
    Connection connection = null;
    List<String> result = new ArrayList<>();
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker19?user=root&password=&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow");
    Statement statement = connection.createStatement();
    ResultSet results = statement.executeQuery("select username from mantis_user_table where username<>'administrator'");
    while (results.next()) {
      result.add(results.getString("username"));
    }
    results.close();
    statement.close();
    connection.close();
    return result.iterator().next();
  }
}


