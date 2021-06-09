package model;

public class Player implements Comparable{
    private String name;
    private Integer score = 0;
    private Integer nbrain = 0;
    private Integer nGun = 0;

    public Player(String name){
        this.name = name;
    }



    public void addBrains(Integer brains){
        nbrain+= brains;
    }

    public void addScore(){
        score++;
    }


    public void addGun(){
        nGun++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbrain() {
        return nbrain;
    }

    public void setNbrain(Integer nbrain) {
        this.nbrain = nbrain;
    }

    public Integer getnGun() {
        return nGun;
    }

    public void setnGun(Integer nGun) {
        this.nGun = nGun;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }



    @Override
    public int compareTo(Object o) {
        return (((Player)o).getNbrain() - this.getNbrain());
    }
}
