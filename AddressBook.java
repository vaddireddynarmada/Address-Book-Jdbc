package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    public void addContactDataBase(Connection connection) throws SQLException {
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
    public void addDetailsContact(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from AddressBook");
        while (resultSet.next()) {
            Contacts contact = new Contacts();
            contact.setID(resultSet.getInt("id"));
            contact.setFIRST_NAME(resultSet.getString("FirstName"));
            contact.setLAST_NAME(resultSet.getString("LastName"));
            contact.setADDRESS(resultSet.getString("Address"));
            contact.setCITY(resultSet.getString("City"));
            contact.setSTATE(resultSet.getString("State"));
            contact.setZip(resultSet.getInt("ZipCode"));
            contact.setEMAIL_ID(resultSet.getString("Email"));
            contact.setPHONE_NUMBER(resultSet.getDouble("PhoneNumber"));
            contact.setBOOK_NAME(resultSet.getString("BookName"));
            contact.setBOOK_TYPE(resultSet.getString("BookType"));
            System.out.println(contact);
        }
    }
    public void countCity(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from AddressBook group by city");
    while (resultSet.next()){
        int count = resultSet.getInt(1);
        System.out.println(count);
    }
    }
}


