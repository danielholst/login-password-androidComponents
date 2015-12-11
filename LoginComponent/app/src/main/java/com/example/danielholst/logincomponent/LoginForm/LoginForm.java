package com.example.danielholst.logincomponent.LoginForm;

import android.content.Context;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.danielholst.logincomponent.R;


/**
 * Created by danielholst on 15-12-08.
 */
public class LoginForm extends RelativeLayout {

    private boolean includePassword;

    public LoginForm(Context context, boolean incPass) {
        super(context);
        includePassword = incPass;

        createForm();
    }

    //create all fields in the login form
    private void createForm() {

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
        firstNameParams.setMargins(10, 10, 10, 10);

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
        lastNameParams.setMargins(10, 10, 10, 10);

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
        emailParams.setMargins(10, 10, 10, 10);

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

        int lastId = emailText.getId();

        //if password field is desired
        if(includePassword) {
            PasswordForm passwordForm = new PasswordForm(getContext());
            passwordForm.setId(11);
            RelativeLayout.LayoutParams passwordFormParams =
                    new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.MATCH_PARENT,
                            200);

            passwordFormParams.addRule(RelativeLayout.BELOW, emailText.getId());

            this.addView(passwordForm, passwordFormParams);

            lastId = passwordForm.getId();
        }

        //checkbox
        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setId(12);

        RelativeLayout.LayoutParams checkboxParams =
                new RelativeLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);

        checkboxParams.addRule(RelativeLayout.BELOW, lastId);
        checkboxParams.setMargins(10, 10, 0, 0);

        //checkbox text
        TextView checkboxText = new TextView(getContext());
        checkboxText.setText("I approve the terms of use");
        checkboxText.setTextSize(20);

        RelativeLayout.LayoutParams checkboxTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        checkboxTextParams.addRule(RelativeLayout.BELOW, lastId);
        checkboxTextParams.addRule(RelativeLayout.RIGHT_OF, checkBox.getId());
        checkboxTextParams.setMargins(10, 10, 0, 0);

        //Sign up button
        Button button = new Button(getContext());
        button.setText("Sign up");
        button.setTextSize(30);
        button.setBackgroundColor(getResources().getColor(R.color.colorButton));

        //set clickable when all fields are entered
        button.setClickable(false);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.BELOW, checkBox.getId());
        buttonParams.addRule(RelativeLayout.ALIGN_LEFT, checkBox.getId());
        buttonParams.addRule(RelativeLayout.ALIGN_RIGHT, emailTextField.getId());
        buttonParams.setMargins(0, 20, 0, 0);

        //add components to view
        this.addView(signUpText, signUpParams);
        this.addView(firstNameText, firstNameParams);
        this.addView(lastNameText, lastNameParams);
        this.addView(lastNameField, lastNameFieldParams);
        this.addView(emailText, emailParams);
        this.addView(emailTextField, emailFieldParams);
        this.addView(checkBox, checkboxParams);
        this.addView(checkboxText, checkboxTextParams);
        this.addView(button, buttonParams);
        this.addView(firstNameField, firstNameFieldParams);

    }
}
