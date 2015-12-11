package com.example.danielholst.logincomponent.LoginForm;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.danielholst.logincomponent.R;

import java.util.Arrays;
import java.util.logging.Handler;

/**
 * Created by danielholst on 15-12-08.
 */
public class PasswordForm extends RelativeLayout {

    private int strength = 0;
    private String password;
    public PasswordForm(Context context) {
        super(context);

        //second argument should be 0, 1 or 2 depending on the strength of the password
        final PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter(getContext(), strength);

        TextView passwordText = new TextView(getContext());
        passwordText.setText("Password");
        passwordText.setId(8);
        passwordText.setTextSize(25);

        RelativeLayout.LayoutParams passwordFormParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        passwordFormParams.setMargins(60, 40, 40, 0);

        this.addView(passwordText, passwordFormParams);

        EditText passwordField = new EditText(getContext());
        //passwordField.setText("");
        //passwordField.setHint("Password");
        passwordField.setId(9);
        passwordField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordField.setWidth(200);
        passwordField.setBackgroundColor(getResources().getColor(R.color.colorTextField));
        passwordField.setTextSize(20);

        RelativeLayout.LayoutParams passwordFieldParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        passwordFieldParams.addRule(RelativeLayout.BELOW, passwordText.getId());
        passwordFieldParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        passwordFieldParams.setMargins(20, 10, 40, 10);

        this.addView(passwordField, passwordFieldParams);

        passwordField.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                password = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                strength = getStrengthOfPassword(s.toString());
                passwordStrengthMeter.updatePasswordStrength(strength);
            }
        });

        passwordStrengthMeter.setId(10);
        RelativeLayout.LayoutParams passwordStrengthMeterParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        passwordStrengthMeterParams.addRule(RelativeLayout.RIGHT_OF, passwordField.getId());
        passwordStrengthMeterParams.setMargins(10, 30, 0, 10);

        this.addView(passwordStrengthMeter, passwordStrengthMeterParams);
    }

    //algorithm to decide the strength of the password
    public int getStrengthOfPassword(String password) {

        Boolean[] checkedConditions = new Boolean[6];
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

    public int getStrength() {
        return strength;
    }

    public String getPassword() {
        return password;
    }
}
