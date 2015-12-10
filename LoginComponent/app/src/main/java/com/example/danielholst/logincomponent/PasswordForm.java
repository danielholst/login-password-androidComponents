package com.example.danielholst.logincomponent;

import android.content.Context;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by danielholst on 15-12-08.
 */
public class PasswordForm extends RelativeLayout {
    public PasswordForm(Context context) {
        super(context);

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
        passwordField.setText("");
        passwordField.setId(9);
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

        //TODO create on textChangeListener for passwordField text and pass to getStrengthOfPassword

        //int strength = getStrengthOfPassword(passwordField.getText().toString());

        //second argument should be 0, 1 or 2 depending on the strength of the password
        PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter(getContext(), 0);
        passwordStrengthMeter.setId(10);
        RelativeLayout.LayoutParams passwordStrengthMeterParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        passwordStrengthMeterParams.addRule(RelativeLayout.RIGHT_OF, passwordField.getId());
        passwordStrengthMeterParams.addRule(RelativeLayout.ALIGN_TOP, passwordText.getId());
        passwordStrengthMeterParams.setMargins(10, 0, 0, 10);

        this.addView(passwordStrengthMeter, passwordStrengthMeterParams);


    }

    //algorithm to decide the strength of the password
    public int getStrengthOfPassword(String password) {

        return 0;
    }
}
