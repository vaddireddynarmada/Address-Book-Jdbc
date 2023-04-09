package org.example;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    private static final int ADD_DETAILS_DATABASE = 1;
    private static final int ADD_DETAILS_CONTACT = 2;
    private static final int COUNT_BY_CITY = 3;

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookSystem", "root", "narmada02");
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean condition = true;
        while (condition) {
            System.out.println("Enter what you want to perform");
            System.out.println("1.AddContactDataBase, 2.AddDetailsContact, 3.CountCity");
           int choice=scanner.nextInt();
           switch (choice){
               case ADD_DETAILS_DATABASE:
                   addressBook.addContactDataBase(connection);
                   break;
               case ADD_DETAILS_CONTACT:
                   addressBook.addDetailsContact(connection);
                   break;
               case COUNT_BY_CITY:
                   addressBook.countCity(connection);
                   break;
           }
        }
    }
}
