package matt.pas.mundialweb.domain.team;

import matt.pas.mundialweb.domain.common.BaseDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamDao extends BaseDao {


    public void updateTeam(Team team) {
        String sql = """
                INSERT INTO
                    teams (name, goals_scored, goals_conceded)
                VALUES
                    (?,?,?)
                ON DUPLICATE KEY UPDATE
                    goals_scored = ?,
                    goals_conceded= ?    
                """;
        try (Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, team.getName());
            statement.setInt(2, team.getGoalsScored());
            statement.setInt(3, team.getGoalsConceded());
            final Team newTeam = findByName(team.getName()).orElse(new Team("abc", 0, 0));
            int newGoalsScored = newTeam.getGoalsScored() + team.getGoalsScored();
            int newGolasConceded = newTeam.getGoalsConceded() + team.getGoalsConceded();
            statement.setInt(4, newGoalsScored);
            statement.setInt(5, newGolasConceded);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<Team> findByName(String teamName) {
        String sql = """
                SELECT
                    name, goals_scored, goals_conceded
                FROM
                    teams
                WHERE
                    name=?
                """;
        try (Connection connection = getConnection();
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, teamName);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int goalsScored = resultSet.getInt("goals_scored");
                int goalsConceded = resultSet.getInt("goals_conceded");
                return Optional.of(new Team(name, goalsScored, goalsConceded));
            } else return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> findAllTeamsName() {
        List<String> list = new ArrayList<>();
        String sql = """
                SELECT
                    name
                FROM
                    teams
                """;
        try (Connection connection = getConnection();
             final Statement statement = connection.createStatement())
        {
            final ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                final String name = resultSet.getString("name");
                list.add(name);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
