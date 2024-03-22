package matt.pas.mundialweb.domain.api;

import matt.pas.mundialweb.domain.game.Game;
import matt.pas.mundialweb.domain.game.GameDao;
import matt.pas.mundialweb.domain.team.Team;
import matt.pas.mundialweb.domain.team.TeamDao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TeamService {
    TeamDao teamDao = new TeamDao();
    GameDao gameDao = new GameDao();
    TeamMapper teamMapper = new TeamMapper();

    public Optional<TeamFullInfo> findTeamByName(String teamName) {
      return teamDao.findByName(teamName)
                .map(teamMapper::map);
    }

    public List<String> allTeamsName() {
        return teamDao.findAllTeamsName();
    }
    private Predicate<Game> winPredicate(String teamName) {
        return  game -> (game.getTeam1Name().equalsIgnoreCase(teamName) && game.getGoalsTeam1() > game.getGoalsTeam2()) ||
                (game.getTeam2Name().equalsIgnoreCase(teamName) && game.getGoalsTeam2() > game.getGoalsTeam1());
    }
    private Predicate<Game> lostPredicate(String teamName) {
        return  game -> (game.getTeam1Name().equalsIgnoreCase(teamName) && game.getGoalsTeam1() < game.getGoalsTeam2()) ||
                (game.getTeam2Name().equalsIgnoreCase(teamName) && game.getGoalsTeam2() < game.getGoalsTeam1());
    }
    private Predicate<Game> drawPredicate(String teamName) {
        return  game -> (game.getTeam1Name().equalsIgnoreCase(teamName) && game.getGoalsTeam1() == game.getGoalsTeam2()) ||
                (game.getTeam2Name().equalsIgnoreCase(teamName) && game.getGoalsTeam2() == game.getGoalsTeam1());
    }

    private int winChech(String teamName, Predicate<Game> predicate) {
        final List<Game> gamesList = gameDao.findByName(teamName);
         return (int) gamesList.stream()
                 .filter(predicate)
                .count();
    }

    private  class TeamMapper {

          TeamFullInfo map (Team team) {
            return new TeamFullInfo(
                    team.getName(),
                    team.getGoalsScored(),
                    team.getGoalsConceded(),
                    team.getGoalsBalance(),
                    winChech(team.getName(), winPredicate(team.getName())),
                    winChech(team.getName(), drawPredicate(team.getName())),
                    winChech(team.getName(), lostPredicate(team.getName()))
            );
        }
    }
}
