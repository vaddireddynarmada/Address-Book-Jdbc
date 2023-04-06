package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    List<Contacts> list = new ArrayList<>();

    public void addDetailsDb(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String sql = "insert into AddressBook (FirstName,LastName,Address,City,State,Email,ZipCode,PhoneNumber,BookName,BookType) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("Enter Firstname");
        preparedStatement.setString(1, scanner.nextLine());
        System.out.println("Enter Lastname");
        preparedStatement.setString(2, scanner.nextLine());
        System.out.println("Enter Address");
        preparedStatement.setString(3, scanner.nextLine());
        System.out.println("Enter City");
        preparedStatement.setString(4, scanner.nextLine());
        System.out.println("Enter State");
        preparedStatement.setString(5, scanner.nextLine());
        System.out.println("Enter Email");
        preparedStatement.setString(6, scanner.nextLine());
        System.out.println("Enter Zipcode number");
        preparedStatement.setInt(7, scanner.nextInt());
        System.out.println("Enter PhoneNumber ");
        preparedStatement.setInt(8, scanner.nextInt());
        System.out.println("Enter AddressBook Name");
        preparedStatement.setString(9, scanner.next());
        System.out.println("Enter AddressBook Type");
        preparedStatement.setString(10, scanner.next());
        preparedStatement.executeUpdate();
    }
}
