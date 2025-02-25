import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String URL, user, password, mysql;
        mysql = "INSERT INTO UNIVERSITY(UNIVERSITY_ID, UNIV_NAME, RAITING, CITY) VALUES ('256', 'ДВФУ', '554', 'Владивосток')";
        URL = "jdbc:mysql://localhost:3306/Base";
        user = "root";
        password = "Cfif170903!";

        Connection conn = DriverManager.getConnection(URL, user, password);

            try (Statement st = conn.createStatement()) {
            int rowsInserted = st.executeUpdate(mysql);
            if (rowsInserted > 0) {
                System.out.println("Данные успешно добавлены в базу");
            }
        }
    }
}