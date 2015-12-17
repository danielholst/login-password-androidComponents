package com.example.danielholst.logincomponent.SignupForm;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.danielholst.logincomponent.R;

import java.util.Arrays;

/**
 * Created by danielholst on 15-12-08.
 */
public class PasswordForm extends RelativeLayout {

    private PasswordStrengthMeter passwordStrengthMeter;
    private PasswordAlgorithm passwordAlgorithm;
    private int strength = 0;
    private String password;

    public PasswordForm(Context context) {
        super(context);
        passwordAlgorithm = new PasswordAlgorithm();
        passwordStrengthMeter = new PasswordStrengthMeter(context);

        createPasswordForm();
    }

    public PasswordForm(Context context, PasswordAlgorithm algorithm) {
        super(context);
        passwordAlgorithm = algorithm;
        passwordStrengthMeter = new PasswordStrengthMeter(context);

        createPasswordForm();
    }

    public PasswordForm(Context context, PasswordStrengthMeter strengthMeter) {
        super(context);
        passwordAlgorithm = new PasswordAlgorithm();
        passwordStrengthMeter = strengthMeter;

        createPasswordForm();
    }

    public PasswordForm(Context context, PasswordStrengthMeter strengthMeter, PasswordAlgorithm algorithm) {
        super(context);
        passwordStrengthMeter = strengthMeter;
        passwordAlgorithm = algorithm;

        createPasswordForm();
    }

    public void createPasswordForm() {

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
                strength = passwordAlgorithm.getStrength(s.toString());
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


    public int getStrength() {

        return strength;
    }

    public String getPassword() {

        return password;
    }
}
