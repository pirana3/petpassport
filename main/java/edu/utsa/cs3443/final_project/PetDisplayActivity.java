package edu.utsa.cs3443.final_project;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import edu.utsa.cs3443.final_project.controller.HamburgerController;
import edu.utsa.cs3443.final_project.controller.PetDisplayController;
import edu.utsa.cs3443.final_project.model.Pet;

public class PetDisplayActivity extends AppCompatActivity{
    private PetDisplayController controller;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petdisplay);

        controller = new PetDisplayController(this);

        int[] buttonIDs = {R.id.delete,R.id.disadd, R.id.back};

        for(int i = 0; i < buttonIDs.length; i++){
            findViewById(buttonIDs[i]).setOnClickListener(controller);
        }

        controller.fetchPet(HamburgerController.getPetName(getIntent()));
    }
}
