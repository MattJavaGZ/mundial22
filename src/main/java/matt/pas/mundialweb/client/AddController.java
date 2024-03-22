package matt.pas.mundialweb.client;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import matt.pas.mundialweb.domain.api.GameService;
import matt.pas.mundialweb.domain.game.Game;

import java.io.IOException;

@WebServlet("/add")
public class AddController extends HttpServlet {
    GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String team1name = request.getParameter("team1name").toUpperCase();
        final int team1goals = Integer.parseInt(request.getParameter("team1goals"));
        final String team2name = request.getParameter("team2name").toUpperCase();
        final int team2goals = Integer.parseInt(request.getParameter("team2goals"));
        Game game = new Game(team1name, team1goals, team2name, team2goals);
        gameService.addGame(game);
        response.sendRedirect(request.getContextPath());
    }
}
