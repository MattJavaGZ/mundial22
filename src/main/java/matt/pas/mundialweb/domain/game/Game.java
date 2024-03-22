package matt.pas.mundialweb.domain.game;

public class Game {
    private Integer id;
    private String team1Name;
    private int goalsTeam1;
    private String team2Name;
    private int goalsTeam2;

    public Game(String team1Name, int goalsTeam1, String team2Name, int goalsTeam2) {
        this.team1Name = team1Name;
        this.goalsTeam1 = goalsTeam1;
        this.team2Name = team2Name;
        this.goalsTeam2 = goalsTeam2;
    }

    public Game(Integer id, String team1Name, int goalsTeam1, String team2Name, int goalsTeam2) {
        this(team1Name, goalsTeam1, team2Name, goalsTeam2);
        this.id = id;
    }

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public int getGoalsTeam1() {
        return goalsTeam1;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public int getGoalsTeam2() {
        return goalsTeam2;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
