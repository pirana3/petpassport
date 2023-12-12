package edu.utsa.cs3443.final_project.model;

import java.util.Arrays;

public class Pet {
    private String name;
    private int age;
    private boolean gender; //true if male false if female
    private String breed;
    private double weight;
    private VetProfile recs;
    private String filename;

    public Pet(){ recs = new VetProfile(); }

    public Pet(String name, boolean gen){
        this.name = name;
        gender = gen;
        recs = new VetProfile();
        filename = name;
    }

    public Pet(String name, int age, boolean gen, String breed, double wght){
        this.name = name;
        this.age = age;
        gender = gen;
        this.breed = breed;
        weight = wght;
        recs = new VetProfile();
        filename = name;
    }

    public Pet(String name, int age, boolean gen, String breed, double wght, String health){
        this.name = name;
        this.age = age;
        gender = gen;
        this.breed = breed;
        weight = wght;
        recs = new VetProfile(health);
        filename = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getGender() {
        if(gender){
            return "Male";
        } else {
            return "Female";
        }
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("Male")){
            this.gender = true;
        } else if(gender.equalsIgnoreCase("Female")){
            this.gender = false;
        }
    }

    public String getBreed() { return breed; }

    public void setBreed(String breed) {
        if(breed != null)
            this.breed = breed;
        else
            this.breed = "";
    }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public String getFilename() { return filename; }

    public void setFilename(String filename) { this.filename = filename; }

    public VetProfile getRecs() { return recs; }

    public void setRecs(VetProfile recs) { this.recs = recs; }

    @Override
    public String toString() {
        return name + ',' + age +
                ',' + breed +
                ',' + gender + ',' +
                 weight + '\n' + recs.getNotes() +'\n';
    }
}
