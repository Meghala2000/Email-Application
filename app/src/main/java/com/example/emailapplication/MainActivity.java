package com.example.emailapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    EditText textTo, textSubject, textBody;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBody = findViewById(R.id.m_msg);
        textSubject = findViewById(R.id.m_subject);
        textTo = findViewById(R.id.m_receiver);
        buttonSend = findViewById(R.id.m_send);

        buttonSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String receiver_lists = textTo.getText().toString();
                String[] my_receivers = receiver_lists.split(",");

                String subject = textSubject.getText().toString();
                String message = textBody.getText().toString();

                Intent my_intent = new Intent(Intent.ACTION_SEND);
                my_intent.putExtra(Intent.EXTRA_EMAIL, my_receivers);
                my_intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                my_intent.putExtra(Intent.EXTRA_TEXT, message);

                my_intent.setType("message/rfc822");
                startActivity(Intent.createChooser(my_intent, "Choose an email client"));


            }
        });


    }
}