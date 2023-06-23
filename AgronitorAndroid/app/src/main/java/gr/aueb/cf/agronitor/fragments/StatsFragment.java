package gr.aueb.cf.agronitor.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gr.aueb.cf.agronitor.R;

//  TODO:Setup stats fragment correctly to communicate with the Management activity

public class StatsFragment extends Fragment {

//    Temperature
    private TextView currentTempTV;
    private TextView minTempTV;
    private TextView maxTempTV;
//    Humidity
    private TextView currentHumidityTV;
    private TextView minHumidityTV;
    private TextView maxHumidityTV;
//    Soil Hydration
    private TextView currentSoilHydrationTV;
    private TextView minSoilHydrationTV;
    private TextView maxSoilHydrationTV;
//    UV Radiation
    private TextView currentUVRadiationTV;
    private TextView minUVRadiationTV;
    private TextView maxUVRadiationTV;

    public StatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        currentTempTV = view.findViewById(R.id.currentTempTV);
        currentTempTV.setText("Current Temperature: 28C");
        minTempTV = view.findViewById(R.id.minTempTV);
        maxTempTV = view.findViewById(R.id.maxTempTV);
        currentHumidityTV = view.findViewById(R.id.currentHumidityTV);
        minHumidityTV = view.findViewById(R.id.minHumidityTV);
        maxHumidityTV = view.findViewById(R.id.maxHumidityTV);
        currentSoilHydrationTV = view.findViewById(R.id.currentSoilHydrationTV);
        minSoilHydrationTV = view.findViewById(R.id.minSoilHydrationTV);
        maxSoilHydrationTV = view.findViewById(R.id.maxSoilHydrationTV);
        currentUVRadiationTV = view.findViewById(R.id.currentUVRadiationTV);
        minUVRadiationTV = view.findViewById(R.id.minUVRadiationTV);
        maxUVRadiationTV = view.findViewById(R.id.maxUVRadiationTV);

        // Inflate the layout for this fragment
        return view;
    }
}