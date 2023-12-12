package edu.utsa.cs3443.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs3443.final_project.controller.AddPetController;

public class AddPetActivity extends AppCompatActivity{
    private AddPetController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpet);

        controller = new AddPetController(this);

        int[] buttonIDs = {R.id.pet_photo, R.id.adadp, R.id.hopp};

        for(int i = 0; i < buttonIDs.length; i++){
            findViewById(buttonIDs[i]).setOnClickListener(controller);
        }
    }
}