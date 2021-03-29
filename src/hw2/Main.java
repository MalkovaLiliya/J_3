package hw2;

import java.sql.*;

/*1 метод создани таблицы
2 метод для добавления записи
3 метод для получения записи
4 метод для удаления записи
5 удаление таблицы*/
public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createTable(){
        try {
            stmt.executeUpdate("CREATE TABLE homeworkers (" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " name TEXT NOT NULL," +
                    " ex INTEGER)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addData(String name, int ex){
        try {
            pstmt = connection.prepareStatement("INSERT INTO homeworkers (name, ex) VALUES (?, ?);");
            pstmt.setString(1, name);
            pstmt.setInt(2, ex);
            pstmt.addBatch();
            pstmt.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showData(String nameSearch) {
        try {
            pstmt = connection.prepareStatement("SELECT * FROM homeworkers WHERE name = ?");
            pstmt.setString(1, nameSearch);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("ex"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteFromTable(int id){
        try {
            pstmt = connection.prepareStatement("DELETE FROM homeworkers WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteTable(){
        try {
            stmt.executeUpdate("DROP TABLE homeworkers");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {
        connect();
        //createTable();
//        addData("qwer", 56);
//        addData("asdf", 5);
//        addData("zxcv", 75);
//        showData("zxcv");
//        showData("qwer");
        deleteFromTable(5);
        //deleteTable();
        disconnect();


    }
}
