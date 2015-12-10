package com.example.danielholst.logincomponent;

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

        //pass true as second argument to include password form
        loginForm = new LoginForm(this, true);
        RelativeLayout.LayoutParams loginParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        myLayout.addView(loginForm, loginParams);

        setContentView(myLayout);
    }
}
