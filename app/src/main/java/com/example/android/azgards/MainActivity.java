package com.example.android.azgards;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
    private EditText password;
    private int counter = 5;
    private TextView info;
    private CardView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TypeWritter tw = (TypeWritter) findViewById(R.id.tv4);
        tw.setText("");
        tw.setCharacterDelay(150);
        tw.animateText("And Who Are You? ");

        password = (EditText) findViewById(R.id.editText);
        Login = (CardView) findViewById(R.id.cardview);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(password.getText().toString());
            }
        });
    }

    private void validate (String userPassword){
        if(userPassword.equals("Cathlyn")){
            Intent intent = new Intent(MainActivity.this, MenuUtama.class);
            startActivity(intent);

        } else{
            counter--;
            if(counter==0){
                Login.setEnabled(false);
            }
        }


    }
}
