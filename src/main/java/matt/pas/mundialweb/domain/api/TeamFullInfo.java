package matt.pas.mundialweb.domain.api;

public class TeamFullInfo {
    private String name;
    private int goalsScored;
    private int goalsConceded;
    private int goalsBalance;
    private int winValue;
    private int drwaValue;
    private int lostValue;

    public TeamFullInfo(String name, int goalsScored, int goalsConceded, int goalsBalance, int winValue, int drwaValue, int lostValue) {
        this.name = name;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.goalsBalance = goalsBalance;
        this.winValue = winValue;
        this.drwaValue = drwaValue;
        this.lostValue = lostValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getGoalsBalance() {
        return goalsBalance;
    }

    public void setGoalsBalance(int goalsBalance) {
        this.goalsBalance = goalsBalance;
    }

    public int getWinValue() {
        return winValue;
    }

    public void setWinValue(int winValue) {
        this.winValue = winValue;
    }

    public int getDrwaValue() {
        return drwaValue;
    }

    public void setDrwaValue(int drwaValue) {
        this.drwaValue = drwaValue;
    }

    public int getLostValue() {
        return lostValue;
    }

    public void setLostValue(int lostValue) {
        this.lostValue = lostValue;
    }
}
