package org.example;

public class Contacts {
    private int ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String ADDRESS;
    private String CITY;
    private String STATE;
    private int zip;
    private double PHONE_NUMBER;
    private String EMAIL_ID;
    private String BOOK_NAME;
    private String BOOK_TYPE;

    public Contacts() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public double getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(double PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public String getEMAIL_ID() {
        return EMAIL_ID;
    }

    public void setEMAIL_ID(String EMAIL_ID) {
        this.EMAIL_ID = EMAIL_ID;
    }

    public String getBOOK_NAME() {
        return BOOK_NAME;
    }

    public void setBOOK_NAME(String BOOK_NAME) {
        this.BOOK_NAME = BOOK_NAME;
    }

    public String getBOOK_TYPE() {
        return BOOK_TYPE;
    }

    public void setBOOK_TYPE(String BOOK_TYPE) {
        this.BOOK_TYPE = BOOK_TYPE;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "ID=" + ID +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", CITY='" + CITY + '\'' +
                ", STATE='" + STATE + '\'' +
                ", zip=" + zip +
                ", PHONE_NUMBER=" + PHONE_NUMBER +
                ", EMAIL_ID='" + EMAIL_ID + '\'' +
                ", BOOK_NAME='" + BOOK_NAME + '\'' +
                ", BOOK_TYPE='" + BOOK_TYPE + '\'' +
                '}';
    }
}

