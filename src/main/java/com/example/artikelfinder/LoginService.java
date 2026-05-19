package com.example.artikelfinder;

public class LoginService {
    public static boolean checkLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        if (username.equals("") || password.equals("")) {
            return false;
        }
        return true;
    }

}
