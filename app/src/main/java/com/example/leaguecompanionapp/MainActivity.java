package com.example.leaguecompanionapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.leaguecompanionapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    EditText loginUsername, loginPassword;
    Button loginButton, notUser;

    EditText signupUsername, signupPassword, signupConfirmPassword;
    Button signupButton, alreadyUser;

    DatabaseHelper database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        replaceFragment(new HomeFragment());


        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navigation_home){
                replaceFragment(new HomeFragment());
            }
            else if (item.getItemId() == R.id.navigation_dashboard) {
                replaceFragment(new DashboardFragment());
            }
            else if (item.getItemId() == R.id.navigation_profile) {
                replaceFragment(new ProfileFragment());
            }
            else if (item.getItemId() == R.id.navigation_login) {
                replaceFragment(new LoginFragment());
            }

            return true;
        });


    }

    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}

//        database = new DatabaseHelper(this);
//
//        signupUsername = (EditText) findViewById(R.id.signup_username);
//        signupPassword = (EditText) findViewById(R.id.signup_password);
//        signupConfirmPassword = (EditText) findViewById(R.id.signup_conPassword);
//        signupButton = (Button) findViewById(R.id.signup_button);
//        alreadyUser = (Button) findViewById(R.id.alreadyUser_button);


//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = loginUsername.getText().toString();
//                String password = loginPassword.getText().toString();
//
//                if (username.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Boolean checkUserPassword = database.checkUserPassword(username, password);
//                    if (checkUserPassword) {
//                        Toast.makeText(MainActivity.this, "Welcome Back!", Toast.LENGTH_SHORT).show();
//                        replaceFragment(new HomeFragment());
//                    }
//                    else {
//                        Toast.makeText(MainActivity.this, "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//        });
////
//        notUser.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               replaceFragment(new SignUpFragment());
//           }
//        });
//
//
//        signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = signupUsername.getText().toString();
//                String password = signupPassword.getText().toString();
//                String confirmPassword = signupConfirmPassword.getText().toString();
//
//                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    if (password.equals(confirmPassword)) {
//                        Boolean checkUser = database.checkUser(username);
//                        if (!checkUser) {
//                            Boolean insert = database.insertUser(username, password);
//                            if (insert) {
//                                Toast.makeText(MainActivity.this, "User successfully Made", Toast.LENGTH_SHORT).show();
//                                replaceFragment(new HomeFragment());
//                            }
//                            else {
//                                Toast.makeText(MainActivity.this, "User Not Made! Please Try Again", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        else {
//                            Toast.makeText(MainActivity.this, "User Already Exists! Please Try Again", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else {
//                        Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//
//        alreadyUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                replaceFragment(new LoginFragment());
//            }
//        });