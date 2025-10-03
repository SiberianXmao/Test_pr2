package com.training;


import com.training.passwordGenerator.PasswordGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("world");
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String pass = passwordGenerator.generatePassword(8,true,true);
        System.out.println(pass);
        System.out.println(passwordGenerator.isStrongPassword(pass));

    }
}