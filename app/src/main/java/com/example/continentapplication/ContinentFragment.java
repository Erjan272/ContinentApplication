package com.example.continentapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.continentapplication.databinding.FragmentContinentBinding;
import java.util.ArrayList;



public class ContinentFragment extends Fragment implements OnItemClick {

    private FragmentContinentBinding binding;
    private ArrayList<String> continents = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        ContinentAdapter adapter = new ContinentAdapter(continents, this);
        binding.rvContinent.setAdapter(adapter);
    }

    private void loadData() {
        continents.add("Asia");
        continents.add("Africa");
        continents.add("Europe");
        continents.add("North America");
        continents.add("South America");
        continents.add("Australia");
    }


    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        String continent = continents.get(position);
        bundle.putString("Key", continent);
        CountryFragment countriesFragment = new CountryFragment();
        countriesFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, countriesFragment).addToBackStack(null).commit();

    }
}