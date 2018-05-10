package edu.ncu.cs165;

import java.util.Scanner;

/**
 *@Author:LuZhiXing
 *@Date:2018/5/10_10:52
 *@Description:
 *
 * 常规赛的比赛
 */

public class NormalMatch {
    //初始化两个队伍的进球数和球员进球数
    public void initPlay(Team team1, Team team2, int num1, int num2, Shooter[] shooters, Team[] teams) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        team1.setNumBall(num1);
        team1.setMatchPlayed(1);
        System.out.println("请输入" + num1 + "个" + team1.getName() + "队进球者的名字：");
        for(int i = 0;i < num1;i++) {
            //队员的名字均为a1-a5
            String name1 = input.next();
            setScore(team1,name1);
            plusShooter(shooters, teams, name1, team1.getName());
        }
        team2.setNumBall(num2);
        team2.setMatchPlayed(1);
        System.out.println("请输入" + num2 + "个" + team2.getName() + "队进球者的名字：");
        for(int i = 0;i < num2;i++) {
            //队员的名字均为a1-a5
           // System.out.println("请输入" + team2.getName() + " 队进球者的名字：");
            String name2 = input.next();
            setScore(team1,name2);
            plusShooter(shooters, teams, name2, team2.getName());
        }

        match(team1, team2);
    }

    //某个队员进球
    public void setScore(Team team, String name) {
        for(int i = 0;i < 5; i++) {
            if (name.equals(team.player[i].getName()))
                team.player[i].setPoints(1);
        }
    }

    //当输入射手名字和得分时，给该名射手加分
    public void plusShooter(Shooter[] shooters, Team[] teams, String shotName, String teamName) {
        for (int i = 0; i < shooters.length; i++) {
            if (shooters[i].getShotName().equals(shotName) && shooters[i].getTeamName().equals(teamName)){
                shooters[i].setShooter(shotName,teamName,1);
            }

        }
    }

    //初始化射手
    public void initShooter(Shooter[] shooters, Team[] teams) {
        int count = 0;
        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams[i].player.length; j++) {
                shooters[count++].setShooter(teams[i].player[j].getName(), teams[i].getName(),0);
            }
        }
    }


    //两个队伍之间比赛
    public void match(Team team1, Team team2) {
       if(team1.getNumBall() > team2.getNumBall()) {
           team1.setMatchWin(1);
           team2.setMatchLoses(1);
           team1.setPoints(3);
           team2.setPoints(0);
       } else if(team1.getNumBall() < team2.getNumBall()) {
           team2.setMatchWin(1);
           team1.setMatchLoses(1);
           team1.setPoints(0);
           team2.setPoints(3);
       } else {
           team1.setPoints(1);
           team2.setPoints(1);
           team1.setMatchDraw(1);
           team2.setMatchDraw(1);
       }
    }

    public static void main(String[] args) {
        NormalMatch normalMatch1 = new NormalMatch();

        Team team[] = new Team[5];    //球队数量，便于测试，初始化为5
        Shooter[] shooters = new Shooter[25];  //射手数量就是球队数量乘以每队队员数量



        for (int i = 0 ;i<team.length;i++) {
            team[i] = new Team();
        }

        for (int i = 0; i < shooters.length; i++) {
            shooters[i] = new Shooter();
        }
        String name[] = {"A","B","C","D","E"};
        for(int i = 0;i < 5;i++) {
           team[i].setName(name[i]);
        }
        normalMatch1.initShooter(shooters, team);

        //每一轮比赛结束后，输入每个队伍的成绩
        for(int i = 0; i < team.length; i++) {
            for ( int j = i + 1; j < team.length; j++) {
                System.out.println("请分别输入" + team[i].getName() + "队和" + team[j].getName() + "队的得分成绩：(为了便于测试，只设置了五个参赛队伍，并且每个队伍的队员名初始化为（a1-a5)");
               // System.out.println(team[i].getName() + " " + team[j].getName());
                Scanner input = new Scanner(System.in);
                int num1 = input.nextInt();
                int num2 = input.nextInt();
                normalMatch1.initPlay(team[i],team[j],num1,num2,shooters, team);
                normalMatch1.sortTeam(team);
                normalMatch1.printMessagte(team);       //实时更新积分榜
                normalMatch1.sortShoot(shooters);
                normalMatch1.printShooter(shooters);    //实时更新射手榜
            }
        }
    }

    //输出积分榜
    public void printMessagte(Team[] teams) {
        System.out.printf("%5s%5s%5s%5s%5s%5s%5s%5s\n","积分","球队名","胜场数","负场数","排名","场次","平场数","进球数");
        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].getPoints() + " " + teams[i].getName() + " " + teams[i].getMatchWin() + " " + teams[i].getMatchLoses() + " " + (i+1) +
             " " + teams[i].getMatchPlayed() + " " + teams[i].getMatchDraw() + " " + teams[i].getNumBall());
        }
    }

    //输出射手榜
    public void printShooter(Shooter[] shooters) {
        System.out.println("排名 " + "球员 " + "球队 " + "进球数 ");
        int count = 1;

        for (int i = 0; i < shooters.length; i++) {
            if (shooters[i].getNumBall() > 0) //有进球的球员才进行排名
            System.out.println((count++) + " " + shooters[i].getShotName() +
            " " + shooters[i].getTeamName() + " " + shooters[i].getNumBall());
        }
    }

    //积分榜排序(选择排序),若成绩一样，则采用默认排名
   public Team[] sortTeam(Team[] teams) {
        for (int i = 0; i < teams.length; i++){
            int max = teams[i].getPoints();
            int k = i;
            for (int j = i + 1; j < teams.length - 1; j++) {
                if (teams[j].getPoints() > max) {
                    max = teams[j].getPoints();
                    k = j;
                }
            }
            Team temp = new Team();
            temp = teams[k];
            teams[k] = teams[i];
            teams[i] = temp;
        }
        return teams;
   }

   //射手的进球排名
   public void sortShoot(Shooter[] shooters) {
       for (int i = 0; i < shooters.length; i++){
           int max = shooters[i].getNumBall();
           int k = i;
           for (int j = i + 1; j < shooters.length - 1; j++) {
               if (shooters[j].getNumBall() > max) {
                   max = shooters[j].getNumBall();
                   k = j;
               }
           }
           Shooter temp = new Shooter();
           temp = shooters[k];
           shooters[k] = shooters[i];
           shooters[i] = temp;
       }
   }

}
