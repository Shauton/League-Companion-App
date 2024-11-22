package com.example.leaguecompanionapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class SignUpFragment extends Fragment {

    EditText signupUsername, signupPassword, signupConfirmPassword;
    Button signupButton, alreadyUser;

    DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        signupUsername = view.findViewById(R.id.signup_username);
        signupPassword = view.findViewById(R.id.signup_password);
        signupConfirmPassword = view.findViewById(R.id.signup_conPassword);
        signupButton = view.findViewById(R.id.signup_button);
        alreadyUser = view.findViewById(R.id.alreadyUser_button);

        databaseHelper = new DatabaseHelper(getActivity());

        // Sign up Code
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String confirmPassword = signupConfirmPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(view.getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(confirmPassword)) {
                        Boolean checkUser = databaseHelper.checkUser(username);
                        if (!checkUser) {
                            Boolean insert = databaseHelper.insertUser(username, password);
                            if (insert) {
                                Toast.makeText(view.getContext(), "User successfully Made", Toast.LENGTH_SHORT).show();
                                replaceFragment(new DashboardFragment());
                            }
                            else {
                                Toast.makeText(view.getContext(), "User Not Made! Please Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(view.getContext(), "User Already Exists! Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(view.getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        alreadyUser.setOnClickListener(view1 -> replaceFragment(new LoginFragment()));

        return view;
    }

    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private FragmentManager getSupportFragmentManager() {
        return Objects.requireNonNull(getActivity()).getSupportFragmentManager();
    }
}