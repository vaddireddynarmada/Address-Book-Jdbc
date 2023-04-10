package org.example;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    private static final int CREATE_TABLE_ADDRESS_BOOK = 1;
    private static final int ADD_DETAILS_DATABASE = 2;
    private static final int ADD_DETAILS_CONTACT = 3;
    private static final int COUNT_BY_CITY = 4;
    private static final int DISPLAY_ADDRESSBOOK_TYPE =5 ;
    private static final int DISPLAY_CONTACTS_BOOKTYPE = 6;
    private static final int DELETE = 7;
    private static final int EDIT_BOOK_CONTACT = 8;
    private static final int ADD_NEW_CONTACT = 9;

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookSystem", "root", "narmada02");
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean condition = true;
        while (condition) {
            System.out.println("Enter what you want to perform");
            System.out.println("1.CreateTable, 2.AddContactDataBase, 3.AddDetailsContact, 4.CountCity, 5.DisplayBookType, 6.DisplayBookContact, 7.DeleteContact" +
                    "8.EditBookContact");
           int choice=scanner.nextInt();
           switch (choice){
               case CREATE_TABLE_ADDRESS_BOOK:
                    String query = "create table AddressBook( " +
                            "id INT unsigned not null auto_increment," +
                            "FirstName varchar(20) not null ," +
                            "LastName varchar(20) not null , " +
                            "Address varchar(100) not null , " +
                            "City varchar(30) not null ," +
                            "State varchar(30) not null , " +
                            "Email varchar(30) not null , " +
                            "ZipCode int not null ," +
                            "PhoneNumber int not null," +
                            "BookName varchar(25) not null," +
                            "BookType varchar(20) not null, " +
                            "primary key (id))";
                    addressBook.createNewTable(connection, query);
                    break;
               case ADD_DETAILS_DATABASE:
                   addressBook.addContactDataBase(connection);
                   break;
               case ADD_DETAILS_CONTACT:
                   addressBook.addDetailsContact(connection);
                   break;
               case COUNT_BY_CITY:
                   addressBook.countCity(connection);
                   break;
               case DISPLAY_ADDRESSBOOK_TYPE:
                   addressBook.displayBookType(connection);
                   break;
               case DISPLAY_CONTACTS_BOOKTYPE:
                   addressBook.displayBookType(connection);
                   addressBook.displayBookContact(connection);
                   break;
               case EDIT_BOOK_CONTACT:
                   addressBook.addDetailsContact(connection);
                   addressBook.displayBookType(connection);
                   addressBook.editContact(connection);
                   break;
               case DELETE:
                   addressBook.addDetailsContact(connection);
                   addressBook.displayBookType(connection);
                   addressBook.deleteContact(connection);
                   break;
           }
        }
    }
}
