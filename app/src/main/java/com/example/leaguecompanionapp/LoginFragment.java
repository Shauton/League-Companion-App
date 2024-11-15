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

public class LoginFragment extends Fragment {

    EditText loginUsername, loginPassword;
    Button loginButton, notUser;

    DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginUsername = (EditText) view.findViewById(R.id.login_username);
        loginPassword = (EditText) view.findViewById(R.id.login_password);
        loginButton = (Button) view.findViewById(R.id.login_button);
        notUser = (Button) view.findViewById(R.id.notUser_button);

        databaseHelper = new DatabaseHelper(getActivity());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = loginUsername.getText().toString();
                String password = loginPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(view.getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUserPassword = databaseHelper.checkUserPassword(username, password);
                    if (checkUserPassword) {
                        Toast.makeText(view.getContext(), "Welcome Back!", Toast.LENGTH_SHORT).show();
                        replaceFragment(new DashboardFragment());
                    }
                    else {
                        Toast.makeText(view.getContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
//
        notUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SignUpFragment());
            }
        });

        return view;
    }


    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private FragmentManager getSupportFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }


}