package com.pedrosantiago.management_vacancies.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User already exists!");
    }
}
