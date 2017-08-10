package pl.mfalkowski.appenginefirstapp.api.tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "CheckWykop", value = "/tasks/checkWykop")
public class CheckWykop extends HttpServlet {

    private static final Logger log = Logger.getLogger(CheckWykop.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("CheckWykop task submitted!");
    }
}
