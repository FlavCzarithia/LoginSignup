package com.example.loginsignup;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvCompProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvCompProfile = findViewById(R.id.tvCompProfile);

        // Retrieve the data passed from SignupActivity
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String email = getIntent().getStringExtra("email");
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String mobileNo = getIntent().getStringExtra("mobileNo");
        String gender = getIntent().getStringExtra("gender");

        // Display the user's profile
        String profile = "Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Username: " + username + "\n" +
                "Password: " + password + "\n" +
                "Retype Password: " + password + "\n" +
                "Gender: " + gender + "\n" +
                "Mobile No: " + mobileNo;

        tvCompProfile.setText(profile);
    }
}