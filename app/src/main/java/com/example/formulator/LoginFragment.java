package com.example.formulator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.aviran.cookiebar2.CookieBar;

public class LoginFragment extends Fragment {

    Button loginButton;
    EditText username, password;
    TextView forgot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);

        loginButton = root.findViewById(R.id.LoginButton);
        username = root.findViewById(R.id.username);
        password = root.findViewById(R.id.password);
        forgot = root.findViewById(R.id.forgotTxtView);




        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((username.getText().toString()).equals("")
                        || (password.getText().toString()).equals(""))
                    error("pleas fill the boxes!");

                else if ((username.getText().toString()).equals("admin")
                        && (password.getText().toString()).equals("admin")) {
                    success();

                } else if ((username.getText().toString()).equals("morteza")
                        && (password.getText().toString()).equals("1111")) {
                    success();

                } else if ((username.getText().toString()).equals("iiTsAmir")
                        && (password.getText().toString()).equals("amir123")) {
                    success();

                } else
                    error("username or password wrong!");

            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CookieBar.build(getActivity())
                        .setTitle("ERROR")
                        .setMessage("admin========admin\nmorteza======1111\niiTsAmir=====amir1234")
                        .setCookiePosition(CookieBar.TOP)
                        .setBackgroundColor(R.color.dark_orange)
                        .setAnimationIn(android.R.anim.slide_in_left, android.R.anim.slide_in_left)
                        .setAnimationOut(android.R.anim.slide_out_right, android.R.anim.slide_out_right)
                        .setDuration(1000)
                        .show();
            }
        });

        return root;
    }

    private void error(String errorTxt) {
        CookieBar.build(getActivity())
                .setTitle(errorTxt)
                .setCookiePosition(CookieBar.TOP)
                .setBackgroundColor(R.color.dark_orange)
                .setAnimationOut(android.R.anim.fade_out, android.R.anim.fade_out)
                .setDuration(6000)
                .show();
    }

    private void success() {
        CookieBar.build(getActivity())
                .setTitle("Welcome " + (username.getText().toString()))
                .setCookiePosition(CookieBar.TOP)
                .setBackgroundColor(R.color.scs)
                .setAnimationOut(android.R.anim.fade_out, android.R.anim.fade_out)
                .setDuration(4000).show();
    }
}
