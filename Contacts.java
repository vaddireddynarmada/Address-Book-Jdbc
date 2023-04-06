package org.example;

public class Contacts {
    private String FIRST_NAME;
    private String LAST_NAME;
    private String ADDRESS;
    private String CITY;
    private String STATE;
    private int zip;
    private int PHONE_NUMBER;
    private String EMAIL_ID;
    private String BOOK_NAME;
    private String BOOK_TYPE;

    public Contacts() {

    }

    public Contacts(String FIRST_NAME, String LAST_NAME, String ADDRESS, String CITY, String STATE, int zip,
                    int PHONE_NUMBER, String EMAIL_ID, String BOOK_NAME, String BOOK_TYPE) {
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.ADDRESS = ADDRESS;
        this.CITY = CITY;
        this.STATE = STATE;
        this.zip = zip;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.EMAIL_ID = EMAIL_ID;
        this.BOOK_NAME = BOOK_NAME;
        this.BOOK_TYPE = BOOK_TYPE;
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

    public int getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(int PHONE_NUMBER) {
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
                "FIRST_NAME='" + FIRST_NAME + '\'' +
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

