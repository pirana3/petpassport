package edu.utsa.cs3443.final_project.model;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.ArrayList;

public class VetProfile {
    private String health;
    private String[] medication;
    private String notes;
    private ArrayList<File> vetRecords;


    public VetProfile(){}
    public VetProfile(String health){
        this.health = health;
    }

    public String getHealth() { return health; }

    public void setHealth(String health) { this.health = health; }

    public String getMedications() {
        String meds = "";
        for(String i : medication) {
            if (!i.equals(medication[medication.length - 1])) {
                meds += i + ", ";
            } else {
                meds += i;
            }
        }
        return meds;
    }

    public String getMed(int index) { return medication[index]; }

    public void setMedications(String meds) {
        String[] buff = meds.split(",");
        for(int i = 0; i < buff.length; i++){
            buff[i] = buff[i].trim();
        }
    }

    public String getNotes() { return notes; }

    public void setNotes(String notes) {
        if(notes != null)
            this.notes = notes;
        else
            this.notes = "";
    }

    @Override
    public String toString() {
        return health + ',' ;
    }
}
