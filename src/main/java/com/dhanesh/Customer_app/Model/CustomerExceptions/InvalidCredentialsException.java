package com.dhanesh.Customer_app.Model.CustomerExceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(){
        super();
    }

    public InvalidCredentialsException(String message){
        super(message);
    }
}
