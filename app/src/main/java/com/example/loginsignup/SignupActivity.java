package com.example.loginsignup;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class SignupActivity extends AppCompatActivity {

    private EditText etname, etsurname, etemail, etusername, etpassword, etrepassword, etmobnumber, etgender;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etname = findViewById(R.id.etname);
        etsurname = findViewById(R.id.etsurname);
        etemail = findViewById(R.id.etemail);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        etrepassword = findViewById(R.id.etrepassword);
        etgender = findViewById(R.id.etgender);
        etmobnumber = findViewById(R.id.etmobnumber);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(v -> {
            String firstName = etname.getText().toString().trim();
            String lastName = etsurname.getText().toString().trim();
            String email = etemail.getText().toString().trim();
            String username = etusername.getText().toString().trim();
            String password = etpassword.getText().toString().trim();
            String retypePassword = etrepassword.getText().toString().trim();
            String gender = etgender.getText().toString().trim();
            String mobileNo = etmobnumber.getText().toString().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() ||
                    password.isEmpty() || retypePassword.isEmpty() || gender.isEmpty() || mobileNo.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.equals(retypePassword)) {
                Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();

            Intent profileIntent = new Intent(SignupActivity.this, ProfileActivity.class);
            profileIntent.putExtra("firstName", firstName);
            profileIntent.putExtra("lastName", lastName);
            profileIntent.putExtra("email", email);
            profileIntent.putExtra("username", username);
            profileIntent.putExtra("password", password);
            profileIntent.putExtra("gender", gender);
            profileIntent.putExtra("mobileNo", mobileNo);
            startActivity(profileIntent);
        });
    }
}