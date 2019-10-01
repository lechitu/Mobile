package com.lechitu.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginBtbClick (View view){
        EditText usernameET = findViewById(R.id.userNameET);
        EditText passwordET = findViewById(R.id.passWordET);
        String usernName = usernameET.getText().toString();
        String passWord = passwordET.getText().toString();

        if(checkIdentity(usernName)){
            Intent userIntent = new Intent(this, User.class);
            userIntent.putExtra("userName", usernName);
            this.startActivity(userIntent);
        }else {
            Toast.makeText(this, "Sai pass or user", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkIdentity(String userName) {
        if(userName.equals("chitu")){
            return true;
        }else {
            return false;
        }
    }
}
