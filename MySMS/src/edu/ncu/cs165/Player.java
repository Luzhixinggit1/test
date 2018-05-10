package edu.ncu.cs165;

public class Player {
    private String name;     //队员的名字
    private int points;  //队员的进球数

    public Player() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }
}
