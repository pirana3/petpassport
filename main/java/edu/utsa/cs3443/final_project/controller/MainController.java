package edu.utsa.cs3443.final_project.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import edu.utsa.cs3443.final_project.AddPetActivity;
import edu.utsa.cs3443.final_project.HamburgerActivity;
import edu.utsa.cs3443.final_project.R;
import edu.utsa.cs3443.final_project.model.ProfileHandler;

public class MainController implements View.OnClickListener {
    private Activity activity;
    private static boolean firstLoad = false;

    public MainController(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
            if(!firstLoad){
                ProfileHandler.loadPets(activity, activity.getAssets());
                firstLoad = true;
            }

            if(view.getId() == R.id.adph){
                Intent intent = new Intent(activity, AddPetActivity.class);
                activity.startActivity(intent);
            } else if(view.getId() == R.id.vyp) {
                Intent intent2 = new Intent(activity, HamburgerActivity.class);
                activity.startActivity(intent2);
            }
    }
}
