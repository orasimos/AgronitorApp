package gr.aueb.cf.agronitor.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import gr.aueb.cf.agronitor.R;


//  TODO:   Setup settings fragment correctly to communicate with the Management activity

public class SettingsFragment extends Fragment {

    private AppCompatButton saveChangesBTN;
    private TextInputEditText renameGreenhouseET;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        saveChangesBTN = view.findViewById(R.id.saveChangesBTN);
        renameGreenhouseET = view.findViewById(R.id.renameGreenhouseET);

        saveChangesBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setTitle("Save Changes")
                        .setMessage("Are you sure you want to save changes?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                TODO: save changes to greenhouse
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });

        return view;
    }
}