package matt.pas.mundialweb.client;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import matt.pas.mundialweb.domain.api.GameService;
import matt.pas.mundialweb.domain.api.TeamService;
import matt.pas.mundialweb.domain.game.Game;

import java.io.IOException;
import java.util.List;

@WebServlet("/stats")
public class SingleStatsController extends HttpServlet {

    TeamService teamService = new TeamService();
    GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String userTeamName = request.getParameter("teamname");
        teamService.findTeamByName(userTeamName).ifPresent(teamFullInfo -> request.setAttribute("team", teamFullInfo));
        final List<Game> teamsByName = gameService.findByName(userTeamName);
        request.setAttribute("games", teamsByName);
        request.getRequestDispatcher("WEB-INF/views/single-team-stats.jsp").forward(request, response);

    }

}
