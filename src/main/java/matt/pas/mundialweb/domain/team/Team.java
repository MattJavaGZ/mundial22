package matt.pas.mundialweb.domain.team;

public class Team {
    private String name;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name, int goalsScored, int goalsConceded) {
        this.name = name;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
    }

    public int getGoalsBalance(){
        return goalsScored-goalsConceded;
    }

    public String getName() {
        return name;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }
}
