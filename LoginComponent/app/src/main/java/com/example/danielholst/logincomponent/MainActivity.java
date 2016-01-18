package com.example.danielholst.logincomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.danielholst.logincomponent.PasswordForm.PasswordAlgorithm;
import com.example.danielholst.logincomponent.PasswordForm.PasswordForm;
import com.example.danielholst.logincomponent.PasswordForm.PasswordInterface;
import com.example.danielholst.logincomponent.SignupForm.SignupForm;
import com.example.danielholst.logincomponent.PasswordForm.PasswordStrengthMeter;


/**
* Test program to test the component SignupForm
 *
 * This component let you create your own sign up form with the desired fields
 *
 * To use it you simple create a default signupForm and then add a header using createHeaderText
 *
 * Then you add the desired fields, checkboxes and buttons using the functions createField, createCheckbox and createButton
 *
*/

/**
 * Test program to test the components passwordForm, passwordStrengthMeter and passwordAlgorithm
 *
 * This component creates a passwordForm with a strengthMeter
 *
 * First create the desired passwordStrengthMeter and passwordAlgorithm
 *
 * Then create the passwordForm by passing these as arguments
 *
 */


public class MainActivity extends AppCompatActivity {

    SignupForm signupForm;
    PasswordForm passwordForm;
    PasswordStrengthMeter passwordStrengthMeter;
    PasswordAlgorithm passwordAlgorithm;
    MyPasswordStrengthMeter myPasswordStrengthMeter;

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);

        //create sign up form with password field
        signupForm = new SignupForm(this);

        //Add different fields
        signupForm.createHeaderText("Sign up");

        signupForm.createField("First name:", false);

        signupForm.createField("Last name:", false);

        signupForm.createField("Email address:", false);

        signupForm.createField("password", true);

        /*
        //create password strength meter
        passwordStrengthMeter = new PasswordStrengthMeter(this);

        //create password algorithm
        passwordAlgorithm = new PasswordAlgorithm();

        //create password form with password strength meter and password algorithm
        passwordForm = new PasswordForm(this, passwordStrengthMeter, passwordAlgorithm);

        //change header text for password form
        passwordForm.setHeaderText("Password");

        signupForm.createPasswordForm(passwordForm);



        signupForm.createCheckbox("I accept the terms of use");

        signupForm.createButton("Sign up");

        RelativeLayout.LayoutParams loginParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        myLayout.addView(signupForm, loginParams);


        setContentView(myLayout);
    }

*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        RelativeLayout myLayout = new RelativeLayout(this);

        //create password strength meter
        passwordStrengthMeter = new PasswordStrengthMeter(this);

        //create password algorithm
        passwordAlgorithm = new PasswordAlgorithm();

        //create password form with password strength meter and password algorithm
        passwordForm = new PasswordForm(this, passwordStrengthMeter, passwordAlgorithm);

        //change header text for password form
        passwordForm.setHeaderText("Password");

        //get feedback when password is strong enough
        passwordForm.setPasswordInterface(new PasswordInterface() {
            @Override
            public void passwordUpdate(int level) {

                if(level > 4)
                    System.out.println("password is strong enough");
            }
        });

        myLayout.addView(passwordForm);

        setContentView(myLayout);
    }

}
