package org.example;

import java.sql.*;
import java.util.Scanner;

public class AddressBook {
    public static final int FIRSTNAME = 1;
    public static final int LASTNAME = 2;
    public static final int ADDRESS = 3;
    public static final int CITY = 4;
    public static final int STATE = 5;
    public static final int ZIP = 6;
    public static final int PHONE_NUMBER = 7;
    public static final int EMAIL_ID = 8;
    public static final int EXIT = 9;

    public void createNewTable(Connection connection, String query) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Table already exists");
        }

    }

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
        while (resultSet.next()) {
            int count = resultSet.getInt(1);
            System.out.println(count);
        }
    }

    public void displayBookType(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("SELECT BookType FROM AddressBook GROUP BY BookType");
        System.out.println("BookType Names :");
        while (resultSet1.next()) {
            System.out.print(resultSet1.getString("BookType") + "  ");
        }
        System.out.println();
    }

    public void displayBookContact(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from AddressBook");
        System.out.println("Enter bookType :");
        String bookType = scanner.next();
        while (resultSet.next()) {
            if (resultSet.getString("BookType").equals(bookType)) {
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
    }

    public void deleteContact(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter firstname to delete ");
        String firstname = scanner.next();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from AddressBook where firstName=?");
        preparedStatement.setString(1, firstname);
        preparedStatement.executeUpdate();
    }

    public void editContact(Connection connection) throws SQLException {
        Scanner sc = new Scanner(System.in);
        PreparedStatement preparedStatement;
        System.out.println("Enter bookType to Edit :  ");
        String bookType = sc.next();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from AddressBook");
        boolean condition = true;
        while (condition) {
            while (resultSet.next()) {
                if (resultSet.getString("BookType").equals(bookType)) {
                    System.out.println("enter which details wants to edit in contact");
                    System.out.println("1.firstName, 2.lastName, 3.address, 4.city, 5.state, 6.zip,7.phoneNumber, 8.emailId, 9.exit");
                    int editDetails = sc.nextInt();
                    switch (editDetails) {
                        case FIRSTNAME:
                            preparedStatement = connection.prepareStatement("update AddressBook set FirstName=? where id=?");
                            System.out.println("Enter Id");
                            String firstnameId = sc.next();
                            System.out.println("Enter firstname");
                            String firstname = sc.next();
                            preparedStatement.setString(1, firstname);
                            preparedStatement.setString(2, firstnameId);
                            preparedStatement.executeUpdate();
                            break;
                        case LASTNAME:
                            preparedStatement = connection.prepareStatement("update AddressBook set LastName=? where id=?");
                            System.out.println("Enter Existing FirstName");
                            int lastNameId = sc.nextInt();
                            System.out.println("Enter LastName");
                            String LastName = sc.next();
                            preparedStatement.setString(1, LastName);
                            preparedStatement.setInt(2, lastNameId);
                            preparedStatement.executeUpdate();
                            break;
                        case ADDRESS:
                            preparedStatement = connection.prepareStatement("update AddressBook set Address=? where id=?");
                            System.out.println("Enter Existing FirstName");
                            String addressId = sc.next();
                            System.out.println("Enter Address");
                            String Address = sc.next();
                            preparedStatement.setString(1, Address);
                            preparedStatement.setString(3, addressId);
                            preparedStatement.executeUpdate();
                            break;
                        case CITY:
                            preparedStatement = connection.prepareStatement("update AddressBook set City=?where id=?");
                            System.out.println("Enter Existing FirstName");
                            String cityId = sc.next();
                            System.out.println("Enter City");
                            String City = sc.next();
                            preparedStatement.setString(1, City);
                            preparedStatement.setString(2, cityId);
                            preparedStatement.executeUpdate();
                            break;
                        case STATE:
                            preparedStatement = connection.prepareStatement("update AddressBook set State=? where id=?");
                            System.out.println("Enter Existing FirstName");
                            int stateId = sc.nextInt();
                            System.out.println("Enter State");
                            String State = sc.next();
                            preparedStatement.setString(1, State);
                            preparedStatement.setInt(2, stateId);
                            preparedStatement.executeUpdate();
                            break;
                        case EMAIL_ID:
                            preparedStatement = connection.prepareStatement("update AddressBook set Email=?where id=?");
                            System.out.println("Enter Id to edit");
                            int emailId = sc.nextInt();
                            System.out.println("Enter Email");
                            String Email = sc.next();
                            preparedStatement.setString(1, Email);
                            preparedStatement.setInt(2, emailId);
                            preparedStatement.executeUpdate();
                            break;
                        case ZIP:
                            preparedStatement = connection.prepareStatement("update AddressBook set ZipCode=?where id=?");
                            System.out.println("Enter Id to edit");
                            int zipId = sc.nextInt();
                            System.out.println("Enter ZipCode");
                            int ZipCode = sc.nextInt();
                            preparedStatement.setInt(1, ZipCode);
                            preparedStatement.setInt(2, zipId);
                            preparedStatement.executeUpdate();
                            break;
                        case PHONE_NUMBER:
                            preparedStatement = connection.prepareStatement("update AddressBookSystem set PhoneNumber=?where id=?");
                            System.out.println("Enter Id to edit");
                            int phoneNumberId = sc.nextInt();
                            System.out.println("Enter phoneNumber");
                            double PhoneNumber = sc.nextDouble();
                            preparedStatement.setDouble(1, PhoneNumber);
                            preparedStatement.setDouble(2, phoneNumberId);
                            preparedStatement.executeUpdate();
                            break;
                        case EXIT:
                            condition = false;
                            break;
                    }
                    break;
                }
            }
        }
    }
}

