package com.example.danielholst.logincomponent.PasswordForm;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.danielholst.logincomponent.R;

/**
 * Class to create a password form
 */

public class PasswordForm extends RelativeLayout {

    private TextView passwordText;
    private PasswordStrengthMeter passwordStrengthMeter;
    private PasswordAlgorithm passwordAlgorithm;
    private int strength = 0;
    private String password;
    private String[] hint = new String[] {" ", "very weak", "weak", "normal", "strong", "very strong", "super strong"};

    /** default constructor */
    public PasswordForm(Context context) {
        super(context);
        passwordAlgorithm = new PasswordAlgorithm();
        passwordStrengthMeter = new PasswordStrengthMeter(context);
       // hint = new String[] {"to short", "very weak", "weak", "strong", "very strong", "super strong"};

        createPasswordForm();
    }

    /** constructor with specified algorithm */
    public PasswordForm(Context context, PasswordAlgorithm algorithm) {
        super(context);
        passwordAlgorithm = algorithm;
        passwordStrengthMeter = new PasswordStrengthMeter(context);

        createPasswordForm();
    }

    /** constructor with specified gui meter */
    public PasswordForm(Context context, PasswordStrengthMeter strengthMeter) {
        super(context);
        passwordAlgorithm = new PasswordAlgorithm();
        passwordStrengthMeter = strengthMeter;

        createPasswordForm();
    }

    /** constructor with specified gui meter and algorithm */
    public PasswordForm(Context context, PasswordStrengthMeter strengthMeter, PasswordAlgorithm algorithm) {
        super(context);
        passwordStrengthMeter = strengthMeter;
        passwordAlgorithm = algorithm;

        createPasswordForm();
    }

    /** function to create the form */
    public void createPasswordForm() {

        passwordText = new TextView(getContext());
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

        final TextView passwordHelpText = new TextView(getContext());
        passwordHelpText.setText(hint[0]);
        passwordHelpText.setId(10);
        passwordHelpText.setTextSize(22);
        passwordHelpText.setTextColor(Color.LTGRAY);

        RelativeLayout.LayoutParams passwordHelpTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        passwordHelpTextParams.setMargins(20, 0, 40, 0);

        passwordHelpTextParams.addRule(RelativeLayout.BELOW, passwordField.getId());
        passwordHelpTextParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        this.addView(passwordHelpText, passwordHelpTextParams);

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
                passwordHelpText.setText(hint[getStrength()]);
            }
        });

        passwordStrengthMeter.setId(11);
        RelativeLayout.LayoutParams passwordStrengthMeterParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        passwordStrengthMeterParams.addRule(RelativeLayout.RIGHT_OF, passwordField.getId());
        passwordStrengthMeterParams.setMargins(10, 30, 0, 10);

        this.addView(passwordStrengthMeter, passwordStrengthMeterParams);

    }

    /** get password strength */
    public int getStrength() {

        return strength;
    }

    /** get password */
    public String getPassword() {

        return password;
    }

    public void setHeaderText(String text) {
        passwordText.setText(text);
    }
}
