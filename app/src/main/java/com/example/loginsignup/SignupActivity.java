package com.example.loginsignup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

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
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(SignupActivity.this, "Enter a valid email", Toast.LENGTH_SHORT).show();
            return;
            }
            if (!android.util.Patterns.PHONE.matcher(mobileNo).matches()) {
                Toast.makeText(SignupActivity.this, "Enter a valid mobile number", Toast.LENGTH_SHORT).show();
                return;
            }
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() ||
                    password.isEmpty() || retypePassword.isEmpty() || gender.isEmpty() || mobileNo.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.equals(retypePassword)) {
                Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
                Toast.makeText(SignupActivity.this, "Password must contain at least 8 characters, including uppercase, lowercase, digit, and a special character", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("firstName", firstName);
            editor.putString("lastName", lastName);
            editor.putString("email", email);
            editor.putString("username", username);
            editor.putString("password", password);
            editor.putString("gender", gender);
            editor.putString("mobileNo", mobileNo);
            editor.apply();
            Toast.makeText(SignupActivity.this, "Signup Success", Toast.LENGTH_SHORT).show();
            Intent loginIntent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });
    }
}
