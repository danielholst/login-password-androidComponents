package com.example.danielholst.logincomponent;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    LoginForm loginForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        RelativeLayout myLayout = new RelativeLayout(this);

        loginForm = new LoginForm(this);
        RelativeLayout.LayoutParams loginParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        myLayout.addView(loginForm, loginParams);

        setContentView(myLayout);
    }
}
