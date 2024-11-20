package com.example.leaguecompanionapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.leaguecompanionapp.databinding.FragmentDashboardBinding;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DashboardFragment extends Fragment implements ChampViewInterface {

    private FragmentDashboardBinding binding;
    ArrayList<Champion> champions = new ArrayList<>();
    RecyclerView recyclerView;

    int[] champImages = {
            R.drawable.aatrox_tile,
            R.drawable.ahri_tile,
            R.drawable.akali_tile,
            R.drawable.akshan_tile,
            R.drawable.alistar_tile,
            R.drawable.ambessa_tile,
            R.drawable.amumu_tile,
            R.drawable.anivia_tile,
            R.drawable.annie_tile,
            R.drawable.aphelios_tile,
            R.drawable.ashe_tile};

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onViewCreated(container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpChampions();

        recyclerView = view.findViewById(R.id.champ_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CS_RecyclerViewAdapter adapter = new CS_RecyclerViewAdapter(getContext(), champions, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void setUpChampions() {
        String[] champNames = getResources().getStringArray(R.array.champion_name_list);
        String[] champTitles = getResources().getStringArray(R.array.champion_title_list);

        for (int i = 0; i < champNames.length; i++) {
            champions.add(new Champion(
                    champNames[i],
                    champTitles[i],
                    champImages[i])
            );
        }
    }

    @Override
    public void onItemClicked(int position) {
        replaceFragment(new HomeFragment());
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