package pl.mfalkowski.appenginefirstapp.api.tasks;

import com.google.appengine.api.datastore.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuration {
    private static final Logger log = Logger.getLogger(Configuration.class.getName());
    private static final String ENTITY_NAME = "Properties";
    private static final String ENTITY_KIND = "Properties";
    private static final String WYKOP_APPKEY_PROPERTY = "wykop_appkey";

    private final DatastoreService datastore;
    private final Entity properties;

    public Configuration(DatastoreService datastore) {
        this.datastore = datastore;
        Entity properties;
        try {
            properties = datastore.get(KeyFactory.createKey(ENTITY_KIND, ENTITY_NAME));
            log.info("Configuration loaded");
        } catch (EntityNotFoundException e) {
            log.log(Level.WARNING, "Configuration not found in datastore!", e);
            properties = new Entity(ENTITY_KIND, ENTITY_NAME);
        }
        this.properties = properties;
    }

    public String getWykopAppKey() {
        return (String)properties.getProperty(WYKOP_APPKEY_PROPERTY);
    }
}
