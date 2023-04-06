package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class AddressBookMain {
    public static final int ADD_DETAILS_DB = 1;
    private static final int EXIT = 2;

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book_database", "root", "narmada02");
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBookMain = new AddressBook();
        boolean condition = true;
        while (condition) {
            System.out.println("Enter what you want to perform");
            System.out.println("1.AddDetailsDb, 2.exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case ADD_DETAILS_DB:
                    addressBookMain.addDetailsDb(connection);
                    break;
                case EXIT:
                    condition=false;
            }
        }
    }
}
