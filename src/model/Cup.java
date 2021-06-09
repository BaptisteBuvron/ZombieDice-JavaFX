package model;

import tools.DiceFaces;

import java.util.ArrayList;
import java.util.Random;

public class Cup {
    private ArrayList<Dice> dices = new ArrayList<>();
    private ArrayList<Dice> fusils = new ArrayList<>();
    private ArrayList<Dice> cerveaux = new ArrayList<>();
    private ArrayList<Dice> main;

    private Random randomGenerator = new Random();

    public Cup(){
        main = new ArrayList<>();
        main.add(0,null);
        main.add(1,null);
        main.add(2,null);
    }


    public Object[] getADice(int i){
        if (dices.size() != 0){
            Dice item = null;
            DiceFaces face = null;
            if (main.get(i) != null){
                item = main.get(i);
                //main.set(i,null);
                face = item.getFaces();
            }
            else {
                int index = randomGenerator.nextInt(dices.size());
                item = dices.get(index);
                face = item.getFaces();
            }

            //TODO RECREATE PIOCHE
            if (face == DiceFaces.shotgun){
                dices.remove(item);
                fusils.add(item);
                main.set(i,null);
            }
            else if(face == DiceFaces.brain){
                dices.remove(item);
                cerveaux.add(item);
                main.set(i,null);
            }
            else {
                dices.remove(item);
                main.set(i,item);
            }
            Object[] ret= new Object[2];
            ret[0] = face;
            ret[1] = item.getColor();

            return ret;
        }
        else {
            dices.addAll(cerveaux);
            cerveaux = new ArrayList<>();
            return getADice(i);
        }

    }

    public void reset(){
        dices.addAll(fusils);
        dices.addAll(cerveaux);
        for (int i = 0; i < 3; i++) {
            if (main.get(i) != null){
                dices.add(main.get(i));
            }
        }
        fusils = new ArrayList<>();
        cerveaux = new ArrayList<>();
        System.out.println(dices.size());
        main = new ArrayList<>();
        main.add(0,null);
        main.add(1,null);
        main.add(2,null);
    }

    public void addDice(Dice dice){dices.add(dice);}

    public void addPioche(Dice dice){
        fusils.add(dice);
    }



}
