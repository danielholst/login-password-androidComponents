package com.example.danielholst.logincomponent.SignupForm;

import android.content.Context;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.danielholst.logincomponent.PasswordForm.PasswordForm;
import com.example.danielholst.logincomponent.R;


/**
 * Class to create a sign up form
 */

public class SignupForm extends RelativeLayout {

    private boolean includePassword;
    private int fields;
    final boolean[] formCheckedFields;
    private PasswordForm passwordForm;
    private int nrOfFields;

    /** Constructor */
    public SignupForm(Context context) {
        super(context);
        includePassword = false;
        fields = 4;
        formCheckedFields = new boolean[fields];
        nrOfFields = 0;
    }

    /** Creates a header text in form */
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

    /** creates a text and field in form */
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

    /** creates a text and checkbox in form */
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

    /** creates a button in form */
    public void createButton(String text) {

        final Button button = new Button(getContext());
        button.setText(text);
        button.setTextSize(30);
        button.setWidth(350);
        button.setBackgroundColor(getResources().getColor(R.color.colorButton));
        button.setClickable(true);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.BELOW, 19 + nrOfFields);
        buttonParams.addRule(RelativeLayout.ALIGN_LEFT);
        buttonParams.setMargins(0, 20, 0, 0);

        this.addView(button, buttonParams);
    }

    /** adds a password form */
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
}
