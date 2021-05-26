package model;

import tools.DiceFaces;

import java.util.ArrayList;
import java.util.Random;

public class Cup {
    private ArrayList<Dice> dices = new ArrayList<>();
    private ArrayList<Dice> pioche = new ArrayList<>();

    private Random randomGenerator = new Random();


    public DiceFaces getADice(){
        int index = randomGenerator.nextInt(dices.size());
        Dice item = dices.get(index);
        DiceFaces face = item.getFaces();
        if (face == DiceFaces.shotgun){
            dices.remove(item);
            pioche.add(item);
        }
        return face;
    }

    public void reset(){
        for (Dice dice:pioche) {
            dices.add(dice);
            pioche.remove(dice);
        }
    }

    public void addDice(Dice dice){dices.add(dice);}

    public void addPioche(Dice dice){
        pioche.add(dice);
    }



}
