package matt.pas.mundialweb.client;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import matt.pas.mundialweb.domain.api.TeamService;

import java.io.IOException;
import java.util.List;

@WebServlet("/comparison-form")
public class ComparisonTeamsFormController extends HttpServlet {
    TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<String> teamsName = teamService.allTeamsName();
        request.setAttribute("names", teamsName);
        request.getRequestDispatcher("WEB-INF/views/comparison-teams-form.jsp").forward(request, response);
    }


}
