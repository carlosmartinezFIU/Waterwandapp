package com.example.waterwand;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    //Pattern looking for at least one number, lowercase, upper case, character and
    // no whitepaces, minimun 6 characters
    private static final Pattern PASSWORD_PATTTERN =
            Pattern.compile("^" +
                 //   "(?=.*[0-9])" +      //needs at least 1 digit
                 //   "(?=.*[a-z])" +      //needs at least 1 lower case letter
                 //   "(?=.*[A-Z])" +      //needs at least 1 upper case letter
                    "(?=.*[a-zA-Z])"+
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");

    //Variables to hold point in view and grag ID's
    private TextInputEditText textinputEmail;
    private TextInputEditText textinputPassword;
    Button signUp;
    Button login;

    public ThirdFragment(){

    }

    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textinputEmail = view.findViewById(R.id.email);
        textinputPassword = view.findViewById(R.id.password);

        signUp = view.findViewById(R.id.signup_bn);
        login = view.findViewById(R.id.login_bn);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail(textinputEmail);
                validatePassword(textinputPassword);
            }
        });
    }


    private boolean validateEmail(TextInputEditText input)
    {
        textinputEmail = input;
        String inputEmail = textinputEmail.getText().toString().trim();

        if(inputEmail.isEmpty())
        {
            textinputEmail.setError("Field cannot be empty");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()){
            textinputEmail.setError("Please enter a valid email address");
            return false;
        }
        else{

            textinputEmail.setError(null);
            return true;
        }

    }

    private boolean validatePassword(TextInputEditText input)
    {
        textinputPassword = input;
        String inputPassword = textinputPassword.getText().toString().trim();

        if(inputPassword.isEmpty())
        {
            textinputPassword.setError("Field cannot be empty");
            return false;
        }else if (!PASSWORD_PATTTERN.matcher(inputPassword).matches()){
            textinputPassword.setError("Password is to weak");
            return false;
        }
        else{

            textinputPassword.setError(null);
            return true;
        }

    }

    public void confirmationText(View view)
    {
        /*if(!validateEmail(view) || !validatePassword(view))
            return;
         */

        String userInput = "Email: " + textinputEmail.getText().toString().trim();
        userInput += "\n";
        userInput += "Password: " + textinputPassword.getText().toString().trim();
    }


}