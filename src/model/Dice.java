package model;

import tools.DiceFaces;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    private ArrayList<DiceFaces> faces = new ArrayList<>();
    private String color;
    private Random randomGenerator = new Random();

    public Dice(String color){
        this.color = color;
        this.faces = new ArrayList<>();

        if (color.toLowerCase() == "green") {
            this.faces.add(DiceFaces.brain);
            this.faces.add(DiceFaces.brain);
            this.faces.add(DiceFaces.brain);
            this.faces.add(DiceFaces.steps);
            this.faces.add(DiceFaces.steps);
            this.faces.add(DiceFaces.shotgun);
        } else if (color.toLowerCase() == "yellow") {
            this.faces.add(DiceFaces.brain);
            this.faces.add(DiceFaces.brain);
            this.faces.add(DiceFaces.steps);
            this.faces.add(DiceFaces.steps);
            this.faces.add(DiceFaces.shotgun);
            this.faces.add(DiceFaces.shotgun);
        } else if (color.toLowerCase() == "red") {
            this.faces.add(DiceFaces.brain);
            this.faces.add(DiceFaces.steps);
            this.faces.add(DiceFaces.steps);
            this.faces.add(DiceFaces.shotgun);
            this.faces.add(DiceFaces.shotgun);
            this.faces.add(DiceFaces.shotgun);
        }
    }

    public DiceFaces getFaces(){
            int index = randomGenerator.nextInt(faces.size());
            DiceFaces item = faces.get(index);
            return item;
    }

    public String getColor() {
        return color;
    }
}
