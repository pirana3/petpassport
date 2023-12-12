package edu.utsa.cs3443.final_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.utsa.cs3443.final_project.controller.MainController;
import edu.utsa.cs3443.final_project.controller.HamburgerController;
import edu.utsa.cs3443.final_project.model.Pet;
import edu.utsa.cs3443.final_project.model.ProfileHandler;

public class HamburgerActivity extends AppCompatActivity {

    private HamburgerController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ham_menu);

        controller = new HamburgerController(this);

        int[] buttonIDs = {R.id.ham, R.id.home};

        for(int i = 0; i < buttonIDs.length; i++){
            findViewById(buttonIDs[i]).setOnClickListener((View.OnClickListener) controller);
        }

        ViewGroup list = (ViewGroup) findViewById(R.id.pet_list);
        int i = 0;
        for(Pet b : ProfileHandler.getAllPets()){
            View v = controller.displayProfile(getLayoutInflater(),b);
            v.findViewById(R.id.name).setOnClickListener((View.OnClickListener) controller);

            ViewGroup insertPoint = list;
            insertPoint.addView(v, i, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            i++;
        }

    }

}