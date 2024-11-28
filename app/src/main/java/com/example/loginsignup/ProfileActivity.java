package com.example.loginsignup;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
public class ProfileActivity extends AppCompatActivity {

    private TextView tvCompProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvCompProfile = findViewById(R.id.tvCompProfile);
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName", "");
        String lastName = sharedPreferences.getString("lastName", "");
        String email = sharedPreferences.getString("email", "");
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        String mobileNo = sharedPreferences.getString("mobileNo", "");
        String gender = sharedPreferences.getString("gender", "");
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