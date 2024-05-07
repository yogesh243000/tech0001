package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class RegistrationaPage extends AppCompatActivity {
    Button button;
    EditText etFirstName, etLastName, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        button = findViewById(R.id.btnRegister);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // Proceed with registration
                    Intent intent = new Intent(RegistrationaPage.this, HomePage.class);
                    startActivity(intent);
                }
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

    private boolean validateInputs() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)) {
            etFirstName.setError("Please enter your first name");
            return false;
        }

        if (TextUtils.isEmpty(lastName)) {
            etLastName.setError("Please enter your last name");
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter your email address");
            return false;
        } else if (!isValidEmail(email)) {
            etEmail.setError("Please enter a valid email address");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Please enter a password");
            return false;
        } else if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters long");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        // Regular expression for validating email addresses
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
        return pattern.matcher(email).matches();
    }
}
