package pl.mfalkowski.appenginefirstapp.api.tasks;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CheckWykop", value = "/tasks/checkWykop")
public class CheckWykop extends HttpServlet {

    private static final Logger log = Logger.getLogger(CheckWykop.class.getName());

    private final DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    private Client client;
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        this.client = ClientBuilder.newClient();
        this.configuration = new Configuration(datastore);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("CheckWykop task submitted!");
        log.log(Level.FINE, "Wykop appKey: {0}", configuration.getWykopAppKey());
    }
}
