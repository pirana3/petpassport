package edu.utsa.cs3443.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;

import edu.utsa.cs3443.final_project.controller.MainController;
public class MainActivity extends AppCompatActivity {
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this);

        int[] buttonIDs = {R.id.adph, R.id.vyp};

        for(int i = 0; i < buttonIDs.length; i++){
            findViewById(buttonIDs[i]).setOnClickListener(controller);
        }


    }
}