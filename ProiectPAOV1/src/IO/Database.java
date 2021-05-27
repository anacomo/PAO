package IO;

import java.sql.*;
import java.util.Scanner;

public class Database {
    private static String user = "lib";
    private static String password = "lib";
    private static String url = "jdbc:mysql://localhost:3306/db_library";

    private static Database instance = null;

    private Database() { }

    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public void handleTables() {
        Scanner sc = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            while (true) {
                System.out.println("What would you like to do?");
                System.out.println("    - for insert use command add table_name");
                System.out.println("    - for show use command show table_name");
                System.out.println("    - for delete use command delete table_name name/first_name");
                System.out.println("    - for update use command update table_name old_input new_input");
                System.out.println("    - for quit use command quit");
                String command = sc.nextLine();
                if(command.equals("quit")){
                    System.out.println("Exiting...");
                    break;
                }
                String [] arr = command.split(" ");
                if (arr[0].equals("add")) {
                    if (arr.length == 3)
                        insertElement(connection, arr[1], arr[2]);
                    if (arr.length == 4)
                        insertElement(connection, arr[1], arr[2], arr[3]);
                }
                if (arr[0].equals("show")) {
                    ResultSet rs = showTable(connection, arr[1]);
                    if (arr[1].equals("section") || arr[1].equals("university") || arr[1].equals("book"))
                        showInfo(connection, rs, false);
                    else
                        showInfo(connection, rs, true);
                }
                if (arr[0].equals("update")) {
                    if (arr.length == 4)
                        updateElement(connection, arr[1], arr[2], arr[3]);
                    else
                        updateElement(connection, arr[1], arr[2], arr[3], arr[4], arr[5]);
                }
                if (arr[0].equals("delete")) {
                    if (arr.length == 3)
                        deleteElement(connection, arr[1], arr[2]);
                    if (arr.length == 4) {
                        deleteElement(connection, arr[1], arr[2], arr[3]);
                    }
                }

            }
//            insertElement(connection, "section", "drama");
//            insertElement(connection,"student", "A", "B");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertElement(Connection connection, String table, String firstName, String lastName) {
        String sql = "insert into " + table + " values (null, \"" + firstName + "\", \"" + lastName + "\");";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertElement(Connection connection, String table, String name) {
        String sql = "insert into " + table + " values (null, \"" + name + "\");";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateElement(Connection connection, String table, String oldName, String newName) {
        String sql = "update " + table + " set name = \"" + newName + "\" where name = \"" + oldName + "\";";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateElement(Connection connection, String table, String oldFirstName, String oldLastName,
                                     String newFirstName, String newLastName) {
        String sql = "update " + table + " set first_name = \"" + newFirstName + "\", " + " last_name = \"" + newLastName + "\"" +
                     " where first_name = \"" + oldFirstName + "\" and last_name = \""+ oldLastName + "\";";
        System.out.println(sql);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet showTable(Connection connection, String table) throws SQLException {
        String query = "select * from " + table + ";";
        return connection.prepareStatement(query).executeQuery();
    }

    public static void deleteElement(Connection connection, String table, String name) {
        String sql = "delete from " + table + " where lower(name) = \"" + name.toLowerCase() + "\";";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteElement(Connection connection, String table, String firstName, String lastName) {
        String sql = "delete from " + table + " where lower(first_name) = \"" + firstName.toLowerCase()
                                            + "\" and lower(last_name) = \"" + lastName.toLowerCase() + "\";";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showInfo(Connection connection, ResultSet result, boolean person) throws SQLException {
        while (result.next()) {
            if (!person)
                System.out.println("id: " + result.getInt(1) + " | nume: " + result.getString(2));
            else
                System.out.println("id: " + result.getInt(1) + " | prenume: " +
                        result.getString(2) + " | nume: " + result.getString(3));
        }
        System.out.println();
    }

}
