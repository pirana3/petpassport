package edu.utsa.cs3443.final_project.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfileHandler {
    private static String directory = "savedPets";
    private static ArrayList<Pet> pets = new ArrayList<Pet>();

    public static void addPet(Pet p) {
        pets.add(p);
    }

    public static Pet getPet(String name) {
        for (Pet p : pets) {
            if (p.getName().equalsIgnoreCase(name))
                return p;
        }
        return null;
    }

    public static ArrayList<Pet> getAllPets() {
        return pets;
    }

    public static void removePet(String name, Activity activity) {
        Pet p = getPet(name);
        if (p != null) {
            deletePet(activity, p);
            pets.remove(p);
        }
    }

    public static void storePet(Activity activity, Pet p) {
        OutputStream out;
        try {
            out = activity.openFileOutput(p.getFilename(), Context.MODE_PRIVATE);
            out.write(p.toString().getBytes(StandardCharsets.UTF_8));
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadPets(Context context, AssetManager manager) {
        FileInputStream fis;
        InputStreamReader in;
        Scanner sc;
        Pet p;
        String[] allPets = context.fileList();
        String buffer;
        String[] buff;


        try {
            if (allPets.length > 0) {
                for (String i : allPets) {
                    fis = context.openFileInput(i);
                    in = new InputStreamReader(fis);
                    //pet = new File(i);
                    //if (pet.isFile()) {
                        sc = new Scanner(in);
                        buffer = sc.nextLine();
                        buff = buffer.split(",");

                        p = new Pet(buff[0], Boolean.parseBoolean(buff[3]));

                        if (!buff[1].isEmpty())
                            p.setAge(Integer.parseInt(buff[1]));

                        if (!buff[2].isEmpty())
                            p.setBreed(buff[2]);
                        else
                            p.setBreed("");

                        if (!buff[4].isEmpty())
                            p.setWeight(Double.parseDouble(buff[4]));

                        if (sc.hasNext()) {
                            buffer = "";
                            while (sc.hasNext()) {
                                buffer += sc.nextLine();
                            }
                            if (!buffer.isEmpty()) {
                                p.getRecs().setNotes(buffer);
                            }
                            else
                                p.getRecs().setNotes("");
                        }
                        sc.close();
                        in.close();

                        addPet(p);
                    }
                //}
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void deletePet(Activity activity, Pet p) {
        if (activity.deleteFile(p.getFilename())) {
            Toast.makeText(activity, "File deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(activity, "Failed to delete file", Toast.LENGTH_SHORT).show();
        }
    }
}
