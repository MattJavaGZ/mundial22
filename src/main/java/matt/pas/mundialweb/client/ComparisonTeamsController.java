package matt.pas.mundialweb.client;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import matt.pas.mundialweb.domain.api.GameService;
import matt.pas.mundialweb.domain.api.TeamService;
import matt.pas.mundialweb.domain.game.Game;

import java.io.IOException;
import java.util.List;

@WebServlet("/comparison")
public class ComparisonTeamsController extends HttpServlet {

    TeamService teamService = new TeamService();
    GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String teamname1 = request.getParameter("teamname1");
        final String teamname2 = request.getParameter("teamname2");

        teamService.findTeamByName(teamname1).ifPresent(teamFullInfo -> request.setAttribute("team1", teamFullInfo));
        teamService.findTeamByName(teamname2).ifPresent(teamFullInfo -> request.setAttribute("team2", teamFullInfo));
        final List<Game> games = gameService.findByNames(teamname1, teamname2);
        request.setAttribute("games", games);
        request.getRequestDispatcher("WEB-INF/views/comparison-teams.jsp").forward(request, response);
    }
}
