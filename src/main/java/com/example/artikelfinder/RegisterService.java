package com.example.artikelfinder;

public class RegisterService {
    public static String checkEmail(String E,String Ce){
        String regexEmail =
                               "^(?=.{1,254}$)(?=.{1,64}@)[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(\\." +
                                       "[A-Za-z0-9!#$%&'*+/=?^_`{|}" +
                               "~-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$";

        if(E.matches(regexEmail) && E.equals(Ce)){

            return E;
        }
        return "INVALID EMAIL";

    }
    public static String checkPassword(String P ,String Cp){
        String passwordRegex =
                                "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";

        if (P.matches(passwordRegex)&& P.equals(Cp)){
            return P;
        }
        return "INVALID PASSWORD FORMAT";


    }
}
