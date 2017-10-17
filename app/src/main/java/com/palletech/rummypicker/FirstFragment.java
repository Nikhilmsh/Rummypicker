package com.palletech.rummypicker;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    Button b;
    MainActivity mainActivity;
    LoginButton lb;
    CallbackManager callbackManager;

    public FirstFragment() {
        // Required empty public constructor
    }

    public boolean isInternetConnection() {
        ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        b = (Button) v.findViewById(R.id.play);
        mainActivity = (MainActivity) getActivity();
        lb = (LoginButton) v.findViewById(R.id.login_button);
        lb.setFragment(this);
        fblogin();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetConnection()) {
                    Toast.makeText(getActivity(), "playing", Toast.LENGTH_SHORT).show();
                } else {
                    mainActivity.disconnectDialog();
                }

            }
        });
        return v;
    }

    public void fblogin() {
        callbackManager = CallbackManager.Factory.create();
        lb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


            }

            @Override
            public void onCancel() {
                // App code

            }

            @Override
            public void onError(FacebookException exception) {
                // App code

            }
        });

    }

}
