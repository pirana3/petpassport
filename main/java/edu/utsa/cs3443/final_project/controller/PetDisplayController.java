package edu.utsa.cs3443.final_project.controller;

import android.content.Intent;
import android.view.View;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import edu.utsa.cs3443.final_project.HamburgerActivity;
import edu.utsa.cs3443.final_project.MainActivity;
import edu.utsa.cs3443.final_project.PetDisplayActivity;
import edu.utsa.cs3443.final_project.model.Pet;
import edu.utsa.cs3443.final_project.R;
import edu.utsa.cs3443.final_project.model.ProfileHandler;


public class PetDisplayController implements View.OnClickListener{
    private final Activity activity;

    private Pet p;

    public PetDisplayController(Activity activity){
        this.activity = activity;
    }

    public void onClick(View view) {
        Intent intent;
        if(view.getId() == R.id.delete) {
            ProfileHandler.removePet(p.getName(), activity);
            Toast.makeText(activity,p.getName()+" was deleted", Toast.LENGTH_SHORT);
            intent = new Intent(activity, HamburgerActivity.class);
            activity.startActivity(intent);
        } else if(view.getId() == R.id.disadd) {
            intent = new Intent(activity, HamburgerActivity.class);
            activity.startActivity(intent);
        } else if(view.getId() == R.id.back) {
            intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
    }

    public void fetchPet(String pet){
        displayPet(pet);
    }

    private void displayPet(String pet) {
        p = ProfileHandler.getPet(pet);
        int[] tIDs = {R.id.an,R.id.age,R.id.breed,R.id.sex,
                R.id.weight,R.id.notes,R.id.pet_photo};

        TextView name = (TextView) activity.findViewById(tIDs[0]);
        if(p.getName() != null)
            name.setText("Name: " + p.getName());

        TextView age = (TextView) activity.findViewById(tIDs[1]);
        if(!(p.getAge() <= 0))
            age.setText("Age: " + p.getAge());

        TextView breed = (TextView) activity.findViewById(tIDs[2]);
        if(p.getBreed() != null)
            breed.setText("Breed: " + p.getBreed());

        TextView sex = (TextView) activity.findViewById(tIDs[3]);
        sex.setText("Gender: " + p.getGender());

        TextView weight = (TextView) activity.findViewById(tIDs[4]);
        if(!(p.getWeight() <= 0))
            weight.setText("Weight: " + p.getWeight() + " lb");

        TextView notes = (TextView) activity.findViewById(tIDs[5]);
        if(p.getRecs().getNotes() != null)
            notes.setText("Notes: " + p.getRecs().getNotes());
    }
}