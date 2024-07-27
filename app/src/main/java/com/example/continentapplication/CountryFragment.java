package com.example.continentapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.continentapplication.databinding.FragmentCountryBinding;
import java.util.ArrayList;
import java.util.Objects;

public class CountryFragment extends Fragment {
    private FragmentCountryBinding binding;
    private ArrayList<String> countries = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(getLayoutInflater());
        return binding.getRoot();}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CountryAdapter countriesAdapter = new CountryAdapter(countries);
        String continent = getArguments().getString("Key");
        position (continent);
        binding.rvCountry.setAdapter(countriesAdapter);
    }

    private void position(String continent) {
        switch (continent) {
            case "Europe":
                countries.add("Russia");
                countries.add("Germany");
                countries.add("Spain");
                countries.add("France");
                countries.add("Italy");
                break;
            case "Asia":
                countries.add("Kyrgyzstan");
                countries.add("Kasachstan");
                countries.add("Indonesia");
                countries.add("Philippines");
                countries.add("Uzbekistan");
                break;
            case "Africa":
                countries.add("Algeria");
                countries.add("Angola");
                countries.add("Benin");
                countries.add("Egypt");
                countries.add("Ghana");
                break;
            case "North America":
                countries.add("USA");
                countries.add("Mexico");
                countries.add("Costa Rica");
                countries.add("Grenada");
                countries.add("Jamaica");
                break;
            case "South America":
                countries.add("Brasil");
                countries.add("Argentina");
                countries.add("Columbia");
                countries.add("Bolivia");
                countries.add("Ecuador");
                break;
            case "Australia":
                countries.add("Australia");
                countries.add("Papua New Guinea");
                countries.add("New Zealand");
                countries.add("Sydney");
                countries.add("Melbourne");
                break;
            default:
                break;
        }
    }

}
