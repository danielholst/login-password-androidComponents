package com.example.danielholst.logincomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.danielholst.logincomponent.PasswordForm.PasswordAlgorithm;
import com.example.danielholst.logincomponent.PasswordForm.PasswordForm;
import com.example.danielholst.logincomponent.SignupForm.SignupForm;
import com.example.danielholst.logincomponent.PasswordForm.PasswordStrengthMeter;


/*
* Test program to test the components SignupForm, PasswordForm, PasswordStrengthMeter and PasswordAlgorithm
*/

public class MainActivity extends AppCompatActivity {

    SignupForm signupForm;
    PasswordForm passwordForm;
    PasswordStrengthMeter passwordStrengthMeter;
    PasswordAlgorithm passwordAlgorithm;
    MyPasswordStrengthMeter myPasswordStrengthMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);

        //create password strength meter
        passwordStrengthMeter = new PasswordStrengthMeter(this);

        //create my password strength meter extends from PasswordStrengthMeter
        //myPasswordStrengthMeter = new MyPasswordStrengthMeter(this);

        //create password algorithm
        passwordAlgorithm = new PasswordAlgorithm();

        //create password form with password strength meter and password algorithm
        passwordForm = new PasswordForm(this, passwordStrengthMeter, passwordAlgorithm);

        //change header text for password form
        passwordForm.setHeaderText("lösenord");

        //create sign up form with password field
        signupForm = new SignupForm(this);

        //Add different fields
        signupForm.createHeaderText("Sign up");

        signupForm.createField("First name:");

        signupForm.createField("Last name:" );

        signupForm.createField("Email address:");

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
}
