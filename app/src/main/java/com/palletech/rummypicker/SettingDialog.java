package com.palletech.rummypicker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingDialog extends DialogFragment {

    ToggleButton tbutton, tbutton2;

    public SettingDialog() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = null;
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_setting_dialog, null);
        tbutton = (ToggleButton) v.findViewById(R.id.toggleButton1);
        tbutton2 = (ToggleButton) v.findViewById(R.id.toggleButton2);
        tbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (tbutton.isChecked()) {

                } else {

                }
            }
        });
        tbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbutton2.isChecked()) {

                } else {

                }
            }
        });
        return d;
    }
}
