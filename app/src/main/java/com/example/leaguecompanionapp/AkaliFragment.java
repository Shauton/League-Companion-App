package com.example.leaguecompanionapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class AkaliFragment extends Fragment {

    Button learnMoreButton;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_akali, container, false);

        learnMoreButton = view.findViewById(R.id.learnmore_button);

        learnMoreButton.setOnClickListener(v -> replaceFragment(new DashboardFragment()));

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