package com.palletech.rummypicker;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class Disconnected extends DialogFragment {


    public Disconnected() {
        // Required empty public constructor
    }

    Button b;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d=null;
        AlertDialog.Builder ad=new AlertDialog.Builder(getActivity());
        View v=getActivity().getLayoutInflater().inflate(R.layout.network,null);
        b= (Button) v.findViewById(R.id.settings);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
        ad.setView(v);
        d=ad.create();
        return d;
    }
}
