package com.example.danielholst.logincomponent.SignupForm;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.danielholst.logincomponent.R;

import java.util.Arrays;


/**
 * Created by danielholst on 15-12-08.
 */


/**
 * Class to create a sign up form
 */
public class SignupForm extends RelativeLayout {

    private boolean includePassword;
    private int fields;
    final boolean[] formCheckedFields;
    private PasswordForm passwordForm;
    private int nrOfFields;

    public SignupForm(Context context) {
        super(context);
        includePassword = false;
        fields = 4;
        formCheckedFields = new boolean[fields];
        nrOfFields = 0;

        //passwordForm = new PasswordForm(context);

        //createForm();
    }

    /*
    public SignupForm(Context context, PasswordForm passForm) {
        super(context);

        includePassword = true;
        fields = 5;
        nrOfFields = 0;
        formCheckedFields = new boolean[fields];

        passwordForm = passForm;

        //createForm();
    }
*/

    public void createHeaderText(String text) {

        TextView headerText = new TextView(getContext());
        headerText.setText(text);
        headerText.setId(1);
        headerText.setTextSize(40);

        RelativeLayout.LayoutParams headerParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        headerParams.addRule(RelativeLayout.ALIGN_LEFT);
        headerParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        headerParams.setMargins(10, 10, 10, 10);

        this.addView(headerText, headerParams);
    }

    public void createField(String fieldText) {

        TextView text = new TextView(getContext());
        text.setText(fieldText);
        text.setId(20 + nrOfFields);
        text.setTextSize(20);

        nrOfFields++;

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        if(nrOfFields == 1) {
            textParams.addRule(RelativeLayout.ALIGN_LEFT);
            textParams.addRule(RelativeLayout.BELOW, 1 );
            textParams.setMargins(10, 10, 10, 10);
        }
        else {
            textParams.addRule(RelativeLayout.ALIGN_LEFT);
            textParams.addRule(RelativeLayout.BELOW, (18 + nrOfFields) );
            textParams.setMargins(10, 30, 10, 10);
        }

        this.addView(text, textParams);

        EditText textField = new EditText(getContext());
        textField.setId(20 + nrOfFields);
        textField.setWidth(200);
        textField.setBackgroundColor(getResources().getColor(R.color.colorTextField));
        textField.setTextSize(20);

        nrOfFields++;
        System.out.println(nrOfFields);

        RelativeLayout.LayoutParams textFieldParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        if(nrOfFields == 2) {
            textFieldParams.addRule(RelativeLayout.RIGHT_OF, text.getId());
            textFieldParams.addRule(RelativeLayout.BELOW, 1 );
            textFieldParams.setMargins(10, 0, 10, 10);
        }
        else {
            textFieldParams.addRule(RelativeLayout.RIGHT_OF, text.getId());
            textFieldParams.addRule(RelativeLayout.BELOW, (17 + nrOfFields) );
            textFieldParams.setMargins(10, 20, 10, 10);
        }

        this.addView(textField, textFieldParams);
    }

    public void createCheckbox(String text) {

        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setId(20 + nrOfFields);

        RelativeLayout.LayoutParams checkboxParams =
                new RelativeLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);

        checkboxParams.addRule(RelativeLayout.BELOW, 19 + nrOfFields);
        checkboxParams.setMargins(10, 10, 0, 0);
        nrOfFields++;

        //checkbox text
        TextView checkboxText = new TextView(getContext());
        checkboxText.setText(text);
        checkboxText.setTextSize(20);

        RelativeLayout.LayoutParams checkboxTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        checkboxTextParams.addRule(RelativeLayout.BELOW, 18 + nrOfFields);
        checkboxTextParams.addRule(RelativeLayout.RIGHT_OF, checkBox.getId());
        checkboxTextParams.setMargins(10, 10, 0, 0);

        this.addView(checkBox, checkboxParams);
        this.addView(checkboxText, checkboxTextParams);
    }


    public void createPasswordForm(PasswordForm form) {
        passwordForm = form;
        passwordForm.setId(20 + nrOfFields);
        RelativeLayout.LayoutParams passwordFormParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        200);

        passwordFormParams.addRule(RelativeLayout.BELOW, 19 + nrOfFields);

        nrOfFields++;

        this.addView(passwordForm, passwordFormParams);
    }

    //create all fields in the login form
    private void createForm() {

        //check to see that all fields are entered before sign up button can be presses
        //final boolean[] formCheckedFields = new boolean[fields];
        Arrays.fill(formCheckedFields, false);

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
        final EditText emailTextField = new EditText(getContext());
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
        final EditText lastNameField = new EditText(getContext());
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
        final EditText firstNameField = new EditText(getContext());
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


        if(includePassword) {
            //passwordForm = new PasswordForm(getContext());
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
        final Button button = new Button(getContext());
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

        firstNameField.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if (s.length() > 1)
                    formCheckedFields[0] = true;
                else
                    formCheckedFields[0] = false;

                if (validateCheckedFields()) {
                    button.setClickable(true);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButtonClickable));
                } else {
                    button.setClickable(false);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButton));
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

        lastNameField.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if (s.length() > 1)
                    formCheckedFields[1] = true;
                else
                    formCheckedFields[1] = false;

                if (validateCheckedFields()) {
                    button.setClickable(true);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButtonClickable));
                } else {
                    button.setClickable(false);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButton));
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

        emailTextField.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if (s.length() > 1)
                    formCheckedFields[2] = true;
                else
                    formCheckedFields[2] = false;

                if (validateCheckedFields()) {
                    button.setClickable(true);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButtonClickable));
                } else {
                    button.setClickable(false);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButton));
                }
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

        final PasswordForm finalPasswordForm = passwordForm;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    formCheckedFields[3] = true;

                    if(includePassword && finalPasswordForm.getStrength() > 4)
                        formCheckedFields[4] = true;
                    else
                        formCheckedFields[4] = false;
                }
                if(!isChecked) {
                    formCheckedFields[3] = false;
                }
                if(validateCheckedFields()) {
                    button.setClickable(true);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButtonClickable));
                }
                else {
                    button.setClickable(false);
                    button.setBackgroundColor(getResources().getColor(R.color.colorButton));
                }
            }
        });

        //click sign in button
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundColor(getResources().getColor(R.color.colorCircleGreenLit));
                System.out.println (  "New user! \nName: " + firstNameField.getText().toString() + " " + lastNameField.getText().toString()
                                    + "\nEmail: " + emailTextField.getText().toString()
                                    + "\nPassword: " + finalPasswordForm.getPassword());

            }
        });
    }

    //TODO fix update from when password field is changed in this class
    public void setPasswordField(boolean b) {
        formCheckedFields[4] = b;
        validateCheckedFields();
    }

    public boolean validateCheckedFields() {

        int counter = 0;

        for(int i = 0; i < formCheckedFields.length; i++) {
            if(formCheckedFields[i] == true)
                counter++;
        }

        if(counter == 5)
            return true;
        else
            return false;
    }
}
