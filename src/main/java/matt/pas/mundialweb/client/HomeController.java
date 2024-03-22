package matt.pas.mundialweb.client;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import matt.pas.mundialweb.domain.api.GameService;
import matt.pas.mundialweb.domain.game.Game;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    GameService gameService = new GameService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<Game> games = gameService.allGames();
        request.setAttribute("games", games);
        request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
    }

}
