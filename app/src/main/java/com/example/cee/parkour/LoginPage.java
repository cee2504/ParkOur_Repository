package com.example.cee.parkour;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailAddress;
    private EditText password;
    private Button loginButton;
    private Button registerButton;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailAddress = findViewById(R.id.emailAddressTextBox);
        password = findViewById(R.id.passwordTextBox);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(LoginPage.this, CarParkSelection.class));
                }
            }
        };

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }
    //end onCreate method

    @Override
    public void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }


    private void startLogin() {
        String email = emailAddress.getText().toString();
        String pass = password.getText().toString();

        if (TextUtils.isEmpty(email) || (TextUtils.isEmpty(pass))) {
            Toast.makeText(LoginPage.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();

        } else {
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginPage.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void createAccount() {

        if (TextUtils.isEmpty(emailAddress.getText().toString()) || (TextUtils.isEmpty(password.getText().toString()))) {
            Toast.makeText(LoginPage.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }else {
            (mAuth.createUserWithEmailAndPassword(emailAddress.getText().toString(), password.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginPage.this, "Registration Complete!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginPage.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
}
