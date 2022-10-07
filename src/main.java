import java.util.*;

class TeamDetails{
    String Names;
    int points;
    String[] lastFiveMatchStatus;

    TeamDetails(String Names,int points,String[] lastFiveMatchStatus){
        this.Names=Names;
        this.points=points;
        this.lastFiveMatchStatus=lastFiveMatchStatus;
    }

    public String toString() {
        return (" "+this.Names+"\t"+this.points+"\t"+
                Arrays.toString(this.lastFiveMatchStatus));
    }

    public String getTeamName() {
        return this.Names;
    }
    public int getPoints() {
        return this.points;
    }
    public String getlastFive(int n) {
        return lastFiveMatchStatus[n];
    }

}

public class main {
    static List<TeamDetails> List; //using List as a data structure to store the team data

    public static void main(String[] args) {

        List=new ArrayList<TeamDetails>();

        //adding all 10 teams data to the list
        List.add(new TeamDetails("GT",20, new String[] {"W","W","L","L","W"}));
        List.add(new TeamDetails("LSG",18, new String[] {"W","L","L","W","W"}));
        List.add(new TeamDetails("RR",16, new String[] {"W","L","W","L","L"}));
        List.add(new TeamDetails("DC",14, new String[] {"W","W","L","W","L"}));
        List.add(new TeamDetails("RCB",14, new String[] {"L","W","W","L","L"}));
        List.add(new TeamDetails("KKR",12, new String[] {"L","W","W","L","W"}));
        List.add(new TeamDetails("PBKS",12, new String[] {"L","W","L","W","L"}));
        List.add(new TeamDetails("SRH",12, new String[] {"W","L","L","L","L"}));
        List.add(new TeamDetails("CSK",8, new String[] {"L","L","W","L","W"}));
        List.add(new TeamDetails("MI",6, new String[] {"L","W","L","W","W"}));

        //Sort the team points
        List.sort(Comparator.comparing(TeamDetails::getPoints));
        System.out.println(" TeamDetails\\tPoints\\lastFiveMatchStatus \n");

        for(int index=List.size()-1;index>=0;index--) {
            System.out.println(List.get(index));
        }

        //taking the input to perform 2 consecutive win or loss
        Scanner userInput=new Scanner(System.in);
        System.out.println("Please enter W for Win or L for Loose :\n");
        String consecutiveUserInput=userInput.nextLine().toUpperCase();

        int totalPointsOfConsecutiveTeams=0;

        List<String> teamsWithMatchingConsecutive =new ArrayList<String>();

        for(int teamIndex=0;teamIndex<List.size();teamIndex++) {   //Looping over the List of team
            for(int matchStatusIndex=0;matchStatusIndex<4;matchStatusIndex++) {     //looping over the statusOfFive in Team class
                if(List.get(teamIndex).getlastFive(matchStatusIndex).equals(consecutiveUserInput) && List.get(teamIndex).getlastFive(matchStatusIndex+1).equals(consecutiveUserInput)) {
                    totalPointsOfConsecutiveTeams+=List.get(teamIndex).getPoints();
                    teamsWithMatchingConsecutive.add(List.get(teamIndex).getTeamName());
                    break;
                }

            }
        }

        System.out.println("Teams with 2 consecutive " +consecutiveUserInput+ " are : ");
        for(String teams:teamsWithMatchingConsecutive) {
            System.out.println(teams);
        }

        System.out.println("Average points of filtered teams: "+(totalPointsOfConsecutiveTeams/teamsWithMatchingConsecutive.size()));
    }
}