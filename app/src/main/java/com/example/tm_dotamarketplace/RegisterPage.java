package com.example.tm_dotamarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import Model.User;

public class RegisterPage extends AppCompatActivity {



    private boolean validasiUppercase(String password){
        for (int i= 0; i < password.length(); i++){
            Character Uppercase = password.charAt(i);
            if (Character.isUpperCase(Uppercase)){
                return true;
            }
        }
        return false;
    }

    private boolean validasiNumberic(String password){
        for (int i= 0; i < password.length(); i++){
            Character number = password.charAt(i);
            if (Character.isDigit(number)){
                return true;
            }
        }
        return false;
    }

    private boolean validasiSpecial(String password){

        String spesialChar = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";

        for(int i = 0; i < password.length(); i++){
            Character special = password.charAt(i);
            if (password.contains(String.valueOf(spesialChar))){
                return true;
            }
        }
        return false;
    }

    private boolean cekUsername(String username){
        for (User user : User.arrayUser){
            if (username.equals(user.getUsername())){
                return false;
            }
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        final EditText fullname = findViewById(R.id.etFullname);
        final EditText username = findViewById(R.id.etUsername);
        final EditText password = findViewById(R.id.etPass);
        final EditText confirmPass = findViewById(R.id.etConfirmPass);
        final EditText phoneNumber = findViewById(R.id.etPhone);
        RadioButton male = findViewById(R.id.rdMale);
        RadioButton female = findViewById(R.id.rdFemale);
        final RadioGroup gender = findViewById(R.id.rgGander);
        final CheckBox  term = findViewById(R.id.cbTerm);
        Button btnRegister = findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullname.getText().toString();
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                String cPass = confirmPass.getText().toString();
                String phone = phoneNumber.getText().toString();

                if(name.equals("")){
                    Toast.makeText(RegisterPage.this, "Fullname must be filled!", Toast.LENGTH_SHORT);
                }else if(!name.contains(" ") && name.endsWith(" ")){
                    Toast.makeText( RegisterPage.this, "full name must be consist of 2 words or more", Toast.LENGTH_SHORT);
                }else if(uname.equals("")){
                    Toast.makeText( RegisterPage.this, "Username must be filled!", Toast.LENGTH_SHORT);
                }else if (cekUsername(uname)){
                    Toast.makeText( RegisterPage.this, "username not is available", Toast.LENGTH_SHORT);
                }else if(uname.length() < 5 || uname.length() > 25){
                    Toast.makeText( RegisterPage.this, "username must be between 5 and 25 characters", Toast.LENGTH_SHORT);
                }else if(pass.equals("")){
                    Toast.makeText( RegisterPage.this, "Password must be filled!", Toast.LENGTH_SHORT);
                }else if (!validasiUppercase(pass)){
                    Toast.makeText( RegisterPage.this, "Validate the password must contains at least 1 uppercase character", Toast.LENGTH_SHORT);
                }else if (!validasiSpecial(pass)){
                    Toast.makeText( RegisterPage.this, "Validate the password must contains at least 1 special character", Toast.LENGTH_SHORT);
                }else if(!validasiNumberic(pass)){
                    Toast.makeText( RegisterPage.this, "Validate the password must contains at least 1 numeric value", Toast.LENGTH_SHORT);
                }else if(pass.length() >15){
                    Toast.makeText( RegisterPage.this, "password must be less than 15 characters", Toast.LENGTH_SHORT);
                }else if(cPass.equals("")){
                    Toast.makeText( RegisterPage.this, "Confrim Password must be filled!", Toast.LENGTH_SHORT);
                }else if (!cPass.equals(pass)){
                    Toast.makeText( RegisterPage.this, "confirm password must be match with password", Toast.LENGTH_SHORT);
                } else if(phone.equals("")){
                    Toast.makeText( RegisterPage.this, "Phone Number must be filled!", Toast.LENGTH_SHORT);
                }else if (!phone.startsWith("+62")){
                    Toast.makeText( RegisterPage.this, "phone number must starts with +62", Toast.LENGTH_SHORT);
                }else if (phone.length() <= 12){
                    Toast.makeText( RegisterPage.this, "phone number must be more than equals 12 digits", Toast.LENGTH_SHORT);
                }else if (!gender.isSelected()){
                    Toast.makeText( RegisterPage.this, "phone number must be more than equals 12 digits", Toast.LENGTH_SHORT);
                }else if (!term.isChecked()){
                    Toast.makeText( RegisterPage.this, "agreement must be checked!", Toast.LENGTH_SHORT);
                }else{
                    User user = new User(name, uname, pass, phone);
                    User.arrayUser.add(user);
                    startActivity(new Intent(RegisterPage.this, MainActivity.class));
                    finish();
                }

                }
        });
    }

}