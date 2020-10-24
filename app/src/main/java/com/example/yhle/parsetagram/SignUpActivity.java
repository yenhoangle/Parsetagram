package com.example.yhle.parsetagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    private EditText etUsernameSignUp;
    private EditText etPasswordSignUp;
    private Button btSignUp;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        actionBar=getSupportActionBar();
        actionBar.hide();

        etUsernameSignUp=findViewById(R.id.etUsernameSignUp);
        etPasswordSignUp=findViewById(R.id.etPasswordSignUp);
        btSignUp=findViewById(R.id.btnSignUp);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsernameSignUp.getText().toString();
                String password = etPasswordSignUp.getText().toString();
                registerUser(username, password);
            }
        });


    }

    private void registerUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Log.e("SignUpActivity", "error signing up", e);
                    return;
                }
                Toast.makeText(SignUpActivity.this, "Sign up complete! Please log in", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}