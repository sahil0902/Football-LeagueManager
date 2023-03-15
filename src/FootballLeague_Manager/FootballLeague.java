package FootballLeague_Manager;

import java.util.*;

/**
 * Class representing a football league.
 */


public class FootballLeague {


    // ID of the football league
    private  String idFootballLeague;

    // List of teams in the league
    private List<FootballLeague_Manager.Team> teamList;


    // Position of the team in the league's ranking
    private Integer position;


    public Integer getPosition() {

        return position;
    }

    public void setPosition(Integer position) {

        this.position = position;
    }

    /**
     * Constructs a new FootballLeague object with the given ID.
     *
     * @param idFootballLeague the ID of the football league
     */
    public FootballLeague(String idFootballLeague) {
        this.idFootballLeague = idFootballLeague;
        this.teamList = new LinkedList();

    }
    /**
     * Adds a new team to the league.
     *
     * @param t the team to be added
     */

    public void addNewTeam(FootballLeague_Manager.Team t) {

        this.teamList.add(t);
    }
    /**
     * Removes the given team from the league.
     *
     * @param teamRemoved the team to be removed
     */
    public void removeTeam(FootballLeague_Manager.Team teamRemoved) {

        this.teamList.remove(teamRemoved);
    }

    /**
     * Returns a string representation of the football league, including a ranking of the teams based on their points.
     *
     * @return a string representation of the football league
     */
    public String toString() {
        String output = "";
        output += "FootballLeague: " + this.idFootballLeague + "\n";
        this.position = 1;
        for (FootballLeague_Manager.Team team : this.teamList) {
            output += "\nRanking " + this.position.toString() + "\n";
            output += team;
            this.position += 1;
        }
        return output;
    }



    /**
     * Simulates a match between the two given teams and updates their win, loss, and draw count accordingly.
     * The teams are also sorted by points after the match.
     *
     * @param t1 the first team
     * @param t2 the second team
     */
    public void win(FootballLeague_Manager.Team t1, FootballLeague_Manager.Team t2) {
        Random wincal = new Random(3);
        if (wincal.nextInt() == 1) {
            t1.draw();
            t2.draw();
            t1.mplayed();
            t2.mplayed();
        } else if (wincal.nextInt() == 2) {
            t2.increaseWin();
            t1.increaseLosses();
            t1.mplayed();
            t2.mplayed();
        } else {

            t1.increaseWin();
            t2.increaseLosses();
            t1.mplayed();
            t2.mplayed();

        }
        Collections.sort(this.teamList);
    }

    public void win2(FootballLeague_Manager.Team t3, FootballLeague_Manager.Team t4) {

        Random wincal = new Random(3);
        if (wincal.nextInt() == 1) {
            t4.increaseLosses();
            t3.increaseWin();
            t4.mplayed();
            t3.mplayed();


        } else if (wincal.nextInt() == 2) {
            t4.increaseWin();
            t3.increaseLosses();
            t3.mplayed();
            t4.mplayed();
        } else {
            t4.draw();
            t3.draw();
            t3.mplayed();
            t4.mplayed();

        }
        Collections.sort(this.teamList);
    }

    /**
     * Simulates the promotion and relegation process between two football leagues.
     * The bottom 3 teams in the first league are relegated to the second league,
     * and the top 3 teams in the second league are promoted to the first league.
     *
     * @param fl1 the first football league
     * @param fl2 the second football league
     */
    public void relegation(FootballLeague fl1, FootballLeague fl2) {
        for (int i = 0; i < 3; i++) {
            // Get the team at position three in the teamList
            FootballLeague_Manager.Team tmp = teamList.get(3);

            // Print a message announcing that the team will be removed
            System.out.println("Team: " + tmp.getName() + " will be removed from the list!");
            System.out.println("Due to their low points which are mentioned below");
            System.out.println("--------------------------------------------------------------------");

            // Print the team's points
            System.out.println("Team " + tmp.getName() + " has " + tmp.getPoints() + " points.");
            System.out.println("--------------------------------------------------------------------");

            // Remove the team from the league
            fl1.removeTeam(tmp);

            // Get the team that will be promoted from the second league
            FootballLeague_Manager.Team promotedTeam = fl1.teamList.get((i));

            // Print a message announcing the team's promotion
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Team " + promotedTeam.getName() + " will be promoted to the first league!");
            System.out.println("--------------------------------------------------------------------");

            // Promote the team
            fl2.addNewTeam(promotedTeam);
            fl2.removeTeam(fl2.teamList.get(0));

            // Add the removed team to the second league
            fl2.addNewTeam(tmp);
        }
    }

    public void win3(FootballLeague_Manager.Team t6, FootballLeague_Manager.Team t5) {

        Random wincal = new Random(3);
        if (wincal.nextInt() == 1) {
            t6.increaseWin();
            t5.increaseLosses();
            t6.mplayed();
            t5.mplayed();
        } else if (wincal.nextInt() == 2) {
            t5.draw();
            t6.draw();
            t5.mplayed();
            t6.mplayed();


        } else {
            t5.increaseWin();
            t6.increaseLosses();
            t6.mplayed();
            t5.mplayed();
        }
        Collections.sort(this.teamList);//he Collections.sort method is used to sort the list of teams in ascending order by points.
        System.out.println(this);
    }

    /**
     * Simulates a series of matches between the teams in the league and updates their win, loss, and draw count accordingly.
     * The teams are also sorted by points after all matches have been played.
     *
     * @param t1 the first team
     * @param t2 the second team
     * @param t3 the third team
     * @param t4 the fourth team
     * @param t5 the fifth team
     * @param t6 the sixth team
     */
    public void automatch(FootballLeague_Manager.Team t1, FootballLeague_Manager.Team t2, FootballLeague_Manager.Team t3, FootballLeague_Manager.Team
            t4, FootballLeague_Manager.Team t6, FootballLeague_Manager.Team t5) {
        for (int i = 0; i <= 15; i++) {
            if (i == 1) {
                win(t1, t3);
            } else if (i == 2) {
                win(t1, t5);
            } else if (i == 3) {
                win(t1, t4);
            } else if (i == 4) {
                win(t1, t6);
            } else if (i == 5) {
                win(t2, t4);
            } else if (i == 6) {
                win(t2, t5);
            } else if (i == 7) {
                win(t2, t6);
            } else if (i == 8) {
                win(t3, t2);
            } else if (i == 10) {
                win(t5, t3);
            } else if (i == 11) {
                win(t6, t3);
            } else if (i == 12) {
                win(t4, t5);
            } else if (i == 13) {
                win(t4, t6);
            }

        }
        Collections.sort(this.teamList);
        System.out.println(this);
    }

    /**
     * Simulates a series of matches between the teams in the league and updates their win, loss, and draw count accordingly.
     * The teams are also sorted by points after all matches have been played.
     *
     * @param t7  the 7th team
     * @param t8  the 8th team
     * @param t9  the 9th team
     * @param t10 the 10th team
     * @param t11 the 11th team
     * @param t12 the 12 team
     */
    public void automatchl2(FootballLeague_Manager.Team t7, FootballLeague_Manager.Team t8, FootballLeague_Manager.Team t9, FootballLeague_Manager.Team
            t10, FootballLeague_Manager.Team t11, FootballLeague_Manager.Team t12) {
        for (int i = 0; i <= 13; i++) {
            if (i == 1) {
                win(t7, t9);
            } else if (i == 2) {
                win(t7, t11);
            } else if (i == 3) {
                win(t7, t12);
            } else if (i == 4) {
                win(t8, t10);
            } else if (i == 5) {
                win(t8, t11);
            } else if (i == 6) {
                win(t8, t12);
            } else if (i == 7) {
                win(t9, t8);
            } else if (i == 8) {
                win(t11, t9);
            } else if (i == 10) {
                win(t12, t9);
            } else if (i == 11) {
                win(t11, t10);
            } else if (i == 12) {
                win(t8, t10);
            } else if (i == 13) {
                win(t10, t12);
            }


        }
        Collections.sort(this.teamList);
        System.out.println(this);
    }
}


