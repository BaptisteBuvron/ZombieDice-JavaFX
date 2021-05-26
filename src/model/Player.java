package model;

public class Player {
    private String name;
    private Integer score;
    private Integer nbrain;
    private Integer nGun;

    public Player(String name){
        this.name = name;
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
}
