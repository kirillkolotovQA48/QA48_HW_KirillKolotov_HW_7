package com.qa48.hw7.models;

public class HW_7_RegistForm {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String password;
    private static String confirmPassword;

    public static String getConfirmPassword() {
        return confirmPassword;
    }

    public HW_7_RegistForm setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return  this;
    }

    public static String getEmail() {
        return email;
    }

    public HW_7_RegistForm setEmail(String email) {
        this.email = email;
        return  this;
    }

    public static String getFirstName() {
        return firstName;
    }

    public HW_7_RegistForm setFirstName(String firstName) {
        this.firstName = firstName;
        return  this;
    }

    public static String getLastName() {
        return lastName;
    }

    public HW_7_RegistForm setLastName(String lastName) {
        this.lastName = lastName;
        return  this;
    }

    public static String getPassword() {
        return password;
    }

    public HW_7_RegistForm setPassword(String password) {
        this.password = password;
        return  this;
    }
}