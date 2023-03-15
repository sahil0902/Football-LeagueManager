package FootballLeague_Manager;

public class Dashboard {
    public static void main(String[] args) {
        /**
         * Creates 6 teams
         **/
        FootballLeague_Manager.Team t1 = new FootballLeague_Manager.Team("Liverpool");
        FootballLeague_Manager.Team t2 = new FootballLeague_Manager.Team("Manchester United");
        FootballLeague_Manager.Team t3 = new FootballLeague_Manager.Team("Chelsea");
        FootballLeague_Manager.Team t4 = new FootballLeague_Manager.Team("Arsenal");
        FootballLeague_Manager.Team t5 = new FootballLeague_Manager.Team("Tottenham Hotspur");
        FootballLeague_Manager.Team t6 = new FootballLeague_Manager.Team("Manchester City");
        FootballLeague_Manager.Team t13 = new FootballLeague_Manager.Team("Bury FC");

        FootballLeague fl1 = new FootballLeague("Prem League");
        FootballLeague fl2 = new FootballLeague("Max League");
        /* Adds t1,t2...t6 teams to Prem League */
        fl1.addNewTeam(t1);
        fl1.addNewTeam(t13);
        fl1.addNewTeam(t2);
        fl1.addNewTeam(t3);
        fl1.addNewTeam(t4);
        fl1.addNewTeam(t5);
        fl1.addNewTeam(t6);
        //removes team Bury FC from the list
        fl1.removeTeam(t13);
        /* Adds t7,t8...t12 teams to Max League */
        FootballLeague_Manager.Team t7 = new FootballLeague_Manager.Team("Everton");
        FootballLeague_Manager.Team t8 = new FootballLeague_Manager.Team("Leicester City");
        FootballLeague_Manager.Team t9 = new FootballLeague_Manager.Team("West Ham United");
        FootballLeague_Manager.Team t10 = new FootballLeague_Manager.Team("Aston Villa");
        FootballLeague_Manager.Team t11 = new FootballLeague_Manager.Team("Newcastle United");
        FootballLeague_Manager.Team t12 = new FootballLeague_Manager.Team("Southampton");


        fl2.addNewTeam(t7);
        fl2.addNewTeam(t8);
        fl2.addNewTeam(t9);
        fl2.addNewTeam(t10);
        fl2.addNewTeam(t11);
        fl2.addNewTeam(t12);


        // Simulate matches between the teams in the first league
        fl1.automatch(t1, t2, t3, t4, t5, t6);

        // Perform the promotion and relegation process between the two leagues
        fl1.relegation(fl1, fl2);

        System.out.println("\n\n-AFTER RELEGATION-\n\n");

        // Simulate matches between the teams in the second league
        fl2.automatchl2(t7, t8, t9, t10, t11, t12);


    }
}
