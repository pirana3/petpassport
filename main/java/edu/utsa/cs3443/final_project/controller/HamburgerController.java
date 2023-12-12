package edu.utsa.cs3443.final_project.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.utsa.cs3443.final_project.AddPetActivity;
import edu.utsa.cs3443.final_project.HamburgerActivity;
import edu.utsa.cs3443.final_project.MainActivity;
import edu.utsa.cs3443.final_project.PetDisplayActivity;
import edu.utsa.cs3443.final_project.R;
import edu.utsa.cs3443.final_project.model.Pet;
import edu.utsa.cs3443.final_project.model.ProfileHandler;

public class HamburgerController implements View.OnClickListener{

    private Activity activity;

    private static String key = "pet_name";
    public HamburgerController(Activity activity) { this.activity = activity; }

    @Override
    public void onClick(View view) {
        Intent intent;
        if(view.getId() == R.id.ham){
            intent = new Intent(activity, AddPetActivity.class);
            activity.startActivity(intent);
        } else if(view.getId() == R.id.home) {
            intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        } else {
            TextView clicked = (TextView) view;
            intent = new Intent(activity, PetDisplayActivity.class);
            intent.putExtra(key,clicked.getText().toString());
            activity.startActivity(intent);
        }
    }

    public static String getPetName(Intent intent){
        return intent.getStringExtra(key);
    }

    public View displayProfile(LayoutInflater li, Pet p){
            View v = li.inflate(R.layout.pet_click,null);
            TextView name = (TextView) v.findViewById(R.id.name);
            name.setText(p.getName());
            return v;
    }
}
