package com.example.danielholst.logincomponent;

import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by danielholst on 15-12-08.
 */
public class LoginForm extends RelativeLayout {
    public LoginForm(Context context) {
        super(context);

        createTextFields();
    }

    private void createTextFields() {

        //sign up text
        TextView signUpText = new TextView(getContext());
        signUpText.setText("Sign up");
        signUpText.setId(1);
        signUpText.setTextSize(40);

        RelativeLayout.LayoutParams signUpParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        signUpParams.addRule(RelativeLayout.ALIGN_LEFT);
        signUpParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        signUpParams.setMargins(10, 10, 10, 10);

        this.addView(signUpText, signUpParams);

        //first name text
        TextView firstNameText = new TextView(getContext());
        firstNameText.setText("First name:");
        firstNameText.setId(2);
        firstNameText.setTextSize(20);

        RelativeLayout.LayoutParams firstNameParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        firstNameParams.addRule(RelativeLayout.ALIGN_LEFT);
        firstNameParams.addRule(RelativeLayout.BELOW, signUpText.getId());
        firstNameParams.setMargins(10, 10, 10,10);

        this.addView(firstNameText, firstNameParams);

        //last name text
        TextView lastNameText = new TextView(getContext());
        lastNameText.setText("Last name:");
        lastNameText.setId(3);
        lastNameText.setTextSize(20);

        RelativeLayout.LayoutParams lastNameParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        lastNameParams.addRule(RelativeLayout.ALIGN_LEFT);
        lastNameParams.addRule(RelativeLayout.BELOW, firstNameText.getId());
        lastNameParams.setMargins(10,10,10,10);

        this.addView(lastNameText, lastNameParams);

        //email address text
        TextView emailText = new TextView(getContext());
        emailText.setText("Email address:");
        emailText.setId(4);
        emailText.setTextSize(20);

        RelativeLayout.LayoutParams emailParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        emailParams.addRule(RelativeLayout.ALIGN_LEFT);
        emailParams.addRule(RelativeLayout.BELOW, lastNameText.getId());
        emailParams.setMargins(10,10,10,10);

        this.addView(emailText, emailParams);

        //email address text field
        EditText emailTextField = new EditText(getContext());
        emailTextField.setText("");
        emailTextField.setId(5);
        emailTextField.setWidth(200);
        emailTextField.setBackgroundColor(getResources().getColor(R.color.colorTextField));
        emailTextField.setFadingEdgeLength(2);
        emailTextField.setTextSize(20);

        RelativeLayout.LayoutParams emailFieldParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        emailFieldParams.addRule(RelativeLayout.BELOW, lastNameText.getId());
        emailFieldParams.addRule(RelativeLayout.RIGHT_OF, emailText.getId());
        //emailFieldParams.setMargins(10, 10, 10, 10);

        this.addView(emailTextField, emailFieldParams);

        //last name text field
        EditText lastNameField = new EditText(getContext());
        lastNameField.setText("");
        lastNameField.setId(6);
        lastNameField.setWidth(200);
        lastNameField.setBackgroundColor(getResources().getColor(R.color.colorTextField));
        lastNameField.setTextSize(20);

        RelativeLayout.LayoutParams lastNameFieldParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        lastNameFieldParams.addRule(RelativeLayout.BELOW, firstNameText.getId());
        lastNameFieldParams.addRule(RelativeLayout.ALIGN_LEFT, emailTextField.getId());
        lastNameFieldParams.addRule(RelativeLayout.RIGHT_OF, lastNameText.getId());
        //emailFieldParams.setMargins(10, 10, 10, 10);

        this.addView(lastNameField, lastNameFieldParams);

        //first name text field
        EditText firstNameField = new EditText(getContext());
        firstNameField.setText("");
        firstNameField.setId(7);
        firstNameField.setWidth(200);
        firstNameField.setBackgroundColor(getResources().getColor(R.color.colorTextField));
        firstNameField.setTextSize(20);

        RelativeLayout.LayoutParams firstNameFieldParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        firstNameFieldParams.addRule(RelativeLayout.BELOW, signUpText.getId());
        firstNameFieldParams.addRule(RelativeLayout.ALIGN_LEFT, emailTextField.getId());
        firstNameFieldParams.addRule(RelativeLayout.RIGHT_OF, lastNameText.getId());
        //emailFieldParams.setMargins(10, 10, 10, 10);

        this.addView(firstNameField, firstNameFieldParams);

        createPasswordForm(emailText.getId());


    }

    private void createPasswordForm(int id) {

        PasswordForm passwordForm = new PasswordForm(getContext());
        RelativeLayout.LayoutParams passwordFormParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        passwordFormParams.addRule(RelativeLayout.BELOW, id);

        this.addView(passwordForm, passwordFormParams);

    }

}
