package edu.ncu.cs165;

/**
 *@Author:LuZhiXing
 *@Date:2018/5/10_8:22
 *@Description:
 *
 * 每一个Shooter类里面有球员的名字和球队的名字和进球数量
 */

public class Shooter {
    private String shotName;
    private String teamName;
    private int numBall;
    //默认的构造方法
    public Shooter() {}

    public void setShooter(String shotName, String teamName, int numBall) {
        this.shotName = shotName;
        this.teamName = teamName;
        this.numBall += numBall;
    }

    public int getNumBall() {
        return numBall;
    }

    public void setNumBall(int numBall) {
        this.numBall += numBall;
    }

    public void setShotName(String shotName) {
        this.shotName = shotName;
    }

    public String getShotName() {
        return shotName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
