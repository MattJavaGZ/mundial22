package matt.pas.mundialweb.domain.game;

import matt.pas.mundialweb.domain.common.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDao extends BaseDao {

    public void addGame(Game game) {
        String sql = """
                INSERT INTO
                  matches (team1_name, goals_team1, team2_name, goals_team2)
                VALUES
                    (?,?,?,?)
                """;
        try (Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            statement.setString(1, game.getTeam1Name());
            statement.setInt(2, game.getGoalsTeam1());
            statement.setString(3, game.getTeam2Name());
            statement.setInt(4, game.getGoalsTeam2());
            statement.executeUpdate();

            final ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                game.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Game> allGames() {
        List<Game> allGames = new ArrayList<>();
        String sql = """
                SELECT
                    team1_name, goals_team1, team2_name, goals_team2
                FROM
                    matches
                """;
        try (Connection connection = getConnection();
             final Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Game game = createGame(resultSet);
                allGames.add(game);
            }
            return allGames;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Game createGame(ResultSet resultSet) throws SQLException {
        final String team1Name = resultSet.getString("team1_name");
        final int goalsTeam1 = resultSet.getInt("goals_team1");
        final String team2Name = resultSet.getString("team2_name");
        final int goalsTeam2 = resultSet.getInt("goals_team2");
        Game game = new Game(team1Name, goalsTeam1, team2Name, goalsTeam2);
        return game;
    }

    public List<Game> findByName(String teamName) {
        List<Game> list = new ArrayList<>();
        String sql = """
                SELECT
                    team1_name, goals_team1, team2_name, goals_team2
                FROM
                    matches
                WHERE
                    team1_name=? OR team2_name=?
                """;
        try (Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, teamName);
            statement.setString(2, teamName);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Game game = createGame(resultSet);
                list.add(game);
            }
            return  list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Game> findGamesToComparison(String name1, String name2) {
        List<Game> list = new ArrayList<>();
        String sql = """
                SELECT
                    team1_name, goals_team1, team2_name, goals_team2
                FROM
                    matches
                WHERE
                    (team1_name=? OR team2_name=?) AND (team1_name=? OR team2_name=?)
                """;
        try (Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, name1);
            statement.setString(2, name1);
            statement.setString(3, name2);
            statement.setString(4, name2);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Game game = createGame(resultSet);
                list.add(game);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
