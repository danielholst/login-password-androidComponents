package com.example.danielholst.logincomponent.SignupForm;

import java.util.Arrays;

/**
 * Created by danielholst on 15-12-15.
 */
public class PasswordAlgorithm {

    Boolean[] checkedConditions;

    public PasswordAlgorithm() {}

    public int getStrength(String password) {

        checkedConditions = new Boolean[6];
        Arrays.fill(checkedConditions, false);

        //if more then 6 letters in password
        if(password.length() >= 6)
            checkedConditions[0] = true;

        //if more then 12 letters in password
        if(password.length() >= 12)
            checkedConditions[1] = true;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            //if a number in password
            if(Character.isDigit(c))
                checkedConditions[2] = true;

                //if a capital letter in password
            else if(Character.isUpperCase(c))
                checkedConditions[3] = true;

                //if a lower letter in password
            else if(Character.isLowerCase(c))
                checkedConditions[4] = true;

                //if special sign in password
            else
                checkedConditions[5] = true;
        }

        //check how many conditions is true
        int counter = 0;
        for(int i = 0; i < checkedConditions.length; i++) {
            if(checkedConditions[i] == true)
                counter++;
        }


        return counter;
    }
}
