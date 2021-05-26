package model;

import tools.Difficulty;

import java.util.ArrayList;

public class Game {
    private Integer actualPlayer = 0;

    private Integer nPlayer = null;
    private ArrayList<Player> players = new ArrayList<>();
    private Difficulty difficulty;

    private Cup cup;

    public void setnPlayer(Integer nPlayer) {
        this.nPlayer = nPlayer;
    }

    public Integer getnPlayer() {
        return nPlayer;
    }

    public void addPlayer(Player player){
        players.add(player);
    }


    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setActualPlayer(Integer actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public Integer getActualPlayer() {
        return actualPlayer;
    }
}
