package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationaPage extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        button = (Button) findViewById(R.id.btnRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationaPage.this, HomePage.class);
                startActivity(intent);
            }
        });
        SpannableString spannableString = new SpannableString("Already have an account? Login");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // Handle the click event here to navigate to the login page
                Intent intent = new Intent(RegistrationaPage.this, LoginPage.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true); // Make the text underline
            }
        };

// Set the clickable span for the "Login" text
        spannableString.setSpan(clickableSpan, spannableString.length() - "Login".length(), spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = findViewById(R.id.textView);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance()); // Make the text clickable



    }
}

