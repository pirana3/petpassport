package edu.utsa.cs3443.final_project.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;

import edu.utsa.cs3443.final_project.MainActivity;
import edu.utsa.cs3443.final_project.PetDisplayActivity;
import edu.utsa.cs3443.final_project.R;
import edu.utsa.cs3443.final_project.model.Pet;
import edu.utsa.cs3443.final_project.model.ProfileHandler;

public class AddPetController implements View.OnClickListener{

    private Activity activity;

    private static String key = "pet_name";



    public AddPetController(Activity activity) { this.activity = activity; }
    @Override
    public void onClick(View view) {
        Intent intent;
        if(view.getId() == R.id.pet_photo){
            //TODO: Add a way to open gallery and select a photo.
        }else if(view.getId() == R.id.adadp){
            Pet p = createPet();
            if(p != null){
                intent = new Intent(activity, PetDisplayActivity.class);
                intent.putExtra(key,p.getName());
                activity.startActivity(intent);
            }
        } else if(view.getId() == R.id.hopp) {
            intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
    }

    private Pet createPet(){
        Pet p = new Pet();

        EditText name = (EditText) activity.findViewById(R.id.an);
        if(!name.getText().toString().isEmpty())
            p.setName(name.getText().toString());
        else{
            Toast.makeText(activity, "Pet needs a name!", Toast.LENGTH_SHORT).show();
            return null;
        }

        EditText gender = (EditText) activity.findViewById(R.id.sex);
        if(!gender.getText().toString().isEmpty())
            p.setGender(gender.getText().toString());
        else {
            Toast.makeText(activity, "Pet needs a gender!", Toast.LENGTH_SHORT).show();
            return null;
        }

        EditText age = (EditText) activity.findViewById(R.id.age);
        if(!age.getText().toString().isEmpty())
            p.setAge(Integer.parseInt(age.getText().toString()));

        EditText breed = (EditText) activity.findViewById(R.id.breed);
        if(!breed.getText().toString().isEmpty())
            p.setBreed(breed.getText().toString());

        EditText weight = (EditText) activity.findViewById(R.id.weight);
        if(!weight.getText().toString().isEmpty())
            p.setWeight(Double.parseDouble(weight.getText().toString()));

        EditText notes = (EditText) activity.findViewById(R.id.notes);
        if(!notes.getText().toString().isEmpty())
            p.getRecs().setNotes(notes.getText().toString());

        if(ProfileHandler.getPet(p.getName()) != null) {
            Toast.makeText(activity, p.getName()+" already has a file!", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            p.setFilename(p.getName());
            Toast.makeText(activity, "Pet added successfully!", Toast.LENGTH_SHORT).show();
            ProfileHandler.addPet(p);
            ProfileHandler.storePet(activity, p);
            return p;
        }
    }


}
