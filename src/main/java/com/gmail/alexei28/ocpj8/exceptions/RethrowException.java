package com.gmail.alexei28.ocpj8.exceptions;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;


public class RethrowException {

    public static void main(String[] args) throws SQLException, IOException {
        RethrowException rethrowException = new RethrowException();
        rethrowException.rethrowing();
    }

    public void rethrowing() throws IOException, SQLException, DateTimeParseException {
        try {
            parseData();
        } catch (Exception e) {
            System.err.println(e);
            throw e;
        }
    }

    public void parseData() throws SQLException, DateTimeParseException {
        throw new NullPointerException("This is a NullPointerException");
    }
}
