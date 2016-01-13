package com.example.danielholst.logincomponent.SignupForm;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.danielholst.logincomponent.PasswordForm.PasswordForm;
import com.example.danielholst.logincomponent.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Class to create a sign up form
 */

public class SignupForm extends RelativeLayout {

    private boolean includePassword;
    private int fields;
    final boolean[] formCheckedFields;
    private PasswordForm passwordForm;
    private int nrOfFields;
    private String[] fieldValues = new String[14];

    /** Constructor */
    public SignupForm(Context context) {
        super(context);
        includePassword = false;
        fields = 4;
        formCheckedFields = new boolean[fields];
        nrOfFields = 0;

        for(int i = 0; i < 14; i++)
            fieldValues[i] = "";
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
    public void createField(String fieldText, boolean passwordField) {

        TextView text = new TextView(getContext());
        text.setText(fieldText);
        text.setId(20 + nrOfFields);
        text.setTextSize(20);

        fieldValues[text.getId() - 20] = fieldText;
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

        final EditText textField = new EditText(getContext());

        if(passwordField == true)
            textField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

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

        textField.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                fieldValues[textField.getId() - 20] = s.toString();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        this.addView(textField, textFieldParams);
    }

    /** creates a text and checkbox in form */
    public void createCheckbox(String text) {

        final CheckBox checkBox = new CheckBox(getContext());
        checkBox.setId(20 + nrOfFields);
        fieldValues[checkBox.getId() - 20] = text;

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
        checkboxText.setId(20 + nrOfFields);
        checkboxText.setTextSize(20);
        nrOfFields++;

        RelativeLayout.LayoutParams checkboxTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        checkboxTextParams.addRule(RelativeLayout.BELOW, 17 + nrOfFields);
        checkboxTextParams.addRule(RelativeLayout.RIGHT_OF, checkBox.getId());
        checkboxTextParams.setMargins(10, 10, 0, 0);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fieldValues[checkBox.getId() - 19] = "true";
                }
                if (!isChecked) {
                    fieldValues[checkBox.getId() - 19] = "false";
                }
            }

        });

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

        buttonParams.addRule(RelativeLayout.BELOW, 18 + nrOfFields);
        buttonParams.addRule(RelativeLayout.ALIGN_LEFT);
        buttonParams.setMargins(0, 20, 0, 0);


        button.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                button.setBackgroundColor(getResources().getColor(R.color.colorCircleGreenLit));
                System.out.println ("button pressed! \nField data... ");
                for(int i = 0; i < 14; i++) {
                    if(fieldValues[i] != "")
                        System.out.println(i + ". " + fieldValues[i] + " " + fieldValues[i +1]);
                    i++;
                }
            }
        });

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
        includePassword = true;

        this.addView(passwordForm, passwordFormParams);
    }

    /** return values of the fields */
    public String[] getFieldValues() {
        return fieldValues;
    }
}
