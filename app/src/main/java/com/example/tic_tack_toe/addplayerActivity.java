package com.example.tic_tack_toe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class addplayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplayer);

        EditText playerone = findViewById(R.id.playerone);
        EditText playertwo = findViewById(R.id.playertwo);
        Button startbtn = findViewById(R.id.startbtn);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getplayernone = playerone.getText().toString();
                String getplayertwo = playertwo.getText().toString();

                if (getplayernone.isEmpty() || getplayertwo.isEmpty()) {
                    Toast.makeText(addplayerActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(addplayerActivity.this, MainActivity.class);
                    intent.putExtra("playerone", getplayernone);
                    intent.putExtra("playertwo", getplayertwo);
                    startActivity(intent);
                }

            }
        });

    }
}