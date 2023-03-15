package FootballLeague_Manager;

public class Team implements Comparable<Team> {
    // name: name of the team
    private String name;
    // wins: number of wins
    private Integer wins;
    // draws: number of draws
    private Integer draws;
    // losses: number of losses

    private Integer losses;
    // points: number of points the team has earned
    private Integer points;
    // played: number of matches played by the team
    private Integer played;


    public Integer getPlayed() {

        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }


    // Constructor for the Team class
    // Initializes the name of the team and sets the number of wins, draws, losses, and points to 0
    // Also initializes the number of matches played to 0
    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.points = 0;
        this.played = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    // Increments the number of wins and updates the points
    public void increaseWin() {
        this.wins += 1;
        updatePoints();
    }

    //increments the number of matches played
    public void mplayed() {
        this.played += 1;

    }

    // Increments the number of losses
    public void increaseLosses() {
        this.losses += 1;
    }

    // Updates the points based on the number of wins
    public void updatePoints() {
        this.points += 3;
    }

    // Increments the number of draws and increments the points by 1
    public void draw() {
        this.draws += 1;
        this.points += 1;
    }

    // Returns a string representation of the team
    public String toString() {
        String output = "";
        output += "Team{\n";
        output += "\tName  : " + this.name + "\n";
        output += "\tWins  : " + this.wins + "\n";
        output += "\tDraws : " + this.draws + "\n";
        output += "\tLosses: " + this.losses + "\n";
        output += "\tPoints: " + this.points + "\n";
        output += "\tMatches Played: " + this.played + "\n";
        output += "}";
        return output;
    }

    // Overrides the compareTo method of the Comparable interface
    @Override
    // Compares the points of the current team and the given team
    public int compareTo(Team o) {

        return -this.points.compareTo(o.points);
    }
}
