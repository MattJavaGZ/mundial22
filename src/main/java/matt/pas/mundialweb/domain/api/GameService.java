package matt.pas.mundialweb.domain.api;

import matt.pas.mundialweb.domain.game.Game;
import matt.pas.mundialweb.domain.game.GameDao;
import matt.pas.mundialweb.domain.team.Team;
import matt.pas.mundialweb.domain.team.TeamDao;

import java.util.List;

public class GameService {

    TeamDao teamDao = new TeamDao();
    GameDao gameDao = new GameDao();

    public void addGame(Game game) {
        Team team1 = new Team(game.getTeam1Name(), game.getGoalsTeam1(), game.getGoalsTeam2());
        Team team2 = new Team(game.getTeam2Name(), game.getGoalsTeam2(), game.getGoalsTeam1());
        teamDao.updateTeam(team1);
        teamDao.updateTeam(team2);
        gameDao.addGame(game);
    }
    public List<Game> allGames() {
        return gameDao.allGames();
    }
    public List<Game> findByName(String teamName) {
        return gameDao.findByName(teamName);
    }
    public List<Game> findByNames(String name1, String name2) {
        return gameDao.findGamesToComparison(name1, name2);
    }

}
